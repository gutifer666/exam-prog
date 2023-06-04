package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import org.h2.tools.Server;
import static java.lang.System.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.stream.Collectors;
import utilidades.ES;

/**
 * Clase principal de inicio del programa.
 */
public class Aplicacion {

    /**
     * Nombre del archivo de base de datos local.
     */
    private static final String DB_NOMBRE = "proyectobase.h2db";
    /**
     * URL para la conexión a la base de datos.
     */
    private static final String URL_CONEXION = "jdbc:h2:./" + DB_NOMBRE;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "org.h2.Driver";
    /**
     * Opciones de conexión.
     */
    private static final String PARAMS = ";MODE=MySQL;AUTO_RECONNECT=TRUE";

    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB = "/resources/creaBD.sql";

    /**
     * Path al archivo que contiene la carga de datos de la base de datos.
     */
    public final static String INSERTA_DB = "/resources/cargaBD.sql";

    // Formato de fechas
    public final static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Método principal de la aplicación. En él se realiza la preparación del
     * entorno antes de empezar. A destacar:
     *
     * - Se carga el driver (Class.forName). - Se establece una conexión con la
     * base de datos (DriverManager.getConnection) - Se crean las tablas, si no
     * están creadas, invocando el método createTables. - Se ejecuta una
     * consulta de prueba
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean driverCargado = false;

