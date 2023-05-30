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
        Coche coche;
        Bicicleta bicicleta;
        
        coche = new Coche(1, "Seat Fura", 4);
        bicicleta = new Bicicleta(4, "Bicicross BH", 2, 28);
        
        System.out.println("Crear un coche");
        System.out.print("El primer coche es: ");
        System.out.println(coche.toString());
        System.out.printf("Y tiene una velocidad m�xima de : %f kms. por hora\n", coche.getVelocidadMaxima());
        
        System.out.println("Crear una bicicleta");
        System.out.print("La primera bicicleta es: ");
        System.out.println(bicicleta.toString());
        System.out.printf("Y tiene una velocidad m�xima de : %f kms. por hora\n", bicicleta.getVelocidadMaxima());
   
        
    }
}