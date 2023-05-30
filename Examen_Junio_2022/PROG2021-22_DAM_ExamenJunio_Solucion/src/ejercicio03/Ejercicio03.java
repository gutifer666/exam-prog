package ejercicio03;

/**
 * Crear la clase abstracta Vehiculo y dos clases hijas: Coche y Bicicleta
 * que implemente sus métodos.
 * La clase Vehiculo tendrá los atributos:
 *   codigo, de tipo entero
 *   nombre, de tipo String
 *   numRuedas, de tipo entero
 * 
 * La clase Coche tendrá un atributo entero para indicar el número de cilíndros.
 * La clase Bicicleta tendrá un atributo entero para indicar el número de radios de sus ruedas.
 * 
 * @author profesorado
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        // Crear rectángulo
        System.out.println("Crear un coche") ;
        Coche miCoche = new Coche(1, "Seat Fura", 4) ;
        
        System.out.println("El primer coche es: " + miCoche.toString()) ;
        System.out.println("Y tiene una velocidad máxima de : " + miCoche.getVelocidadMaxima() + " kms. por hora") ;
        
                
        
         // Crear pentágono regular
        System.out.println("\n\nCrear una bicicleta") ;
        Bicicleta miBici = new Bicicleta(4, "Bicicross BH", 2, 28) ;
        System.out.println("La primera bicicleta es: " + miBici.toString()) ;
        System.out.println("Y tiene una velocidad máxima de : " + miBici.getVelocidadMaxima() + " kms. por hora") ;
        
        
    }
}