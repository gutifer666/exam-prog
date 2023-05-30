package ejercicio03;



/**
 *
 * @author portatil_profesorado
 */
public class Rectangulo implements Poligono {
    private double base ;
    private double altura ;

    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    

    @Override
    public double getArea() {
        double area = base * altura ;
        return area ;
    }

    @Override
    public int getLados() {
        return 4 ;
    }

    @Override
    public double getPerimetro() {
        return 2*base + 2*altura ;
    }
    
}
