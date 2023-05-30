package ejercicio03;

/**
 * Dado el interface Poligono crear dos clases: Rectangulo y PentagonoRegular
 * que implemente sus métodos. Completar el main usando los métodos para 
 * escribir los datos tal y como se ven en la ejeución siguiente, creando
 * un rectángulo de base 2.5 y altura 8.5, así como un pentágono regular de lado 6
 * 
 * @author portatil_profesorado
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        Rectangulo miRectangulo = new Rectangulo(2.5, 8.5);
        PentagonoRegular miPentagono = new PentagonoRegular(6.0);
        
        System.out.println("Crear un rectángulo de base 2.5 y altura 8.5");
        System.out.printf("El número de la dos del rectángulo es: %d\n", miRectangulo.getLados());
        System.out.printf("El área del rectángulo es: %f\n", miRectangulo.getArea());
        System.out.printf("El perímetro del rectángulo es: %f\n", miRectangulo.getPerimetro());
        
        System.out.println("Crear un pentágono regular de lado 6.0");
        System.out.printf("El número de la dos del pentágono es: %d\n", miPentagono.getLados());
        System.out.printf("El área del rectángulo es: %f\n", miPentagono.getArea());
        System.out.printf("El perímetro del rectángulo es: %f\n", miPentagono.getPerimetro());
    }
    
}
