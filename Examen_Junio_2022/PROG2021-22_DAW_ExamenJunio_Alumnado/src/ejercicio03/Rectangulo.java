package ejercicio03;

/**
 *
 * @author guti
 */
public class Rectangulo implements Poligono {
    
    private final int numLados = 4;
    private final double base;
    private final double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
      
    @Override
    public double getArea() {
        return this.base * this.altura;
    }

    @Override
    public int getLados() {
        return numLados;
    }

    @Override
    public double getPerimetro() {
        return 2 * this.base + 2 * this.altura;
    }
    
}
