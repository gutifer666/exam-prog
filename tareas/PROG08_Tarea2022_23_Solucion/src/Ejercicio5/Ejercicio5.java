package Ejercicio5;

import java.io.*;

/**
 * Programa para comprimir archivos y carpetas.
 * @profesorado
 */
public class Ejercicio5{

    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String ruta = System.getProperty("user.dir");
        String rutaComprimir = "src";
        File fComprimir = new File(rutaComprimir);
        String rutaZIP = ruta+ "/recursos/";
        
        //ESTO ES LO ÚNICO QUE TENÉIS QUE MODIFICAR
        String nombreZIP = "Apellido1_Apellido2_Nombre_PROG08_Tarea.zip";
        
        // Variables de salida
        
        // Variables auxiliares
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        UtilidadDirectorios directorios = new UtilidadDirectorios();
        
        /* Directorio a recorrer; directorio de salida; nombre del archivo */
        directorios.zip(fComprimir, rutaZIP, nombreZIP);
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
	System.out.println ("Archivo comprimido correctamente.");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
}
