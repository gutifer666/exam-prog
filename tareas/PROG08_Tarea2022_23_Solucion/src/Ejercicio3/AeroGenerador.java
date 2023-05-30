package Ejercicio3;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ------------------------------------------------------------
//                   Clase AeroGenerador
// ------------------------------------------------------------
/**
 * Clase que representa un <strong>aero generador de energía eléctrica</strong> que se instala
 * en un complejo que se pretende gestionar..
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar información sobre 
 * los datos del dispositivo, su distancia con respecto al más cercano del complejo,
 * las horas de funcionamiento y los kWs generados así como la fecha del último funcionamiento 
 * del aerogenerador, si es que está funcionando en ese momento, etc. </p>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>número total de aero generadores</strong> instalados hasta el momento o lo
 * que es lo mismo, <strong>número total de aero generadores</strong>;</li>
 * <li><strong>número de aero generadores funcionando</strong> en el momento actual, o</li>
 * <li><strong>energía global generada</strong> por todos los aero generadores.</li>
 * </ul>
 *
 * @author profe
 */
public class AeroGenerador implements Serializable{
    
    //Este atributo es necesario para una correcta serialización/des-serialización en Java
    //Ver: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 42L;

    // ------------------------------------------------------------
    //                 ATRIBUTOS ESTÁTICOS (de clase)
    // ------------------------------------------------------------
    // Atributos estáticos constantes públicos
    // (rangos y requisitos de los atributos de objeto)
    // Son públicos, disponibles para que cualquier código cliente pueda acceder a ellos
    // ---------------------------------------------------------------------------------
    /**
     * Máximo horas de funcionamiento por sesión para poder realizar mantenimientos:
     * {@value MAX_HORAS_SESION} km.
     */
    public final static int MAX_HORAS_SESION = 12;

    /**
     * Máxima velocidad de viento soportada, en km/h: {@value MAX_VELOCIDAD_VIENTO}.
     */
    public static final int MAX_VELOCIDAD_VIENTO = 40;
    /**
     * Mínima distancia entre dispositivos en metros: {@value MIN_DISTANCIA}.
     */
    public static final int MIN_DISTANCIA = 150;
    /**
     * Mínima fecha de instalación permitida: 01/01/2023.
     */
    public static final LocalDate MIN_FECHA_INSTALACION = LocalDate.of(2023, 1, 1);

    // Atributos estáticos constantes privados para uso interno
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    private static final  DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");

    // ------------------------------------------------------------------------
    // Atributos estáticos variables (privados).
    // Representan "estado" de la clase en general. No de objetos en particular
    // ------------------------------------------------------------------------

    private static int numAeroGeneradores = 0;              // Total de aerogeneradores instalados
    private static double kilowatiosGeneradosPorTodos = 0;  // Total de kw generados entre todas los aerogeneradores
    private static int agFuncionando = 0;                   // Número de aerogeneradores funcionando en un momento dado

    // ------------------------------------------------------------
    //               ATRIBUTOS DE OBJETO (todos privados)
    // ------------------------------------------------------------
    // Atributos de objeto constantes durante la vida del objeto (desde que se crea objeto)
    // No hace falta declararlas como variables pues no van a cambiar una vez creado el objeto.
    // Representan "características inmutables" o "de naturaleza" del objeto.
    // (usamos notación "camelCase" aunque sean final, pues son "internos" y no los "ve" nadie más)
    // ------------------------------------------------------------------------
    private final long numSerie;                // Número de serie del dispositivo (desde 1 hasta el máximo número positivo long)
    private final LocalDate fechaInstalacion;   // Fecha en que fue instalado el aerogenerador en el complejo

