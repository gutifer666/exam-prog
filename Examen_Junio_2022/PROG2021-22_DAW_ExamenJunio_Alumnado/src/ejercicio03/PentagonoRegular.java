package ejercicio03;

/**
 *
 * @author guti
 */
public class PentagonoRegular implements Poligono {
    
    private final int numLados = 5;
    private final double lado;

    public PentagonoRegular(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double getArea() {
        // https://www.universoformulas.com/matematicas/geometria/area-pentagono
        return (this.lado * this.lado) * 1.72;
    }

    @Override
    public int getLados() {
        return numLados;
    }

    @Override
    public double getPerimetro() {
        return this.numLados * this.lado;
    }
    
}
