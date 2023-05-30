package ejercicio02;

import java.util.Arrays;

/**
 * Dado un array de cadenas que suponen presuntos números, hacer un programa que
 * recorra el array de cadenas.
 * Para cada cadena, si es un número válido debe escribir el número por consola.
 */
public class Ejercicio02 {


    public static void main(String[] args) {
        
        
        String[] arrayCadenas = {"xxx", "2019", "23,5",
                "323.78", "2ab33", "8921.8", "234.8556", "Ea56"} ;
               
          // Mostramos el array de fechas.
        System.out.println("CONTENIDO INICIAL DEL ARRAY");
        System.out.println("-------------------------------------");        
        System.out.println (Arrays.toString(arrayCadenas));
        System.out.println();
        
        for (String arrayFechasCadena : arrayCadenas) {
            
            try {
                // Comprobar si es válido
                String cadena = arrayFechasCadena;
                double numero = Double.parseDouble(cadena);
                // Informar por consola
                System.out.printf ("Número correcto: %8.2f\n", numero);
                
            }catch (NumberFormatException excepcion) {
                
            }
        }
        

      
        

     //   
        
        


    }
}

            
