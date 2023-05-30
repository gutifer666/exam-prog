package ejercicio03;

/**
 * Clase Bicicleta que hereda de Vehículo
 * @author Profesor
 */
public class Bicicleta extends Vehiculo { 
    
    private final int numRadios ;

    public Bicicleta(int codigo, String nombre, int ruedas, int numRadios) {
        super(codigo, nombre, ruedas);
        this.numRadios = numRadios ;
    }

    @Override
    float getVelocidadMaxima() {
        return (float) (this.numRadios * 1.75 ) ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" número de radios: ").append(numRadios);
        return sb.toString();
    }
    
    
    
}