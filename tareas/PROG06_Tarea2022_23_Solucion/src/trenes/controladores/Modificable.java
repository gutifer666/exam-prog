package trenes.controladores;

/**
 * Interfaz Modificable.
 *
 * Esta interfaz representa a la funcionalidad de elementos que se puedan
 * cambiar o modificar su estado aumentando o disminuyendo algún parámetro, es
 * decir, subir o bajar el volumen, aumentar o disminuir la intensidad,
 * opacidad, etc. A los elementos que puedan presentar variaciones de valor en
 * algún parámetro.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public interface Modificable {

    /**
     * Mínima valor posible para el estado del control de servicio:
     * {@value MIN}.
     */
    public static final int MIN = 0;
    /**
     * Máxima valor posible para el estado del control de servicio:
     * {@value MAX}.
     */
    public static final int MAX = 100;

    /**
     * Definición del método para aumentar un parámetro
     * @throws IllegalStateException si el elemento ya está en su valor máximo
     */
    public void aumentar() throws IllegalStateException;

    /**
     * Definición del método para disminuir un parámetro
     * @throws IllegalStateException si el elemento ya está en su valor mínimo
     */
    public void disminuir() throws IllegalStateException;

}
