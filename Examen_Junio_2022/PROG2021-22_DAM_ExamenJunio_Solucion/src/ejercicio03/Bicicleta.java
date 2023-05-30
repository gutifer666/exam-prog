package ejercicio03;

/**
 * Clase Bicicleta que hereda de Veh�culo
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
        sb.append(" n�mero de radios: ").append(numRadios);
        return sb.toString();
    }
    
    
    
}