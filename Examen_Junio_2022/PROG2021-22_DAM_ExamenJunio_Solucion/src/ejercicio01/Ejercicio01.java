package ejercicio01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado el array proporcionado con diversas cadenas correspondientes a
 * matr�culas de coches en el formato antiguo (Provincia, cuatro d�gitos y una o dos letras)
 * averiguar cu�les son correctas  y cuales no empleando una expresi�n regular.
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
        
        int totalValidas = 0 ;
        int totalNoValidas = 0 ;
        
        String[] arrayMatriculas = {"13", "MU9142BN", "1A", "0", "1",
            "AB2747T", "AL7347T", "FF", "63", "111", "AB1234YU", "M5723P", "7F"};
        
        System.out.println ("       Matr�culas v�lidas      ");
        System.out.println ("-------------------------------");        
        for (String numero : arrayMatriculas) {
            // Buscar las cadenas que no contengan vocal.
            Pattern p = Pattern.compile("(MU|AB)[0123456789]{4}[ABCDEFGHIJKLMNOPQRSTUVWXYZ]{1,2}");
            Matcher m = p.matcher(numero);
            // Seg�n sea v�lida o no
            if (m.matches()) {
                totalValidas++ ;
                System.out.println(numero);
            } else {
                totalNoValidas++ ;
            }
        }
        
        // Escribir el total de marcas sin vocal.
        System.out.println("\nTotal de matr�culas v�lidas: " + totalValidas) ;
        System.out.println("Total de matr�culas no v�lidas: " + totalNoValidas) ;
                        
    }
            
}