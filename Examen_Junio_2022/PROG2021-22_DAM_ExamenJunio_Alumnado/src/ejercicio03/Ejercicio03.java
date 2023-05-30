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
        Coche coche;
        Bicicleta bicicleta;
        
        coche = new Coche(1, "Seat Fura", 4);
        bicicleta = new Bicicleta(4, "Bicicross BH", 2, 28);
        
        System.out.println("Crear un coche");
        System.out.print("El primer coche es: ");
        System.out.println(coche.toString());
        System.out.printf("Y tiene una velocidad máxima de : %f kms. por hora\n", coche.getVelocidadMaxima());
        
        System.out.println("Crear una bicicleta");
        System.out.print("La primera bicicleta es: ");
        System.out.println(bicicleta.toString());
        System.out.printf("Y tiene una velocidad máxima de : %f kms. por hora\n", bicicleta.getVelocidadMaxima());
   
        
    }
}