package ejercicio03;


/**
 * Clase PentagonoRegular
 * 
 * @author portatil_profesorado
 */
public class PentagonoRegular implements Poligono {
    private double lado ;

    public PentagonoRegular(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        // https://www.universoformulas.com/matematicas/geometria/area-pentagono
        return (lado*lado) * 1.72 ;
    }

    @Override
    public int getLados() {
        return 5 ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPerimetro() {
         return 5*lado ;
    }
    
    
}
