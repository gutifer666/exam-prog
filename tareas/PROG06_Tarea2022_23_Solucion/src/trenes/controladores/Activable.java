package trenes.controladores;

/**
 * Interfaz Activable.
 *
 * Esta interfaz representa a la funcionalidad de elementos que se puedan
 * activar o desactivar, es decir, apagar o encender, abrir o cerrar, etc. A los
 * elementos que puedan presentar dos estados.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public interface Activable {


    /**
     * Definición del método para activación del elemento
     *
     * @throws IllegalStateException si el elemento ya estaba activado
     *
     */
    public void on() throws IllegalStateException;

    /**
     * Definición del método para desactivación del elemento
     *
     * @throws IllegalStateException si el elemento ya estaba activado
     *
     */
    public void off() throws IllegalStateException;

}
