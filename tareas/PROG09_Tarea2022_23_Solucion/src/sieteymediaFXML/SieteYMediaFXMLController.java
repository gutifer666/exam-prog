package sieteymediaFXML;

import sieteymedia.Carta;
import sieteymedia.SieteYMedia;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sieteymedia.Mazo;

/**
 * FXML Controller class
 *
 * @author Profesorado
 */
public class SieteYMediaFXMLController implements Initializable {

    private SieteYMedia juego; // instancia para almacenar la lógica del juego
    
    private int numTotalJugadores; // número de jugadores que participan
    private int jugadorTurno; // a quién le toca el turno
    
    /* Cola donde se van a almacenar los IDs de los jugadores activos en cada momentos. Cuando el jugador finaliza la partida, 
    bien porque se plante o porque se pase, será eliminado de esta cola. El jugador en primera posición (poll) será el que 
    tenga el turno, cuando termine de jugar se colocará en última posición (offer).*/
    private Queue<Integer> jugadoresActivos = new LinkedList<Integer>();
    
    // controles FXML relacionados con la interfaz
    @FXML private AnchorPane main;
    @FXML private Label menu;
    @FXML private Button comenzar, salir;

    @FXML private Button carta1, carta2, carta3, carta4, plantar1, plantar2, plantar3, plantar4;
    @FXML private TextArea textAreaJug1, textAreaJug2, textAreaJug3, textAreaJug4;

