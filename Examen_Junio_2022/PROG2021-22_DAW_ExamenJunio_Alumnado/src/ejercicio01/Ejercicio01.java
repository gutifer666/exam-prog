package ejercicio01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado el array proporcionado con diversas cadenas correspondientes a n�meros,
 * averiguar cu�les son binarios  y cuales no empleando una expresi�n regular.
 * Indicar el n�mero total tal y como se ve en la siguiente ejecuci�n.
 * @author Profesor.
 */
public class Ejercicio01 {
    
    /**
     * M�todo principal.
     *
     * @param args Argumentos de la l�nea de �rdenes.
     */
    public static void main(String[] args) {
        
        int totalBinarios = 0 ;
        int totalNoBinarios = 0 ;
        
        String[] arrayNumeros = {"13", "01011101", "1A", "0", "1",
            "003", "1011", "FF", "63", "111", "10", "57", "7F"};
        
        System.out.println ("    COMPROBACI�N DE PATRONES   ");
        System.out.println ("-------------------------------");        
        for (String numero : arrayNumeros) {
            // Buscar las cadenas que no contengan vocal.
            Pattern p = Pattern.compile("[01]+");
            Matcher m = p.matcher(numero);
            // Seg�n sea binario o no
            if (m.matches()) {
                totalBinarios++ ;
                System.out.println("El n�mero: " + numero + " es binario.");
            } else {
                totalNoBinarios++ ;
                System.out.println("El n�mero: " + numero + " no es binario.");
            }
        }
        
        // Escribir el total de marcas sin vocal.
        System.out.println("\nTotal de n�meros binarios: " + totalBinarios) ;
        System.out.println("Total de n�meros no binarios: " + totalNoBinarios) ;
                        
    }
            
}