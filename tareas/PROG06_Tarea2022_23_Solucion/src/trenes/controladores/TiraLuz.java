package trenes.controladores;

import java.util.Random;

/**
 * Clase TiraLuz.
 *
 * Esta clase hereda de la clase ControlServicio e implementa la interfaz
 * Modificable (implementa los métodos aumentar() y disminiur()) y la interfaz
 * Activable (implementa los métodos on() y off()). Representa una tira o
 * columna de luces del vagón. Este control presenta como atributos un valor de
 * estado para saber si la tira está encendida o no. La ubicación de la tira de
 * luces. Un valor entero entre 0 y 100 para controlar la intensidad de la luz.
 * Así como, tres valores enteros entre 0 y 255 (ambos inclusive) para
 * determinar el color que se quiere establecer de la tira de luz, siguiendo el
 * sistema RGB (Rojo, Verde, Azul).
 *
 * Además para gestionar posibles funcionalidades aleatorias de la tira,
 * presenta un atributo de clase de tipo Random para generar esa aleatoriedad.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public final class TiraLuz extends ControlServicio implements Activable, Modificable {

    /**
     * Atributo aleatorio. Sirve para gestionar la funcionalidad aleatoria de la
     * tira de luz.
     */
    private static Random aleatorio = new Random();

    /**
     * Atributo encendida. Indica con sus dos estados si la tira de luz está
     * encendida o no
     */
    private boolean encendida;

    /**
     * Atributo ubicacionTira. Representa la cadena que indica la ubicación de
     * la tira de luz.
     */
    private String ubicacionTira;

    /**
     * Atributo intensidadTira. Valor entero entre 0 y 100 ambos inclusive para
     * representar la intensidad de la tira de luz.
     */
    private byte intensidadTira;

    /**
     * Atributo colorAzul. Valor entero entre 0 y 255 ambos inclusive para
     * representar la cantidad de color azul en el sistema RGB.
     */
    private int colorAzul;

    /**
     * Atributo colorVerde. Valor entero entre 0 y 255 ambos inclusive para
     * representar la cantidad de color verde en el sistema RGB.
     */
    private int colorVerde;

    /**
     * Atributo colorRojo. Valor entero entre 0 y 255 ambos inclusive para
     * representar la cantidad de color rojo en el sistema RGB.
     */
    private int colorRojo;

    /**
     * Constructor con siete parámetros de TiraLuz. Este constructor inicializa
     * el nombre del controlDeServicio de la clase padre o superclase con el
     * atributo pasado en septimo lugar. Por otra parte se inicializa el estado
     * de la tira para establecer si está encendida o no pasado como primer
     * parámetro. Como segundo parámetro se pasa la ubicación de la tira de
     * luces. Además se inicializa la intensidad de luz de la tira según el
     * valor pasado como tercer parámetro. Los parámetros cuarto, quinto y sexto
     * sirven para inicializar el color de la tira de luz con los respectivos
     * valores rojo, verde y azul.
     *
     * Y por último, se asigna al tipo de Control de Servicio de la superclase o
     * la clase padre el valor de "TiraLuz", identificando de esta forma el tipo
     * de Control de servicio que es.
     *
     * @param encendida Parámetro que establecerá el estado de la tira de liz,
     * encendido o apagado
     * @param ubicacionTira Parámetro que define la ubicación de la tira de luz
     * @param intensidadTira Parámetro para definir la intensidad de brillo de
     * la tira de luz
     * @param colorAzul Cantidad de color azul en el sistema RGB para la tira de
     * luz
     * @param colorVerde Cantidad de color verde en el sistema RGB para la tira
     * de luz
     * @param colorRojo Cantidad de color rojo en el sistema RGB para la tira de
     * luz
     * @param nombreControlServicio Nombre que se asgina a la tira de luz
     */
    public TiraLuz(boolean encendida, String ubicacionTira, byte intensidadTira, int colorAzul, int colorVerde,
            int colorRojo, String nombreControlServicio) {
        super(nombreControlServicio);
        super.tipoControlServicio = "TiraLuz";
        this.encendida = encendida;
        this.ubicacionTira = ubicacionTira;
        setIntensidadTira(intensidadTira);
        setColorAzul(colorAzul);
        setColorVerde(colorVerde);
        setColorRojo(colorRojo);
    }

    /**
     * Constructor con cuatro parámetros de TiraLuz. Este constructor inicializa
     * el nombre del controlDeServicio de la clase padre o superclase con el
     * atributo pasado en septimo lugar. Por otra parte se inicializa el estado
     * de la tira para establecer si está encendida o no pasado como primer
     * parámetro. Como segundo parámetro se pasa la ubicación de la tira de
     * luces. Además se inicializa la intensidad de luz de la tira según el
     * valor pasado como tercer parámetro.
     *
     * Los valores para el color Rojo, Verde y Azul se generarán automáticamente
     * con valores entre 0 y 255.
     *
     * Y por último, se asigna al tipo de Control de Servicio de la superclase o
     * la clase padre el valor de "TiraLuz", identificando de esta forma el tipo
     * de Control de servicio que es.
     *
     * @param encendida Parámetro que establecerá el estado de la tira de liz,
     * encendido o apagado
     * @param ubicacionTira Parámetro que define la ubicación de la tira de luz
     * @param intensidadTira Parámetro para definir la intensidad de brillo de
     * la tira de luz
     * @param nombreControlServicio Nombre que se asgina a la tira de luz
     */
    public TiraLuz(boolean encendida, String ubicacionTira, byte intensidadTira, String nombreControlServicio) {
        super(nombreControlServicio);
        super.tipoControlServicio = "TiraLuz";
        this.encendida = encendida;
        this.ubicacionTira = ubicacionTira;
        setIntensidadTira(intensidadTira);
        this.colorAzul = generarColorAleatorio();
        this.colorVerde = generarColorAleatorio();
        this.colorRojo = generarColorAleatorio();
    }

    /**
     * Método observador (getter) que devuelve el estado de la tira de luz
     *
     * @return encendida Estado de la tira de luz.
     */
    public boolean isEncendida() {
        return encendida;
    }

    /**
     * Método modificador (setter) que asigna el estado booleando para la tira
     * de luz, para establecer si está encendida o apagada.
     *
     * @param encendida valor booleano para el nuevo estado de la tira de luz.
     */
    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    /**
     * Método observador (getter) que devuelve la ubicación de la tira de luz
     *
     * @return ubicacionTira Ubicación de la tira de luz.
     */
    public String getUbicacionTira() {
        return ubicacionTira;
    }

    /**
     * Método modificador (setter) que establece la nueva ubicación a la tira de
     * luz.
     *
     * @param ubicacionTira Cadena que representa la ubicación de la tira de
     * luz.
     */
    public void setUbicacionTira(String ubicacionTira) {
        this.ubicacionTira = ubicacionTira;
    }

    /**
     * Método observador (getter) que devuelve la intensidad de brillo de la
     * tira de luz
     *
     * @return intensidadTira Intensidad de brillo de la tira de luz.
     */
    public byte getIntensidadTira() {
        return intensidadTira;
    }

    /**
     * Método modificador (setter) que establece la nueva intensidad de brillo
     * la tira de luz. Este valor se asignará si su valor está comprendido entre
     * 0 y 100 ambos inclusive.
     *
     * @param intensidadTira Intensidad de brillo de la tira de luz.
     */
    public void setIntensidadTira(byte intensidadTira) {
        if (intensidadTira >= 0 && intensidadTira <= 100) {
            this.intensidadTira = intensidadTira;
        }
    }

    /**
     * Método observador (getter) que devuelve el valor de la cantidad de color
     * azul de la tira de luz
     *
     * @return colorAzul Cantidad de color azul de la tira de luz.
     */
    public int getColorAzul() {
        return colorAzul;
    }

    /**
     * Método modificador (setter) que establece la cantidad de color azul de la
     * tira de luz. Este valor se asignará si su valor está comprendido entre 0
     * y 255 ambos inclusive.
     *
     * @param colorAzul Cantidad de color azul de la tira de luz.
     */
    public void setColorAzul(int colorAzul) {
        if (colorAzul >= 0 && colorAzul <= 255) {
            this.colorAzul = colorAzul;
        }
    }

    /**
     * Método observador (getter) que devuelve el valor de la cantidad de color
     * verde de la tira de luz
     *
     * @return colorVerde Cantidad de color verde de la tira de luz.
     */
    public int getColorVerde() {
        return colorVerde;
    }

    /**
     * Método modificador (setter) que establece la cantidad de color verde de
     * la tira de luz. Este valor se asignará si su valor está comprendido entre
     * 0 y 255 ambos inclusive.
     *
     * @param colorVerde Cantidad de color verde de la tira de luz.
     */
    public void setColorVerde(int colorVerde) {
        if (colorVerde >= 0 && colorVerde <= 255) {
            this.colorVerde = colorVerde;
        }
    }

    /**
     * Método observador (getter) que devuelve el valor de la cantidad de color
     * rojo de la tira de luz
     *
     * @return colorRojo Cantidad de color rojo de la tira de luz.
     */
    public int getColorRojo() {
        return colorRojo;
    }

    /**
     * Método modificador (setter) que establece la cantidad de color rojo de la
     * tira de luz. Este valor se asignará si su valor está comprendido entre 0
     * y 255 ambos inclusive.
     *
     * @param colorRojo Cantidad de color rojo de la tira de luz.
     */
    public void setColorRojo(int colorRojo) {
        if (colorRojo >= 0 && colorRojo <= 255) {
            this.colorRojo = colorRojo;
        }
    }

    /**
     * Método estático generarColorAleatorio sin parámetros que genera un valor
     * aleatorio entre 0 y 255 (ambos inclusive).
     *
     * @return Número entre 0 y 255 generado
     *
     */
    private static int generarColorAleatorio() {
        return 1 + aleatorio.nextInt(255);
    }

    /**
     * Método cambiarColorTira sin parámetros que genera valores aleatorios para
     * cambiar los valores de los atributos rojo, verde y azul de la tira de luz
     */
    public void cambiarColorTira() {
        colorAzul = generarColorAleatorio();
        colorRojo = generarColorAleatorio();
        colorVerde = generarColorAleatorio();
    }

    /**
     * Método cambiarColorTira que asigna valores pasados como parámetro para
     * cambiar los valores de los atributos rojo, verde y azul de la tira de
     * luz. Estos valores deben estar entre 0 y 255 ambos inclusive
     *
     * @param rojo Cantidad de color rojo
     * @param verde Cantidad de color verde
     * @param azul Cantidad de color azul
     */
    public void cambiarColorTira(int rojo, int verde, int azul) {
        setColorAzul(azul);
        setColorAzul(verde);
        setColorAzul(rojo);
    }

    /**
     * Implementaión del método de la interfaz Modificable para aumentar la
     * intensidad en 10 unidades. En caso de estar en el valor máximo 100, no se
     * aumenta
     *
     * @throws IllegalStateException si la tira de luz ya está en su valor
     * máximo
     */
    @Override
    public void aumentar() throws IllegalStateException {
        if (this.intensidadTira > Modificable.MAX-10) {
            throw new IllegalStateException("La tira de luz ya está en su valor máximo");
        }
        setIntensidadTira((byte) (intensidadTira + 10));
    }

    /**
     * Implementaión del método de la interfaz Modificable para disminiur la
     * intensidad en 10 unidades. En caso de estar en el valor mínimo 0, no se
     * disminuye
     *
     * @throws IllegalStateException si la tira de luz ya está en su valor
     * mínimo
     *
     */
    @Override
    public void disminuir() throws IllegalStateException {
        if (this.intensidadTira < Modificable.MIN+10) {
            throw new IllegalStateException("La tira de luz ya está en su valor mínimo");
        }
        setIntensidadTira((byte) (intensidadTira - 10));
    }

    /**
     * Implementaión del método de la interfaz Activable para encender control
     * de servicio, se establece el valor de encendida a true.
     *
     * @throws IllegalStateException si la tira de luz ya está encendida
     */
    @Override
    public void on() throws IllegalStateException {
        if (this.isEncendida()) {
            throw new IllegalStateException("Tira de luz ya encendida");
        }
        encendida = true;
    }

    /**
     * Implementaión del método de la interfaz Activable para apagar control de
     * servicio, se establece el valor de encendida a false.
     *
     * @throws IllegalStateException si la tira de luz ya está apagada
     */
    @Override
    public void off() throws IllegalStateException {
        if (!this.isEncendida()) {
            throw new IllegalStateException("Tira de luz ya apagada");
        }
        encendida = false;
    }

    /**
     * Método toString devuelve un String con los valores actuales de los
     * atributos tanto de esta clase como de la superclase. Cada atributo
     * aparecerá en una línea y su tabulación
     *
     * @return Cadena con los valores de los atributos
     *
     */
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder(super.toString());

        aux.append("\n\tLuz \n\t\tTira Luz: " + ((encendida) ? "Encendida" : "Apagada") + "\n\t\tUbicacion Tira Luz: "
                + ubicacionTira + "\n\t\tIntensidad Luz: " + intensidadTira + "\n\t\tColor RGB: (" + String.format("\u001B[31m%s", colorRojo ) +  String.format("\u001B[30m%s","," )
                + String.format("\u001B[32m%s", colorVerde )+ String.format("\u001B[30m%s","," ) + String.format("\u001B[34m%s", colorAzul ) + String.format("\u001B[30m%s",")" ));

        return aux.toString();
    }

}