    @FXML private Label text1, text2, text3, text4;
    @FXML private ToggleGroup numJugadores;
    @FXML private RadioButton radioButton1Jug, radioButton2Jug, radioButton3Jug, radioButton4Jug;
    @FXML private ImageView win1, win2, win3, win4, lose1, lose2, lose3, lose4;
    @FXML private Pane panel1, panel2, panel3, panel4;

    
    // Método para inicializar la interfaz de usuario y prepara la partida reiniciando los controles.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reiniciaJuego(); //Comenzamos la partida reiniciando controles
    }

    /**
     * Cuando pulsamos el botón comenzar, comprobamos si se ha elegido el número de jugadores. 
     * Si no es así, se muestra un mensaje de error. Si se han elegido los jugadores, hacemos 
     * visibles los paneles de los jugadores que están jugando y añadimos a la cola el 
     * identificador de los jugadores (1, 2, 3...) que están jugando.
     *
     * @param event Evento que desencadena el inicio del juego (clic en botón Comenzar)
     * @throws Excepción si no se ha podido comenzar la partida (no se seleccionaron jugadores)
     */
    @FXML
    private void comenzarJuego(ActionEvent event) throws RuntimeException {
        
        juego = new SieteYMedia(); // creación del juego (en la variable juego se lleva el control de la baraja, jugadores, cartas, etc)
        reiniciaJuego();           // al comenzar cada juego se reinician todos los controles, botones, etc. 
        
        try {
            // comprobar si se han elegido los jugadores totales que participarán 
            numTotalJugadores =  Integer.parseInt( ((RadioButton)numJugadores.getSelectedToggle()).getText().substring(0,1) ) ;
            
            // meter IDs de jugadores en la cola (1, 2, 3 ...)
            for(int i = 1; i<=numTotalJugadores; i++) {
                ((Label)main.lookup("#text"+i)).setText("Jugador " + i);
                jugadoresActivos.offer(i); // introduce jugadores (IDs) en la cola
                
                // hacer visibles los paneles principales de los jugadores que están participando
                ((Pane)main.lookup("#panel"+i)).setVisible(true);
            }
        }         
        catch(RuntimeException e){
            // si no se han elegido los jugadores, mostrar un mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Siete y Media");        
            alert.setContentText("Debes elegir el número de jugadores para la partida");
            alert.showAndWait();
        }

        siguienteTurno(); // pasamos el turno al siguiente jugador
    }


    /**
     * Obtiene el ID del jugador al que le toca (el primero de la cola) 
     * y habilita sus controles de juego.
     */
    private void siguienteTurno() {
        
        // deshabilitar los controles de todos los jugadores
        deshabilitarTodosControles(); 
        
        // si hay jugadores aún jugando (su ID está en la cola)
        if(jugadoresActivos.size()>0){
            // obtener de la cola el ID de jugador en posesión del turno
            jugadorTurno = jugadoresActivos.poll();
            // activar solo los controles de este jugador
            ((TextArea)main.lookup("#textAreaJug"+jugadorTurno)).appendText("\n\n¿Quieres una carta?\n");
            ((Button)main.lookup("#carta"+jugadorTurno)).setDisable(false);
            ((Button)main.lookup("#plantar"+jugadorTurno)).setDisable(false);
            BackgroundFill backgroundFill = new BackgroundFill(Color.web("#FF0"), null, null);
            Background bg = new Background(backgroundFill);
            ((Pane)main.lookup("#panel"+jugadorTurno)).setBackground( bg);
            
        }
        else { 
            // si no quedan jugadores aún jugando (cola vacía) se puede anunciar el ganador
            anunciaGanador();
        }
    }    

    /**
     * Calcula quién gana y muestra un mensaje con las puntuaciones finales. 
     * El ganador (o ganadores) serán aquellos que hacen 'siete y media' o que, 
     * quedando por abajo, se acercan más a 7,5 puntos.
     */
    private void anunciaGanador() {
        
        // deshabilitar todos los controles
        deshabilitarTodosControles(); 
        
        // determinar el jugador o jugadores con mayor puntuación
        float puntos[] = {  -1, // para mantener los índices 1,2,3,4 y evitar el índice 0
                            juego.jugador1.sumarPuntos(), 
                            juego.jugador2.sumarPuntos(), 
                            juego.jugador3.sumarPuntos(), 
                            juego.jugador4.sumarPuntos() 
                         };
        
        float puntuacionMaxima = 0;
        
        for (int i = 0; i < puntos.length; i++) {
            if(puntuacionMaxima<puntos[i] && puntos[i]<=7.5) puntuacionMaxima=puntos[i];
        }
        
        for(int i = 1 ; i<=numTotalJugadores; i++){
        
            if(puntos[i] > 7.5) {
                // mostrar mensajes si hay jugadores que se pasaron (puntuación > 7.5). En su caja de texto: Te pasate!
                ((TextArea)main.lookup("#textAreaJug"+i)).appendText("\n\nJugador " + i +": Te pasaste!!!");
                ((ImageView)main.lookup("#lose"+i)).setVisible(true);
            }
            else if(puntos[i] == puntuacionMaxima ) {
                // mostrar mensajes para los jugadores que obtuvieron la mejor puntuación. En su caja de texto: Enhorabuena, has ganado!
                ((TextArea)main.lookup("#textAreaJug"+i)).appendText("\n\nJugador " + i +": Enhorabuena, has ganado!!!");
                ((ImageView)main.lookup("#win"+i)).setVisible(true);
            }
            else {
                // mostrar mensajes para los jugadores que NO obtuvieron la mejor puntuación. En su caja de texto: Has obtenido X puntos
                ((TextArea)main.lookup("#textAreaJug"+i)).appendText("\n\nJugador " + i +": has obtenido " + puntos[i] + " puntos");
            }
        }
    }

    /**
     * Método para deshabilitar todos los botones 
     */
    private void deshabilitarTodosControles() {
        
        // para los 4 jugadores desactivar sus controles de juego
        for(int i = 1;i<=4;i++){   
            ((Button)main.lookup("#carta"+i)).setDisable(true);  // busca los botones carta1, carta2, carta3, ... y los desactiva
            ((Button)main.lookup("#plantar"+i)).setDisable(true); // busca los botones plantar1, plantar2, plantar3, ... y los desactiva
            BackgroundFill backgroundFill = new BackgroundFill(Color.web("#Ea8313"), null, null);
            Background bg = new Background(backgroundFill);
            ((Pane)main.lookup("#panel"+i)).setBackground(bg); // busca cada panel panel1, panel2, panel3, ... y les cambia el fondo
        }
    }    
    
    /**
     * Método para reiniciar los controles cuando comienza una partida
     */
    public void reiniciaJuego() {
        
        // para los 4 jugadores reiniciar todos sus elementos:
            
        for(int i = 1;i<=4;i++){   
            //  - vaciar el contenido de su caja de texto
            ((TextArea)main.lookup("#textAreaJug"+i)).clear();
            
            // - ocultar las imagenes ganador/perdedor
            ((ImageView)main.lookup("#win"+i)).setVisible(false);
            ((ImageView)main.lookup("#lose"+i)).setVisible(false);
            
            // desactivar los botones Carta/Plantarse
            ((Button)main.lookup("#carta"+i)).setDisable(true);
            ((Button)main.lookup("#plantar"+i)).setDisable(true);
            
             // ocultar el panel completo
            ((Pane)main.lookup("#panel"+i)).setVisible(false);
        }

        // resetear el número de jugadores total
        numTotalJugadores = 0;
        
        // vaciar la cola de jugadores
        jugadoresActivos.clear(); 
    }

 
    /**
     * Se obtiene una carta de la baraja, el jugador que tiene el turno la guarda en su mazo, 
     * y se calculan los puntos acumulados y se escribe la información en su caja de texto.
     * Si se ha pasado de 7.5 se indica un mensaje de finalización de su partida. Si no se 
     * ha pasado, el ID del jugador se vuelve a introducir en la cola en última posición (offer).
     * 
     * @param event Evento que desencadena la acción (clic en el botón Carta)
     */
    
    @FXML
    private void accionCarta(ActionEvent event) {
        
        Mazo jugadorActual; // para almacenar referencia a un jugador del juego (sus cartas, sus puntuaciones, etc)
        
        // identificar el jugador actual (el que tiene el turno). Según el turno, será juego.jugador1, juego.jugador2, etc.
        switch(jugadorTurno)
        {
            case 2:  jugadorActual = juego.jugador2;             break;
            case 3:  jugadorActual = juego.jugador3;             break;
            case 4:  jugadorActual = juego.jugador4;             break;            
            default: jugadorActual = juego.jugador1;             break;
        }
        
        // se extrae una carta de la baraja del juego
        Carta carta = juego.baraja.extraerCarta();
        
        // se inserta la carta extraida en el mazo del jugador
        jugadorActual.insertarCarta(carta);
        
        // se calculan los puntos totales del jugador
        float puntos = jugadorActual.sumarPuntos();
        
        // localizar la caja de texto del jugador (según el turno que sea) y se añade el texto con información de la carta obtenida, puntos, etc.
        TextArea textArea = (TextArea)main.lookup("#textAreaJug"+jugadorTurno);
        
        textArea.clear();
        textArea.appendText("\n\n");
        
        textArea.appendText(jugadorActual.mostrar()); //Se muestra la carta extraída
        textArea.appendText("\n\n\tTotal:  "+Float.toString(puntos)+"\n"); //Se muestran los puntos acumulados
        
        // determinar si el jugador puede seguir jugando o no 
        if (puntos > 7.5) {
            // si su puntuación pasa de 7.5 --> finaliza su participación (mostrar un mensaje)
            textArea.appendText("\nFin, te pasaste."); 
        } else if (puntos == 7.5) {
            // si su puntuación es 7.5 --> finaliza su participación (mostrar un mensaje)
            textArea.appendText("\n¡¡¡SIETE y MEDIA!!!"); 
        } else{
            // en cualquier otra situación --> continua en el juego (meter el ID del jugador en la última posición de la cola)
            jugadoresActivos.offer(jugadorTurno);
        }
        
        siguienteTurno(); // pasamos el turno al siguiente jugador
    }


    /**
     * Si el jugador se planta, mostramos los puntos acumulados y pasamos al
     * siguiente jugador
     * @param event Evento que desencadena la acción (clic en el botón Plantar)
     */
    @FXML
    private void accionPlantar(ActionEvent event) {
          
        Mazo jugadorActual; // para almacenar referencia a un jugador del juego (sus cartas, sus puntuaciones, etc)
        
        // identificar el jugador actual (el que tiene el turno). Según el turno, será juego.jugador1, juego.jugador2, etc.
        switch(jugadorTurno)
        {
            case 2:  jugadorActual = juego.jugador2;             break;
            case 3:  jugadorActual = juego.jugador3;             break;
            case 4:  jugadorActual = juego.jugador4;             break;         
            default:  jugadorActual = juego.jugador1;             break;
        }
        
        // calcular los puntos totales del jugador
        float puntos = jugadorActual.sumarPuntos();
        
        // localizar la caja de texto del jugador (según el turno que sea) y se añade el texto con la puntuación final obtenida
        TextArea textArea = (TextArea)main.lookup("#textAreaJug"+jugadorTurno);
        textArea.appendText("\nFin. Puntuación final: " + Float.toString(puntos) + " puntos.");

        siguienteTurno(); // pasamos el turno al siguiente jugador
    }
    
    /**
     * Cerramos la aplicación cuando cerramos el botón Salir
     * @param event Evento que desencadena la acción (clic en el botón Salir)
     */
    @FXML
    private void salirJuego(ActionEvent event) {
        System.exit(0); // cierra el programa
    }
}