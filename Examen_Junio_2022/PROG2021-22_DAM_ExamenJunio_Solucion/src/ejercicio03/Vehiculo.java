package ejercicio03;

/**
 * Clase abstracta Veh�culo
 * 
 * @author profesorado
 */
public abstract class Vehiculo {
    private final int codigo ;
    private final String nombre ;
    private final int numRuedas ;
    
    public Vehiculo(int codigo, String nombre, int ruedas) {
        this.codigo = codigo ;
        this.nombre = nombre ;
        this.numRuedas = ruedas ;
    }

    @Override
    public String toString() {
        return "C�digo: " + codigo + " nombre: " + nombre + " con: " +
                numRuedas + " ruedas" ;
    }
    
    abstract float getVelocidadMaxima() ;
    
}
