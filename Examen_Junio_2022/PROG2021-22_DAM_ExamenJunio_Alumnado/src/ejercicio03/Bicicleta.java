package ejercicio03;

/**
 *
 * @author guti
 */
public class Bicicleta extends Vehiculo{
    private final int numRadios;

    public Bicicleta(int codigo, String nombre,int ruedas, int numRadios) {
        super(codigo, nombre, 2);
        this.numRadios = numRadios;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" con %d número de radios", this.numRadios);
    }
    
    

    @Override
    public float getVelocidadMaxima() {
        return (float)this.numRadios * (float)1.75;
    }

}

