package ejercicio01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado el array proporcionado con diversas cadenas correspondientes a números,
 * averiguar cuáles son binarios  y cuales no empleando una expresión regular.
 * Indicar el número total tal y como se ve en la siguiente ejecución.
 * @author Profesor.
 */
public class Ejercicio01 {
    
    /**
     * Método principal.
     *
     * @param args Argumentos de la línea de órdenes.
     */
    public static void main(String[] args) {
        
        int totalBinarios = 0 ;
        int totalNoBinarios = 0 ;
        
        String[] arrayNumeros = {"13", "01011101", "1A", "0", "1",
            "003", "1011", "FF", "63", "111", "10", "57", "7F"};
        
        System.out.println ("    COMPROBACIÓN DE PATRONES   ");
        System.out.println ("-------------------------------");        
        for (String numero : arrayNumeros) {
            // Buscar las cadenas que no contengan vocal.
            Pattern p = Pattern.compile("[01]+");
            Matcher m = p.matcher(numero);
            // Según sea binario o no
            if (m.matches()) {
                totalBinarios++ ;
                System.out.println("El número: " + numero + " es binario.");
            } else {
                totalNoBinarios++ ;
                System.out.println("El número: " + numero + " no es binario.");
            }
        }
        
        // Escribir el total de marcas sin vocal.
        System.out.println("\nTotal de números binarios: " + totalBinarios) ;
        System.out.println("Total de números no binarios: " + totalNoBinarios) ;
                        
    }
            
}