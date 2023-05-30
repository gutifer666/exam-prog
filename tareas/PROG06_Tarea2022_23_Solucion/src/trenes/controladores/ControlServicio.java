package trenes.controladores;


/**
 * Clase abstracta ControlServicio. Servirá para agrupar todas las
 * características comunes a los diferentes controles que pueda presentar cada
 * vagón del tren.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */

public abstract class ControlServicio {


	/**
	 * Atributo de clase numControlesConfigurados. Sirve para controlar el número de
	 * objetos de tipo ControlServicio en cada instante.
	 */
	private static long numControlesConfigurados = 0;

	/**
	 * Atributo inmutable idControlServicio. Sirve para identificar con un número a
	 * cada Control que se cree de esta clase.
	 */
	private final long idControlServicio;

	/**
	 * Atributo nombreControlServicio. Sirve para darle un nombre a cada control.
	 */
	private String nombreControlServicio;

	/**
	 * Atributo tipoControlServicio. Sirve para asignarle un tipo a cada control, el
	 * tipo dependerá el control que estemos trabajando, en princpio puede ser de
	 * cuatro tipos: PuertaVagon
	 */
	protected String tipoControlServicio;

	/**
	 * Constructor con un parámetro de ControlServicio. Este constructor simplemente
	 * recibe un nombre de control de servicio para asignarlo al control que se va a
	 * crear. Automáticamente asignar el identificador de Control de Servicio
	 * (idControlServicio) a partir del número de controles existentes ya
	 * configurados. Y asigna como tipo de Control de servicio (tipoControlServicio)
	 * el valor "Desconocido"
	 *
	 * @param nombreControlServicio Cadena con el nombre a asignar a este control.
	 */
	public ControlServicio(String nombreControlServicio) {
		this.idControlServicio = numControlesConfigurados;
		this.nombreControlServicio = nombreControlServicio;
		this.tipoControlServicio = "Desconocido";
		numControlesConfigurados++;
	}

	/**
	 * Constructor sin parámetros de ControlServicio. Este constructor simplemente
	 * inicializa valores por defecto al control que se va a crear. Automáticamente
	 * asignar el identificador de Control de Servicio (idControlServicio) a partir
	 * del número de controles existentes ya configurados. Y asigna como tipo de
	 * Control de servicio (tipoControlServicio) el valor "Desconocido". De la misma
	 * forma asigna "Desconocido" al nombre de control de Servicio
	 * (nombreControlServicio)
	 */
	public ControlServicio() {
		this.idControlServicio = numControlesConfigurados;
		this.nombreControlServicio = "Desconocido";
		this.tipoControlServicio = "Desconocido";
		numControlesConfigurados++;
	}

	/**
	 * Método estático observador (getter) que devuelve el número de controles
	 * actualmente configurados
	 * 
	 * @return numControlesConfigurados
	 */
	public static long getNumControlesConfigurados() {
		return numControlesConfigurados;
	}

	/**
	 * Método estático modificador (setter) que asigna el número de controles
	 * actualmente configurados. Para que se pueda asignar dicho valor se debe
	 * comprobar que sea mayor o igual que cero.
	 * 
	 * @param numControlesConfigurados número entero largo a asignar
	 */
	public static void setNumControlesConfigurados(long numControlesConfigurados) {
		if (numControlesConfigurados >= 0)
			ControlServicio.numControlesConfigurados = numControlesConfigurados;
	}

	/**
	 * Método estático observador (getter) que devuelve el identificador de control
	 * de servicio
	 * 
	 * @return idControlServicio identificador del control
	 */
	public long getIdControlServicio() {
		return idControlServicio;
	}

	/**
	 * Método modificador (setter) que asigna el identificador para el controlador
	 * de servicio
	 * 
	 * @param idControlServicio
	 */
	/*
	 * public void setIdControlServicio(long idControlServicio) {
	 * this.idControlServicio = idControlServicio; }
	 */

	/**
	 * Método estático observador (getter) que devuelve el número de controles
	 * actualmente configurados
	 * 
	 * @return nombreControlServicio número de controles actualmente configurados
	 */
	public String getNombreControlServicio() {
		return nombreControlServicio;
	}

	/**
	 * Método modificador (setter) que asigna el nombre de control de servicio al
	 * que pertenece este objeto.
	 * 
	 * @param nombreControlServicio nombre de control de servicio que se debe
	 *                              asignar.
	 */
	public void setNombreControlServicio(String nombreControlServicio) {
		this.nombreControlServicio = nombreControlServicio;
	}

	/**
	 * Método observador (getter) que devuelve el tipo de control de servicio del
	 * objeto
	 * 
	 * @return tipoControlServicio tipo de control de servicio del objeto.
	 */
	public String getTipoControlServicio() {
		return tipoControlServicio;
	}

	/**
	 * Método modificador (setter) que asigna el tipo de control de servicio al que
	 * pertenece este objeto. Para que se pueda asignar dicho valor se debe
	 * comprobar que pertenezca a uno de los cuatro tipos permitidos: "Puerta",
	 * Ventanilla, "Altavoz" o "TiraLuz". En caso se no corresponderse el parámetro
	 * para asignar con ninguno de estos cuatro tipos se asignará "Desconocido"
	 * 
	 * @param tipoControlServicio tipo de control de servicio que se debe asignar.
	 */
	public void setTipoControlServicio(String tipoControlServicio) {
		if (tipoControlServicio.equalsIgnoreCase("Puerta") || tipoControlServicio.equalsIgnoreCase("TiraLuz")
				|| tipoControlServicio.equalsIgnoreCase("Ventanilla")
				|| tipoControlServicio.equalsIgnoreCase("Altavoz")) {
			this.tipoControlServicio = tipoControlServicio;
		} else {
			this.nombreControlServicio = "Desconocido";
		}
	}

	/**
	 * Método toString devuelve un String con los valores actuales de los atributos
	 * Cada atributo aparecerá en una línea y su tabulación
	 * 
	 * @return Cadena con los valores de los atributos
	 */
	@Override
	public String toString() {
		return "\n\n-------------------------------------------------------------------"
				+ "\nControlServicio:\n\tIdentificador: " + idControlServicio + "\n\tNombre Servicio: "
				+ nombreControlServicio + "\n\tTipo de Servicio: " + tipoControlServicio;
	}

}