        // Carga del driver de la base de datos.
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            driverCargado = true;
        } catch (ClassNotFoundException e) {
            err.printf("No se encuentra el driver de la base de datos (%s)\n", DRIVER);
        } catch (InstantiationException | IllegalAccessException ex) {
            err.printf("No se ha podido iniciar el driver de la base de datos (%s)\n", DRIVER);
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Si el driver está cargado, aseguramos que podremos conectar.
        if (driverCargado) {
            // Conectamos con la base de datos.
            // El try-with-resources asegura que se cerrará la conexión al salir.
            String[] wsArgs = {"-baseDir", System.getProperty("user.dir"), "-browser"};
            try (Connection con = DriverManager.getConnection(URL_CONEXION + PARAMS, "", "")) {

                // Iniciamos el servidor web interno (consola H2 para depuraciones)
                Server sr = Server.createWebServer(wsArgs);
                sr.start();

                // Presentamos información inicial por consola
                out.println("¡¡Atención!!");
                out.println();
                out.println("Mientras tu aplicación se esté ejecutando \n"
                        + "puedes acceder a la consola de la base de datos \n"
                        + "a través del navegador web.");
                out.println();
                out.println("Página local: " + sr.getURL());
                out.println();
                out.println("Datos de acceso");
                out.println("---------------");
                out.println("Controlador: " + DRIVER);
                out.println("URL JDBC: " + URL_CONEXION);
                out.println("Usuario: (no indicar nada)");
                out.println("Password: (no indicar nada)");

                // Creamos las tablas y algunos datos de prueba si no existen
                // y continuamos
                if (crearTablas(con)) {

                    // Insertar los datos en las tablas de la BD
                    insertarDatosTablas(con);

                    boolean continuar = true;

                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println("---- MENÚ DE LA APLICACIÓN ----");
                        System.out.println("---- --------------------- ----");
                        System.out.println(" 1 - Consultar actividades");
                        System.out.println(" 2 - Modificar actividad");
                        System.out.println(" 3 - Consultar usuarios");
                        System.out.println(" 4 - Borrar usuario");
                        System.out.println(" 0 - Salir");
                        System.out.println("---- ---------------------- ----");
                        System.out.println("---- ---------------------- ----");
                        System.out.println();
                        System.out.println();

                        // Leer la opción correspondiente a ejecutar.
                        int opcion = ES.leeEntero("Escriba opción: ", 0, 4);
                        switch (opcion) {
                            case 0:
                                continuar = false;
                                break;
                            case 1:
                                consultarActividades(con);
                                break;
                            case 2:
                                modificarActividad(con);
                                break;
                            case 3:
                                consultarUsuarios(con);
                                break;
                            case 4:
                                borrarUsuario(con);
                                break;
                        }
                    } while (continuar);

                    // Esperar tecla
                    ES.leeCadena("Antes de terminar, puedes acceder a la "
                            + "consola de H2 para ver y modificar la base de "
                            + "datos. Pulsa cualquier tecla para salir.");

                } else {
                    System.err.println("Problema creando las tablas.");

                }

                sr.stop();
                sr.shutdown();

            } catch (SQLException ex) {
                err.printf("No se pudo conectar a la base de datos (%s)\n", DB_NOMBRE);
            }
        }

    }

    /**
     * Dada una conexión válida, lleva a cabo la creación de la estructura de la
     * base de datos, usando como SQL para la creación el contenido en la
     * constante ESTRUCTURA_DB
     *
     * @param con conexión a la base de datos.
     * @see ESTRUCTURA_DB
     * @return true si se creó la estructura y false en caso contrario.
     */
    public static boolean crearTablas(Connection con) {
        boolean todoBien = false;

        try (Statement st = con.createStatement()) {

            String sqlScript = loadResourceAsString(ESTRUCTURA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);
                todoBien = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", ESTRUCTURA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.err.printf("Problema creando la estructura de la base de datos.\n");
        }
        return todoBien;
    }

    /**
     * Dada una conexión válida, lleva a cabo la inserción de datos de la base
     * de datos, usando como SQL para la creación el contenido en la constante
     * INSERTA_DB
     *
     * @param con conexión a la base de datos.
     * @see INSERTA_DB
     * @return true si se creó la estructura y false en caso contrario.
     */
    private static boolean insertarDatosTablas(Connection con) {
        boolean todoBien = false;

        try (Statement st = con.createStatement()) {

            String sqlScript = loadResourceAsString(INSERTA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);
                todoBien = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", INSERTA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.err.printf("Problema insertando datos en la base de datos.\n");
        }
        return todoBien;
    }

    /**
     * Carga un recurso que estará dentro del JAR como cadena de texto.
     *
     * @param resourceName Nombre del recurso dentro del JAR.
     * @return Cadena que contiene el contenido del archivo.
     */
    public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Aplicacion.class.getResourceAsStream(resourceName);
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.err.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }

    /**
     * Consultar las actividades de la base de datos
     *
     * @param con Conexión a la BD
     */
    private static void consultarActividades(Connection con) {

        // Ejecutamos la consulta
        try (Statement consulta = con.createStatement()) {
            if (consulta.execute("SELECT * FROM actividad")) {
                System.out.println("------------- Listado de actividades ---------------");
                System.out.println("Código Tipo                     Duración  Distancia");
                System.out.println("------ ------------------------ --------- ----------");

                ResultSet resultados = consulta.getResultSet();
                while (resultados.next()) {
                    int codigo = resultados.getInt("codigo");
                    String tipo = resultados.getString("tipo");
                    int duracion = resultados.getInt("duracion");
                    float distancia = resultados.getFloat("distancia");
                    System.out.printf("%6d %-22s %11d %10.2f \n", codigo, tipo, duracion, distancia);
                }
            } else {
                System.out.println("No hay actividades en la base de datos");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Modificar la duración y la distancia de la actividad cuyo código se
     * introduzca
     *
     * @param con Conexión a la BD
     */
    private static void modificarActividad(Connection con) {

        int codigo = ES.leeEntero("Escriba el código de la actividad para modificar la duración y la distancia: ");

        int duracion = ES.leeEntero("Escriba la nueva duración de la actividad: ");

        float distancia = ES.leeDecimal("Escriba la nueva distancia de la actividad: ");

        // Ejecutamos la sentencia SQL de actualización
        String updateString = "UPDATE actividad SET duracion = ?, distancia = ? WHERE codigo = ?";
        try (PreparedStatement consulta = con.prepareStatement(updateString)) {
            consulta.setInt(1, duracion);
            consulta.setFloat(2, distancia);
            consulta.setInt(3, codigo);
            consulta.executeUpdate();
            if (consulta.getUpdateCount() > 0) {
                System.out.println("Modificación correcta.");
            } else {
                System.out.println("No se realizó ninguna modificación en la base de datos.");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Consultar los usuarios de la base de datos
     *
     * @param con Conexión a la BD
     */
    private static void consultarUsuarios(Connection con) {

        // Ejecutamos la consulta
        try (Statement consulta = con.createStatement()) {
            if (consulta.execute("SELECT * FROM usuario")) {
                System.out.println("--------- Listado de usuarios -----------");
                System.out.println("Código Nombre                            ");
                System.out.println("------ ----------------------------------");

                ResultSet resultados = consulta.getResultSet();
                while (resultados.next()) {
                    int codigo = resultados.getInt("codigo");
                    String nombre = resultados.getString("nombre");
                    System.out.printf("%6d %-22s \n", codigo, nombre);
                }
            } else {
                System.out.println("No hay usuarios en la base de datos");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Borrar usuarios de la BD
     *
     * @param con Conexión a la BD
     */
    private static void borrarUsuario(Connection con) {

        // Leer el código del usuario
        int codigo = ES.leeEntero("Escriba el código del usuario a borrar: ");

        // Ejecutamos la sentencia SQL de borrado
        String deleteString = "DELETE FROM usuario WHERE codigo = ?";
        try (PreparedStatement consulta = con.prepareStatement(deleteString)) {
            consulta.setInt(1, codigo);
            consulta.executeUpdate();
            if (consulta.getUpdateCount() > 0) {
                System.out.println("Borrado usuario con código " + codigo + " correctamente");
            } else {
                System.out.println("No se realizó ningún borrado en la base de datos.");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }

    }
}
