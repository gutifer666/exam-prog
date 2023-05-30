/*
 * Ejemplo de utilización de clases que implementan la interfaz Imprimible.
 */
package ejemplointerfazimprimible;


/**
 *
 * Ejemplo de utilización de clases que implementan la interfaz Imprimible
 */
public class EjemploInterfazImprimible {

    /**
     * Clase principal
     */
    public static void main(String[] args) {
        
        // Creación de objetos alumno y profesor
        Alumno alumno1= new Alumno ("Juan", "Torres Mula", "Huelva", "1DAM-B", 7.5);
        Profesor profesor1= new Profesor  ("Antonio", "Campos Pin", "Granada", "Informática", 2000);
      
        // Obtención del contenido del objeto alumno a través de los métodos del interfaz Imprimible
        int numAtributosAlumno= alumno1.getNumAtributos();
        String[] nombreAtributosAlumno= alumno1.getNombreAtributos();
        String[] contenidoAtributosAlumno= alumno1.getContenidoArray();
        String stringContenidoAlumno= alumno1.getContenidoString();
        
        // Obtención del contenido del objeto profesor a través de los métodos del interfaz Imprimible
        int numAtributosProfesor= profesor1.getNumAtributos();
        String[] nombreAtributosProfesor= profesor1.getNombreAtributos();
        String[] contenidoAtributosProfesor= profesor1.getContenidoArray();
        String stringContenidoProfesor= profesor1.getContenidoString();
                
        // Impresión en pantalla del contenido del objeto alumno a través de las estructuras obtenidas
        System.out.printf ("Contenido del objeto alumno: %s\n", stringContenidoAlumno);
        
        // Impresión en pantalla del contenido del objeto alumno a través de las estructuras obtenidas
        System.out.printf ("Contenido del objeto profesor: %s\n", stringContenidoProfesor);

        
    }
}
