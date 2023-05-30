package ejercicio03;

/**
 * Dado el interface Poligono crear dos clases: Rectangulo y PentagonoRegular
 * que implemente sus m�todos. Completar el main usando los m�todos para 
 * escribir los datos tal y como se ven en la ejeuci�n siguiente, creando
 * un rect�ngulo de base 2.5 y altura 8.5, as� como un pent�gono regular de lado 6
 * 
 * @author portatil_profesorado
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        // Crear rect�ngulo
        System.out.println("Crear un rect�ngulo de base 2.5 y altura 8.5") ;
        Rectangulo miRect = new Rectangulo(2.5, 8.5) ;
        
        System.out.println("El n�mero de la dos del rect�ngulo es: " + miRect.getLados()) ;
        System.out.println("El �rea del rect�ngulo es: " + miRect.getArea()) ;
        System.out.println("El per�metro del rect�ngulo es: " + miRect.getPerimetro()) ;
        
        
         // Crear pent�gono regular
        System.out.println("\n\nCrear un pent�gono regular de lado 6.0") ;
        PentagonoRegular miPol = new PentagonoRegular(6.0) ;
        
        System.out.println("El n�mero de lados del pent�gono es: " + miPol.getLados()) ;
        System.out.println("El �rea del pent�gono es: " + miPol.getArea()) ;
        System.out.println("El per�metro del pent�gono es: " + miPol.getPerimetro()) ;
    }
    
}
