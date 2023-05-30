package ejercicio03;

/**
 *
 * @author guti
 */
public abstract class Vehiculo {
    private final int codigo;
    private final String nombre;
    private final int numRuedas;

    public Vehiculo(int codigo, String nombre, int ruedas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numRuedas = ruedas;
    }

    @Override
    public String toString() {
        return String.format("Código: %d nombre: %s con: %d ruedas", this.codigo, this.nombre, this.numRuedas);
    }
    
    public abstract float getVelocidadMaxima();
    
}
