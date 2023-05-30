package ejercicio02;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/**
 * Dado un array de cadenas que suponen presuntas fechas que pueden ser v�lidas
 * o no, hacer un programa que recorra el array de cadenas.
 * Para cada fecha, si es v�lida debe introducir en el array resultado que es 
 * de tipo LocalDate, la fecha correcta en esa posici�n.
 * Si la cadena no es ua fecha v�lida, entonces introducir� la fehca de hoy
 * m�s el n�mero de d�as corresponienttes al contador del bucle.
 */
public class Ejercicio02 {


    public static void main(String[] args) {
        
        
        String[] arrayFechasCadenas = {"2018-10-30", "2019-20-23", "2022-03-17",
                "2021-11-30", "2022-01-33", "2022-03-17"} ;
        LocalDate[] arrayFechasValidas = new LocalDate[6];
        
        for (int contador = 0; contador < arrayFechasCadenas.length; contador++) {
            String presuntaFecha = arrayFechasCadenas[contador] ;
            // Intento convertir a fecha
            try {
                LocalDate fecha = LocalDate.parse(presuntaFecha);
                arrayFechasValidas[contador] = fecha ;
                
            } catch (DateTimeParseException ex) {
                System.err.println("Error de fecha no v�lida: " + ex.getParsedString()) ;
                arrayFechasValidas[contador] = LocalDate.now().plusDays(contador) ;
            }
            
        }
        
     

        // Mostramos el array de fechas.
        System.out.println("CONTENIDO INICIAL DEL ARRAY DE FECHAS");
        System.out.println("-------------------------------------");        
        System.out.println (Arrays.toString(arrayFechasCadenas));
        System.out.println();
        

     //   System.out.printf ("Total de d�as cambiados: %d.\n", contadorDiasCambiados);
        System.out.println();
        
        // Mostramos el array de fechas una vez modificado.
        System.out.println("CONTENIDO FINAL DEL ARRAY DE FECHAS");
        System.out.println("-------------------------------------");
    //    System.out.println (Arrays.toString(arrayFechas));
        System.out.println (Arrays.toString(arrayFechasValidas));

    }
}

            
