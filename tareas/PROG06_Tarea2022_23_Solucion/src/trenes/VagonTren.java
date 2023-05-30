package trenes;

import trenes.controladores.ControlServicio;
import trenes.controladores.Activable;
import trenes.controladores.ConjuntoAltavoces;
import trenes.controladores.PuertaVagon;
import trenes.controladores.TiraLuz;
import trenes.controladores.VentanillaVagon;

/**
 * Clase VagonTren.
 *
 * Esta clase representa un vagon de tren donde se tiene un conjunto de
 * Controles de Servicio para controlar dicho vagón. Para ello esta clase cuenta
 * con un array de objetos de tipo ControlServicio.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public class VagonTren {

    /**
     * Atributo companyiaTrenes. Es el nombre de la compañía a la que pertenece
     * el vagón.
     */
    String companyiaTrenes;

    /**
     * Atributo descripcion. Es un conjunto (array) de Controles de Servicio
     * para controlar dicho vagón.
     */
    String descripcion;

    /**
     * Atributo servicios. Es un conjunto (array) de Controles de Servicio para
     * controlar dicho vagón.
     */
    ControlServicio[] servicios;

    /**
     * Constructor con tres parámetros de VagonTren. Incluyendo el número de
     * controles. Este constructor inicializa el array de Controles de Servicio,
     * a tantos elementos como indica el parámetro que se pasa al constructor.
     *
     * @param companyiaTrenes Nombre de la compañía de trenes a la que pertenece
     * el vagón
     * @param descripcion Descripción del vagón
     * @param numControles Número de elementos ControlServicio que va a tener el
     * vagón
     */
    public VagonTren(String companyiaTrenes, String descripcion, int numControles) {
        this.companyiaTrenes = companyiaTrenes;
        this.descripcion = descripcion;
        this.servicios = new ControlServicio[numControles];
    }

    /**
     * Constructor con tres parámetrosde ControlServicio para VagonTren.
     * Incluyendo el parámetro array de objetos de tipo ControlServicio. Este
     * constructor inicializa el array de Controles de Servicio, con el array
     * pasado como parámetro.
     *
     * @param companyiaTrenes Nombre de la compañía de trenes a la que pertenece
     * el vagón
     * @param descripcion Descripción del vagón
     * @param servicios Array de elementos ControlServicio que va a tener el
     * vagón
     */
    public VagonTren(String companyiaTrenes, String descripcion, ControlServicio[] servicios) {
        this.companyiaTrenes = companyiaTrenes;
        this.descripcion = descripcion;
        this.servicios = servicios;
    }

    /**
     * Método observador (getter) que devuelve el nombre de la compañía de
     * trenes a la que pertenece el vagón
     *
     * @return companyiaTrenes Nombre de la compañía de trenes a la que
     * pertenece el vagón
     */
    public String getCompanyiaTrenes() {
        return companyiaTrenes;
    }

    /**
     * Método modificador (setter) que establece el nombre de la compañía de
     * trenes a la que pertenece el vagón
     *
     * @param companyiaTrenes Nombre de la compañía de trenes a la que pertenece
     * el vagón
     */
    public void setCompanyiaTrenes(String companyiaTrenes) {
        this.companyiaTrenes = companyiaTrenes;
    }

    /**
     * Método observador (getter) que devuelve la descripción del vagón
     *
     * @return descripcion Descripción del vagón
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método modificador (setter) que establece la descripción del vagón
     *
     * @param descripcion Descripción del vagón
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método observador (getter) que devuelve el array de elementos
     * ControlServicio del vagón
     *
     * @return servicios array de elementos ControlServicio del vagón
     */
    public ControlServicio[] getServicios() {
        return servicios;
    }

    /**
     * Método modificador (setter) que establece el array de elementos
     * ControlServicio del vagón
     *
     * @param servicios Array de elementos ControlServicio del vagón.
     */
    public void setServicios(ControlServicio[] servicios) {
        this.servicios = servicios;
    }

    /**
     * Método observador (getter) que devuelve el número de elementos de
     * Controles de Servicio del vagón
     *
     * @return número de servicios instalados en el vagón
     */
    public int getNumServicios() {
        return servicios.length;
    }

    /**
     * Método observador (getter) que devuelve numero de Controles de Servicio
     * de tipo Puerta del vagón
     *
     * @return getNumPuertasVagon numero de Controles de Servicio de tipo Puerta
     * del vagón
     */
    public int getNumPuertasVagon() {
        int num = 0;

        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] instanceof PuertaVagon) {
                num++;
            }
        }
        return num;
    }

    /**
     * Método observador (getter) que devuelve numero de Controles de Servicio
     * de tipo Tira de Luz del vagón
     *
     * @return getNumTiraLuz numero de Controles de Servicio de tipo Tira de Luz
     * del vagón
     */
    public int getNumTiraLuz() {
        int num = 0;

        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] instanceof TiraLuz) {
                num++;
            }
        }
        return num;
    }

    /**
     * Método observador (getter) que devuelve numero de Controles de Servicio
     * de tipo Ventanilla
     *
     * @return getNumVentanillaVagon numero de Controles de Servicio de tipo
     * Puerta del vagón
     */
    public int getNumVentanillaVagon() {
        int num = 0;

        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] instanceof VentanillaVagon) {
                num++;
            }
        }
        return num;
    }

    /**
     * Método observador (getter) que devuelve numero de Controles de Servicio
     * de tipo Conjunto Altavoces
     *
     * @return getNumConjuntoAltavoces numero de Controles de Servicio de tipo
     * Conjunto Altavoces del vagón
     */
    public int getNumConjuntoAltavoces() {
        int num = 0;

        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] instanceof ConjuntoAltavoces) {
                num++;
            }
        }
        return num;
    }

    /**
     * Método cerrarPuertas cierra todas las puertas del vagón. Es decir,
     * recorre el array de controles de servicio que presenta como atributo y en
     * caso de ser una instancia de PuertaVagon activa su método on(). Para
     * evitar errores se realiza un casting a PuertaVagon
     *
     */
    public void cerrarPuertas() {
        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] instanceof PuertaVagon) {
                ((PuertaVagon) servicios[i]).on();
            }
        }
    }

    /**
     * Método activarTodosServicios activa todos los servicios del vagón. Es
     * decir, recorre el array de controles de servicio que presenta como
     * atributo y en caso de ser una instancia de la interzad Activable activa
     * su método on(). Para evitar errores se realiza un casting a Activable
     *
     */
    public void activarTodosServicios() {
        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] instanceof Activable) {
                ((Activable) servicios[i]).on();
            }
        }
    }

    /**
     * Método toString devuelve un String listando todos y cada uno de los
     * controles de servicio del vagón. Es decir, recorre el array de controles
     * de servicio que presenta como atributo y muestra los datos de cada
     * elemento. Por último por último añade a la cadena a devolver el número de
     * controles configurados en la clase ControlServicio.
     *
     * @return Cadena con los controles de servicio del vagón
     *
     */
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("El ");
        aux.append(this.descripcion + "\nPertene a " + this.companyiaTrenes);
        aux.append("\nPresenta los siguientes controles de servicios:");
        for (int i = 0; i < servicios.length; i++) {
            aux.append(servicios[i].toString());
        }
        aux.append("\n\nSe tienen: " + ControlServicio.getNumControlesConfigurados() + " controles configurados");
        return aux.toString();
    }

}
