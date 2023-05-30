package trenes;

import trenes.controladores.Modificable;
import trenes.controladores.TiraLuz;
import trenes.controladores.ControlServicio;
import trenes.controladores.VentanillaVagon;
import trenes.controladores.PuertaVagon;
import trenes.controladores.ConjuntoAltavoces;

/**
 * Clase Lanzadera de la aplicación. Esta clase Tren contiene el método main
 * para realizar la ejecución del proyecto.
 *
 * @author David - IES Trassierra
 * @version 1.0
 *
 */
public class Tren {

    public static void main(String[] args) {

        // 1. Crear un array de 10 objetos tipo Control Servicio en una variable llamada
        // controlesVagon
        ControlServicio[] controlesVagon = new ControlServicio[10];

        // 2. Creamos dos objetos ConjuntoAltavoces, y los agregamos al array en las
        // posiciones 0 y 1 del mismo
        ConjuntoAltavoces altavocesTechoVagon1 = new ConjuntoAltavoces("Melodía Renfe", "Vagon 1 Altavoces Techo");
        ConjuntoAltavoces altavocesLateralesVagon1 = new ConjuntoAltavoces("Melodía Renfe",
                "Vagon 1 Altavoces Laterales");
        controlesVagon[0] = altavocesTechoVagon1;
        controlesVagon[1] = altavocesLateralesVagon1;

        // 3. Creamos dos objetos PuertaVagonTren, y los agregamos al array en las
        // posiciones 2 y 3 del mismo
        PuertaVagon puerta1Vagon1 = new PuertaVagon("Vagon 1 Trasera", "Puerta Trasera");
        PuertaVagon puerta2Vagon1 = new PuertaVagon("Vagon 1 Delantera", "Puerta Delantera");
        controlesVagon[2] = puerta1Vagon1;
        controlesVagon[3] = puerta2Vagon1;

        // 4. Creamos cuatro objetos VentanillaVagon, y los agregamos al array en las
        // posiciones 4,5,6 y 7 del mismo
        VentanillaVagon ventanilla1IzquierdaVagon1 = new VentanillaVagon("Vagon 1 Ventanilla Delantera Izquierda",
                "VDI");
        VentanillaVagon ventanilla2IzquierdaVagon1 = new VentanillaVagon("Vagon 1 Ventanilla Trasera Izquierda", "VTI");
        VentanillaVagon ventanilla1DerechaVagon1 = new VentanillaVagon("Vagon 1 Ventanilla Delantera Derecha", "VDD");
        VentanillaVagon ventanilla2DerechaVagon1 = new VentanillaVagon("Vagon 1 Ventanilla Trasera Derecha", "VTD");
        controlesVagon[4] = ventanilla1IzquierdaVagon1;
        controlesVagon[5] = ventanilla2IzquierdaVagon1;
        controlesVagon[6] = ventanilla1DerechaVagon1;
        controlesVagon[7] = ventanilla2DerechaVagon1;

        // 5. Creamos dos objetos TiraLuz, y los agregamos al array en las posiciones 8
        // y 9 del mismo
        TiraLuz tiraIzquierdaVagon1 = new TiraLuz(true, "Vagon 1 Tira Izquierda", (byte) 0, "Tira Luz Izquierda");
        TiraLuz tiraDerechaVagon1 = new TiraLuz(true, "Vagon 1 Tira Derecha", (byte) 0, "Tira Luz Derecha");
        controlesVagon[8] = tiraIzquierdaVagon1;
        controlesVagon[9] = tiraDerechaVagon1;

        /*
		 * 6. Se instancia o crea un objeto de tipo VagonTren. Para ello utilizamos, el
		 * constructor de VagonTren al que se le pasa como parámetro el array de
		 * objetos de tipo ControlServicio
         */
        VagonTren vagon = new VagonTren("Renfe", "Vagón número 2138", controlesVagon);

        /*
		 * 7. Se imprime el objeto de tipo VagonTren. Para ello directamente imprimimos
		 * el objeto (ya que al tener creado el método toString() imprimirá toda la
		 * información)
         */
        System.out.println(vagon);

        /*
		 * 8. Mediante un bucle recorremos el array de objetos de tipo ControlServicio
		 * que hay en el objeto de tipo VagonTren creado anteriormente en el punto 6, y
		 * en el caso de que el objeto sea una instancia con interfaz "Modificable", se
		 * llamará al método aumentar() para que cada tipo de control de servicio
		 * ejecute el código correspondiente a la implementación de dicha interfaz. En
		 * el caso de que no sea una instancia con interfaz modificable, comprobamos si
		 * es una instancia de la clase TiraLuz, en cuyo caso, se realizan dos acciones
		 * por un lado cambiar el color de la tira (cambiarColorTira() sin parámetros)
		 * por otro lado la llamada al método on, para encender todas las Tiras de Luz
         */
        for (int i = 0; i < vagon.getServicios().length; i++) {
            if (vagon.getServicios()[i] instanceof Modificable) {
                ((Modificable) vagon.getServicios()[i]).aumentar();
            } else if (vagon.getServicios()[i] instanceof TiraLuz) {
                ((TiraLuz) vagon.getServicios()[i]).cambiarColorTira();
                ((TiraLuz) vagon.getServicios()[i]).on();

            }
        }

        /*
		 * 9. Nuevamente se imprime el objeto de tipo VagonTren para ver los cambios
		 * realizados. Para ello directamente imprimimos el objeto (ya que al tener
		 * creado el método toString() imprimirá toda la información)
         */
        System.out.println(vagon);

        /* 10. Se realiza la llamada al método preaparado para cerrar todas puertas, 
         * implementado en la clase VagonTren. Si se quiere hacer de otra forma 
         * también se puede mediante un bucle recorremos el array de objetos de tipo 
         * PuertaVagonTren en el que hay en el objeto de tipo VagonTren creado anteriormente
         * en el punto 6, abrimos todas las PuertaVagonTren, para ello debemos comprobar
         * si cada elemento del array es una instancia del tipo PuertaVagonTren, y
	 * posteriormente llamar al método on()
         */
        vagon.cerrarPuertas();

        /*
		 * 11. Nuevamente se imprime el objeto de tipo VagonTren para ver los cambios
		 * realizados. Para ello directamente imprimimos el objeto (ya que al tener
		 * creado el método toString() imprimirá toda la información)
         */
        System.out.println(vagon);
        
        /* 12. Se realiza la llamada al método preaparado para activar todos los 
         * controles de servicio implementado en la clase VagonTren. 
         */
        vagon.activarTodosServicios();

        /*
		 * 13. Nuevamente se imprime el objeto de tipo VagonTren para ver los cambios
		 * realizados. Para ello directamente imprimimos el objeto (ya que al tener
		 * creado el método toString() imprimirá toda la información)
         */
        System.out.println(vagon);


    }

}
