package ejercicio03;

/**
 * Crear la clase abstracta Vehiculo y dos clases hijas: Coche y Bicicleta
 * que implemente sus m�todos.
 * La clase Vehiculo tendr� los atributos:
 *   codigo, de tipo entero
 *   nombre, de tipo String
 *   numRuedas, de tipo entero
 * 
 * La clase Coche tendr� un atributo entero para indicar el n�mero de cil�ndros.
 * La clase Bicicleta tendr� un atributo entero para indicar el n�mero de radios de sus ruedas.
 * 
 * @author profesorado
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        // Crear rect�ngulo
        System.out.println("Crear un coche") ;
        Coche miCoche = new Coche(1, "Seat Fura", 4) ;
        
        System.out.println("El primer coche es: " + miCoche.toString()) ;
        System.out.println("Y tiene una velocidad m�xima de : " + miCoche.getVelocidadMaxima() + " kms. por hora") ;
        
                
        
         // Crear pent�gono regular
        System.out.println("\n\nCrear una bicicleta") ;
        Bicicleta miBici = new Bicicleta(4, "Bicicross BH", 2, 28) ;
        System.out.println("La primera bicicleta es: " + miBici.toString()) ;
        System.out.println("Y tiene una velocidad m�xima de : " + miBici.getVelocidadMaxima() + " kms. por hora") ;
        
        
    }
}