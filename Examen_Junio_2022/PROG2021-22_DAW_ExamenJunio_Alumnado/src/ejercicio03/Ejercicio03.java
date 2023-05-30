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
        Rectangulo miRectangulo = new Rectangulo(2.5, 8.5);
        PentagonoRegular miPentagono = new PentagonoRegular(6.0);
        
        System.out.println("Crear un rect�ngulo de base 2.5 y altura 8.5");
        System.out.printf("El n�mero de la dos del rect�ngulo es: %d\n", miRectangulo.getLados());
        System.out.printf("El �rea del rect�ngulo es: %f\n", miRectangulo.getArea());
        System.out.printf("El per�metro del rect�ngulo es: %f\n", miRectangulo.getPerimetro());
        
        System.out.println("Crear un pent�gono regular de lado 6.0");
        System.out.printf("El n�mero de la dos del pent�gono es: %d\n", miPentagono.getLados());
        System.out.printf("El �rea del rect�ngulo es: %f\n", miPentagono.getArea());
        System.out.printf("El per�metro del rect�ngulo es: %f\n", miPentagono.getPerimetro());
    }
    
}