    // Atributos de objeto variables
    // Representan el "estado" del objeto en un instante dado.
    // ------------------------------------------------------------------------
    private boolean funcionando;    // Si ya está o no en funcionamiento
    private int distancia;          // distancia con el ag más cercano
    private LocalDateTime registroInicioFuncionamientoActual;  // Inicio de funcionamiento y generación actual (null si no está generando)
    private double kwTotales;                    // Total de kw generados
    private int horasTotales;                    // Total de horas de funcionamiento
    private double kwFuncionamientoActual;   // kw generados en el funcionamiento actual (0 si no está funcionando)
    private int horasFuncionamientoActual;   // horas trabajadas en el funcionamiento actual (0 si no está funcionando)
    // Información relativa a las sesiones de generación del aerogenerador:
    private LocalDateTime registroUltimoFuncionamiento;        // Fecha y hora del inicio del último funcionamiento (no actual). Si no ha funcionado nunca antes será null
    private int horasUltimoFuncinamiento;                       // Horas que ha estado funcionando el último funcionamiento. Si no ha funcionado nunca antes será 0
    private LocalDateTime registroFinUltimoFuncionamiento;           // Fecha y hora del fin del último funcionamiento. Si no ha funcionado nunca antes será null
    private double kwGeneradosUltimoFuncionamiento;   // kw generados en el último funcionamiento (no actual). Si no ha funcionado nunca antes será 0.0

    
    // ------------------------------------------------------------
    //                        CONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Constructor basado en la fecha de instalación del aerogenerador, así como en la
     * distancia al más cercando en el complejo. Crea un nuevo objeto
     * <code>AeroGenerador</code> con la distancia con el más cercano y la fecha de
     * instalación indicadas. La <strong>distiancia</strong> debe
     * ser mayor <code>AeroGenerador.MIN_DISTANCIA</code>. La <strong>fecha de
     * instalación</strong> no puede ser anterior a
     * <code>AeroGenerador.MIN_FECHA_INSTALACION</code> ni posterior a la fecha
     * actual.
     * @param fechaAdquisicion fecha de adquisición del aerogenerador
     * @param distancia distancia con el más cercano
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public AeroGenerador(LocalDate fechaInstalacion, int distancia) throws IllegalArgumentException {

        if (fechaInstalacion == null || fechaInstalacion.isBefore(AeroGenerador.MIN_FECHA_INSTALACION)
                || fechaInstalacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha incorrecta: "
                    + (fechaInstalacion != null ? fechaInstalacion.format(FORMATO_FECHA) : null));
        } else if (!distanciaCorrecta(distancia)) {
            throw new IllegalArgumentException("Distancia incorrecta: " + distancia);
        } else {
            // No hay errores, se procede a crear e inicializar atributos de objeto

            // Inicialización de atributos "inmutables"
            this.numSerie = AeroGenerador.numAeroGeneradores+1;

            // Inicialización de atributos de estado
            this.distancia = distancia;
            this.fechaInstalacion = fechaInstalacion;

            // Estas inicializaciones no son obligatorias: (en Java un atributo no inicializado pasa a ser el valor "nulo" de su tipo)
            this.funcionando = false;
            this.kwFuncionamientoActual = 0;
            this.kwGeneradosUltimoFuncionamiento = 0;
            this.kwTotales = 0;

            // Actualizamos atributos de clase
            AeroGenerador.numAeroGeneradores++;
        }
    }
    
    
    /**
     * Constructor sin parámetros. Crea un nuevo objeto <code>AeroGenerador</code>
     * con la fecha actual como fecha de instalación y con los valores por
     * omisión para la distancia.
     */
    public AeroGenerador() {
        this.distancia = AeroGenerador.MIN_DISTANCIA+1;
        this.numSerie = ++AeroGenerador.numAeroGeneradores;
        this.fechaInstalacion = LocalDate.now();
    }

    // ------------------------------------------------------------
    //          MÉTODOS "FÁBRICA" O PSEUDOCONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Método "fábrica" creador de un array de objetos AeroGenerador. Crea un array
     * de referencias a objetos <code>AeroGenerador</code> con los parámetros por
     * omisión. El tamaño del array será indicado por el parámetro
     * <code>cantidad</code>.
     * @param cantidad tamaño del array a devolver
     * @return array de referencias a objetos <code>AeroGenerador</code>
     * @throws IllegalArgumentException si la cantidad es inferior a 1
     */
    public static AeroGenerador[] crearArrayAeroGenerador(int cantidad) throws IllegalArgumentException {
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad no válida: " + cantidad);
        }
        AeroGenerador[] arrayAeroGenerador = new AeroGenerador[cantidad];
        for (int i = 0; i < arrayAeroGenerador.length; i++) {
            arrayAeroGenerador[i] = new AeroGenerador();
        }
        return arrayAeroGenerador;
    }

    // ------------------------------------------------------------
    //                 Getters:  Métodos GET
    // ------------------------------------------------------------
    // Métodos de consulta del estado (atributos) del objeto
    // -----------------------------------------------------
    // Algunos puede que devuelvan directamente el valor de un atributo.
    // Otros puede que devuelvan el resultado de operar con uno o varios atributos.
    /**
     * Obtiene el número de serie del aerogenerador.
     * @return número de serie del aerogenerador
     */
    public String getNumSerie() {
        return String.valueOf(this.numSerie);
    }

    /**
     * Obtiene la fecha de instalación del aerogenerador.
     * @return fecha de instalación del aerogenerador
     */
    public LocalDate getFechaInstalacion() {
        return this.fechaInstalacion;
    }

    /**
     * Obtiene la distancia al aerogenerdor más cercano en el complejo.
     * @return distancia del aerogenerador
     */
    public int getDistancia() {
        return this.distancia;
    }

    /**
     * Indica si el aerogenerador está funcionando.
     * @return si el aerogenerador está funcionando o no
     */
    public boolean isFuncionando() {
        return this.funcionando;
    }

    /**
     * Obtiene el total de kws generados hasta el momento por el aerogenerador.
     * @return kws generados hasta el momento.
     */
    public double getKwTotales() {
        return this.kwTotales;
    }

    /**
     * Obtiene la fecha y hora de la sesión de generación actual del aerogenerador, si es que está
     * funcionando. Si no, devolverá <code>null</code>.
     * @return fecha y hora del funcionamiento actual. Si no está funcionando devuelve
     * <code>null</code>.
     */
    public LocalDateTime getRegistroInicioFuncionamientoActual() {
        return this.registroInicioFuncionamientoActual;
    }

    /**
     * Obtiene los kws generados hasta el momento por el aerogenerador durante el
     * funcionamiento actual, si es que está funcioando. Si no está funcionando,
     * devolverá 0.
     * @return kws generados durante el funcionamiento actual. Si no está
     * funcionando devuelve 0.
     */
    public double getKwFuncionamientoActual() {
        return this.kwFuncionamientoActual;
    }

    /**
     * Obtiene la fecha y hora de inicio del último funcionamiento del aerogenerador
     * (anterior al actual, si es que estuviera funcionando). Si todavía no ha
     * llegado finalizar ningún funcionamiento (aún no ha arrancado y parado),
     * será <code>null</code>.
     * @return fecha y hora de inicio del último funcionamiento.
     */
    public LocalDateTime getRegistroInicioUltimoFuncionamiento() {
        return this.registroUltimoFuncionamiento;
    }

    /**
     * Obtiene la fecha y hora de fin del último funcionamiento del aerogenerador (anterior
     * al actual, si es que estuviera funcionando). Si todavía no ha llegado
     * finalizar ningún funcionamiento (aún no ha sido arrancado y parado), será
     * <code>null</code>.
     * @return fecha y hora de fin del último funcionamiento.
     */
    public LocalDateTime getRegistroFinUltimoFuncionamiento() {
        return this.registroFinUltimoFuncionamiento;
    }

    /**
     * Obtiene el total de kws generados por el aerogenerador durante el último
     * funcionamiento. Si todavía no ha llegado finalizar ningún funcionamiento (aún no ha
     * sido funcionando y devuelta), será 0.
     * @return kws generados durante el último funcionamiento.
     */
    public double getKwGeneradosUltimoFuncionamiento() {
        return this.kwGeneradosUltimoFuncionamiento;
    }

    // Métodos estáticos de acceso a atributos estáticos
    // -------------------------------------------------
    /**
     * Obtiene la cantidad de aerogeneradores creados hasta el
     * momento.
     * @return cantidad de aerogeneradores instalados en el complejo
     */
    public static int getNumAeroGeneradores() {
        return AeroGenerador.numAeroGeneradores;
    }

    /**
     * Obtiene la cantidad de aerogeneradores funcionando en ese momento.
     * @return cantidad de aerogeneradores funcionando
     */
    public static int getAgFuncionando() {
        return AeroGenerador.agFuncionando;
    }

    /**
     * Obtiene el total de kws generados entre todas los aerogeneradores hasta el momento.
     * @return total de kws generados entre todos los aerogeneradores hasta el momento
     */
    public static double getKilowatiosGeneradosPorTodos() {
        return AeroGenerador.kilowatiosGeneradosPorTodos;
    }

    /**
     * Obtiene el total de horas en funcionamiento hasta el momento.
     * @return total de de horas en funcionamiento hasta el momento
     */
    public int getHorasTotales() {
        return horasTotales;
    }

    /**
     * Obtiene el número de horas trabajadas durante el último funcionamiento.
     * @return l número de horas trabajadas durante el último funcionamiento
     */
    public int getHorasUltimoFuncinamiento() {
        return horasUltimoFuncinamiento;
    }
    
    /**
     * Obtiene el número de horas trabajadas durante el funcionamiento actual.
     * @return l número de horas trabajadas durante el funcionamiento actual
     */
    public int getHorasFuncionamientoActual() {
        return horasFuncionamientoActual;
    }

    // ------------------------------------------------------------
    //                 Métodos de "ACCIÓN"
    // ------------------------------------------------------------
    // Se trata de métodos que modifican el estado del objeto en uno
    // o varios atributos en función del estado en el que se encuentre
    // y/o los parámetros que reciba.
    // ------------------------------------------------------------
    //                 Método arrancar
    // ------------------------------------------------------------
    /**
     * Pasa el estado del aerogenerador a "funcionando". Si ya está funcionando no se puede
     * volver a arrancar.
     * @throws IllegalStateException si ya está funcionando
     */
    public void arrancar() throws IllegalStateException {
        if (this.funcionando) {
            throw new IllegalStateException("Aerogenerador ya funcionando");
        } else {
            this.funcionando = true;
            this.registroInicioFuncionamientoActual = LocalDateTime.now();  // El funcionamiento empieza ahora
            // Actualizamos atributos de clase (un aerogenerador más funcionando)
            AeroGenerador.agFuncionando++;
        }
    }

    // ------------------------------------------------------------
    //                 Método parar
    // ------------------------------------------------------------
    /**
     * Pasa el estado del aerogenerador a "no funcionando". Si no está funcionando no puede
     * llevarse a cabo esta operación.
     * @throws IllegalStateException si no está funcionando
     */
    public void parar() throws IllegalStateException {
        if (!this.funcionando) {
            throw new IllegalStateException("Aerogenerador no funcionando");
        } else {
            this.funcionando = false; // Deja de estar funcionando
            // Actualizamos los registros del último funcionamiento con la sesión que acaba de finalizar
            this.registroUltimoFuncionamiento = this.registroInicioFuncionamientoActual;
            this.registroFinUltimoFuncionamiento = LocalDateTime.now(); // Deja de estar funcionando ahora
            this.kwGeneradosUltimoFuncionamiento = this.kwFuncionamientoActual;            
            this.horasUltimoFuncinamiento = this.horasFuncionamientoActual;
            // Reseteamos el funcionamiento actual, que deja de existir
            this.registroInicioFuncionamientoActual = null; // Deja de estar funcionando y no tiene registro de funcionamiento
            this.kwFuncionamientoActual = 0; // Deja de estar funcionando y no tiene kws generados
            this.horasFuncionamientoActual = 0; // Deja de estar funcionando y no tiene horas trabajadas
            // Actualizamos atributos de clase (un ag menos funcionando)
            AeroGenerador.agFuncionando--;
        }
    }

    // ------------------------------------------------------------
    //                 Método registrarGeneracion
    // ------------------------------------------------------------
    /**
     * Registra los KWs generados en un determinado número de horas. No se puede
     * superar el máximo número de horas permitidas por sesión. No se permiten
     * duraciones negativas. Sí se permite la duración 0.
     * @return la cantidad de kws que se llevan generados con el funcionamiento actual
     * @param  horas tiempo en horas de la sesión
     * @param  kwGenerados kws generados en la sesión
     * @throws IllegalStateException si el aerogenerador no está funcionando
     * @throws IllegalArgumentException si la distancia no es válida
     */
    public double registrarGeneracion(int horas, double kwGenerados) throws IllegalStateException, IllegalArgumentException {
        if (!this.funcionando) {
            throw new IllegalStateException("Aerogenerador no funcionando");
        } else if (horas < 0 || horas > AeroGenerador.MAX_HORAS_SESION) {
            throw new IllegalArgumentException(String.format("Horas incorrectas: %02d horas", horas));
        } else {
            // Actualizamos generados
            this.kwFuncionamientoActual += kwGenerados;
            this.horasFuncionamientoActual += horas;
            this.horasTotales += horas;
            this.kwTotales += kwGenerados;
            AeroGenerador.kilowatiosGeneradosPorTodos += kwGenerados;
            return this.kwFuncionamientoActual;
        }
    }
            
    // ------------------------------------------------------------
    //                      Método reset
    // ------------------------------------------------------------
    /**
     * Resetea el aerogenerador a los valores de iniciales. Solo puede ser reseteado si el
     * generador no está funcionando. Se perderán todos los registros de funcionamientoes, 
     * incluyedo cualquier fecha y dato de generación de electricidad. 
     * Tan solo se mantendrán el número de serie y la fecha de instalación.
     * @throws IllegalStateException si el aerogenerador está funcionando
     */
    public void reset() throws IllegalStateException {
        if (this.funcionando) {
            throw new IllegalStateException("No se puede resetear los datos del aerogenerador que esté funcionando");
        } else {
            // Reseteamos la información de registro 
            this.registroUltimoFuncionamiento = null;
            this.registroFinUltimoFuncionamiento = null;
            this.horasUltimoFuncinamiento = 0;
            this.kwGeneradosUltimoFuncionamiento = 0;
            this.kwTotales = 0;
            this.horasTotales = 0;
        }
    }

    // ------------------------------------------------------------
    //                 Método toString
    // ------------------------------------------------------------
    /**
     * Devuelve una cadena que representa el estado de un objeto <code>AeroGenerador</code>.
     * El resultado devuelto representará el estado del aero generador y tendrá la
     * siguiente estructura:
     * <ol>
     * <li>un inicio de bloque o llave (carácter '{');</li>
     * <li>la etiqueta "NS: " junto con el número de serie;</li>
     * <li>la fecha de adquisción del aerogenerador;</li>
     * <li>la etiqueta "fw: " y a continuación la versión y revisión del firmware;</li>
     * <li>si el aerogenerador está o no funcionando;</li>
     * <li>cantidad de kws totales generados por el aerogenerador hasta el momento;</li>
     * <li>información sobre el funcionamiento actual: fecha y hora de inicio del funcionamiento actual 
     * y kws generados durante ese funcionamiento;</li>
     * <li>información sobre el último funcionamiento realizado: fecha y hora de inicio y de fin 
     * de ese funcionamiento junto con los kws realizados durante el mismo;</li>
     * <li>un fin de bloque o llave (carácter '}').</li>
     * </ol>
     * <p>Un ejemplo de cadena devuelta podría ser:</p>
     * <p><code>{ NS: 33; 15/09/2021; fw: 2.1; no funcionando; 150,00 km totales; Alquiler actual: ---, 0,00 km; Último funcionamiento: 09/12/2021 12:33:36, 09/12/2021 22:02:57, 57,28 km }</code></p>
     * <p>donde podríamos observar la siguiente información:</p>
     * <ul>
     * <li>el número de serie del aerogenerador es 33;</li>
     * <li>la fecha de adquisición es el 15 de septiembre de 2021;</li>
     * <li>la versión y revisión del firmware es 2.1;</li>
     * <li>el aerogenerador no está funcionando en este momento;</li>
     * <li>la cantidad de kws generados por el aerogenerador hasta el momento es de 150,00 kws;</li>
     * <li>la información sobre el funcionamiento actual será nula: fecha/hora con "---" y kws a cero, pues no está funcionando;</li>
     * <li>la información sobre el último funcionamiento completado será: los registros "09/12/2021 12:33:36" para el inicio y "09/12/2021 22:02:57" para el fin del funcionamiento junto con los 57,28 km realizados durante ese funcionamiento.</li>
     * </ul>
     * 
     * @return una cadena que representa el estado de un objeto microdispositivo <code>AeroGenerador</code>
     */
    @Override
    public String toString() {
        String cadenaResultado=
            String.format ("{ NS: %s; %s; %sfuncionando; %.2f kW totales, %d horas totales; Funcionamiento actual: %s, %.2f kW, %d horas; Último funcionamiento: %s, %s, %.2f kW, %d horas}\n",
                    // Información inmutable
                    this.getNumSerie(),
                    this.fechaInstalacion.format(AeroGenerador.FORMATO_FECHA),
                    // Información de estado
                    this.funcionando ? "" : "no ",
                    this.kwTotales,
                    this.horasTotales,
                    // Información sobre el funcionamiento actual
                    this.registroInicioFuncionamientoActual != null ? 
                            this.registroInicioFuncionamientoActual.format(AeroGenerador.FORMATO_FECHA_HORA) :
                            "---",
                    this.kwFuncionamientoActual,
                    this.horasFuncionamientoActual,
                    // Información sobre el último funcionamiento                    
                    this.registroUltimoFuncionamiento != null ? 
                            this.registroUltimoFuncionamiento.format(AeroGenerador.FORMATO_FECHA_HORA) :
                            "---",
                    this.registroFinUltimoFuncionamiento != null ? 
                            this.registroFinUltimoFuncionamiento.format(AeroGenerador.FORMATO_FECHA_HORA) :
                            "---",
                    this.kwGeneradosUltimoFuncionamiento,
                    this.horasUltimoFuncinamiento
                );
        return cadenaResultado;
    }

    // ------------------------------------------------------------
    //               MÉTODOS PRIVADOS "HERRAMIENTA"
    // ------------------------------------------------------------
    // Métodos "internos" que sirven como "herramientas" para ayudar 
    // en la implementación de otros métodos
    // ------------------------------------------------------------
    //                 Método versionCorrecta
    // ------------------------------------------------------------
    // Indica si la distancia a la que se quiere instalar el AG es menor de la indicada
    private static boolean distanciaCorrecta(int distancia) {
        return distancia > AeroGenerador.MIN_DISTANCIA;
    }

    

}
