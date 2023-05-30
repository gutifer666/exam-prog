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
        
        // Crear rectángulo
        System.out.println("Crear un rectángulo de base 2.5 y altura 8.5") ;
        Rectangulo miRect = new Rectangulo(2.5, 8.5) ;
        
        System.out.println("El número de la dos del rectángulo es: " + miRect.getLados()) ;
        System.out.println("El área del rectángulo es: " + miRect.getArea()) ;
        System.out.println("El perímetro del rectángulo es: " + miRect.getPerimetro()) ;
        
        
         // Crear pentágono regular
        System.out.println("\n\nCrear un pentágono regular de lado 6.0") ;
        PentagonoRegular miPol = new PentagonoRegular(6.0) ;
        
        System.out.println("El número de lados del pentágono es: " + miPol.getLados()) ;
        System.out.println("El área del pentágono es: " + miPol.getArea()) ;
        System.out.println("El perímetro del pentágono es: " + miPol.getPerimetro()) ;
    }
    
}
