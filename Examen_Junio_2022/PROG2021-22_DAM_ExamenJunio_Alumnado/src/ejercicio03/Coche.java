package ejercicio03;

/**
 *
 * @author guti
 */
public class Coche extends Vehiculo{
    private final int cilindros;
    private final static int RUEDAS = 4;

    public Coche(int codigo, String nombre, int cilindros) {
        super(codigo, nombre, RUEDAS);
        this.cilindros = cilindros;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" con %d cilindros", this.cilindros);
    }
    
    

    @Override
    public float getVelocidadMaxima() {
        return (float) ((this.cilindros * 100) / 1.85);
    }

}
