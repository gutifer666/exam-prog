package trenes.controladores;

/**
 * Clase ConjuntoAltavoces.
 *
 * Esta clase hereda de la clase ControlServicio e implementa la interfaz
 * Modificable (implementa los métodos aumentar() y disminiur()). Representa un
 * determinado conjunto de altavoces de un vagon. Este control presenta como
 * atributos el nombre de la pista o melodía que se está reproduciendo, así como
 * el volumen de salida de sonido del conjunto de altavoces.
 *
 * @author David - IES Trassierra
 * @version 1.0
 *
 */
public final class ConjuntoAltavoces extends ControlServicio implements Modificable {

    /**
     * Atributo pistaReproduciendo. Sirve para identificar la pista, melodía o
     * locución de este tipo de control de servicio.
     */
    private String pistaReproduciendo;

    /**
     * Atributo volumenReproduccion. Representa el volumen de salida de sonido
     * del conjunto de altavoces.
     */
    private byte volumenReproduccion;

    /**
     * Constructor con tres parámetros de ConjuntoAltavoces. Este constructor
     * inicializa el nombre del controlDeServicio de la clase padre o superclase
     * con el atributo pasado en tercer lugar. Por otra parte se inicializa la
     * pista que se está reproduciendo con el String pasado como primer
     * parámetro Además se inicializa el volumen de reproducción según el valor
     * pasado como segundo parámetro. Y por último, asignamos al tipo de Control
     * de Servicio de la superclase o la clase padre el valor de "Altavoz",
     * identificando de esta forma el tipo de Control de servicio que es.
     *
     * @param pistaReproduciendo pista, melodía o locución de este tipo de
     * control de servicio.
     * @param volumenReproduccion Volumen de salida de sonido del conjunto de
     * altavoces.
     * @param nombreControlServicio nombre que se le va a asignar a este tipo de
     * control de Servicio.
     */
    public ConjuntoAltavoces(String pistaReproduciendo, byte volumenReproduccion, String nombreControlServicio) {
        super(nombreControlServicio);
        this.pistaReproduciendo = pistaReproduciendo;
        this.volumenReproduccion = volumenReproduccion;
        super.tipoControlServicio = "Altavoz";

    }

    /**
     * Constructor con dos parámetros de ConjuntoAltavoces. Este constructor
     * inicializa el nombre del controlDeServicio de la clase padre o superclase
     * con el atributo pasado en segundo lugar. Por otra parte se inicializa la
     * pista que se está reproduciendo con el String pasado como primer
     * parámetro Además se inicializa el volumen de reproducción a cero. Y por
     * último, asignamos al tipo de Control de Servicio de la superclase o la
     * clase padre el valor de "Altavoz", identificando de esta forma el tipo de
     * Control de servicio que es.
     *
     * @param pistaReproduciendo pista, melodía o locución de este tipo de
     * control de servicio.
     * @param nombreControlServicio nombre que se le va a asignar a este tipo de
     * control de Servicio.
     */
    public ConjuntoAltavoces(String pistaReproduciendo, String nombreControlServicio) {
        super(nombreControlServicio);
        this.pistaReproduciendo = pistaReproduciendo;
        this.volumenReproduccion = 0;
        super.tipoControlServicio = "Altavoz";

    }

    /**
     * Método observador (getter) que devuelve la pista o melodia que se está
     * reproduciendo
     *
     * @return pistaReproduciendo Pista en reproducción actualmente.
     */
    public String getPistaReproduciendo() {
        return pistaReproduciendo;
    }

    /**
     * Método modificador (setter) que asigna el nombre de la nueva pista que se
     * va a reproducir en el control de servicio.
     *
     * @param pistaReproduciendo nombre de la nueva pista que se va a reproducir
     * en el control de servicio.
     */
    public void setPistaReproduciendo(String pistaReproduciendo) {
        this.pistaReproduciendo = pistaReproduciendo;
    }

    /**
     * Método observador (getter) que devuelve el volumen actual de reproducción
     *
     * @return volumenReproduccion Volumen actual de reproducción
     */
    public byte getVolumenReproduccion() {
        return volumenReproduccion;
    }

    /**
     * Método modificador (setter) que asigna nuevo volumen de reproducción para
     * este control de servicio. Este nuevo valor no se asigna si no está entre
     * 0 y 100 ambos inclusive
     *
     * @param volumenReproduccion Nuevo volumen de reproducción.
     */
    public void setVolumenReproduccion(byte volumenReproduccion) {
        if (volumenReproduccion >= Modificable.MIN && volumenReproduccion <= Modificable.MAX) {
            this.volumenReproduccion = volumenReproduccion;
        }
    }

    /**
     * Implementaión del método de la interfaz Modificable para aumentar el
     * volumen en 1. En caso de estar en el valor máximo 100, no se aumenta
     * @throws IllegalStateException si el altavoz ya está en su valor máximo de
     * volumen
     */
    @Override
    public void aumentar() throws IllegalStateException {
        if (this.volumenReproduccion >= Modificable.MAX) {
            throw new IllegalStateException("El volumen de reproducción ya está en su valor máximo (100%)");
        }
        setVolumenReproduccion((byte) (volumenReproduccion + 1));
    }

    /**
     * Implementaión del método de la interfaz Modificable para disminiur el
     * volumen en 1. En caso de estar en el valor mínimo 0, no se disminuye
     * @throws IllegalStateException si el altavoz ya está en su valor mínimo de
     * volumen
     */
    @Override
    public void disminuir() throws IllegalStateException {
        if (this.volumenReproduccion <= Modificable.MIN) {
            throw new IllegalStateException("El volumen de reproducción ya está en su valor mínimo (0%)");
        }
        setVolumenReproduccion((byte) (volumenReproduccion - 1));

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

        aux.append("\n\tConjunto Altavoces\n\t\tSonido Reproduciendo: " + pistaReproduciendo + "\n\t\tVolumen: "
                + volumenReproduccion);

        return aux.toString();
    }

}
