package ejercicio03;

/**
 * Clase Coche que hereda de Vehículo
 * @author profesorado
 */
public class Coche extends Vehiculo {
    
    private final int cilindros ;
    
    /**
     * Constructor de la clase
     * 
     * @param codigo
     * @param nombre
     * @param cilindros
     */
    public Coche(int codigo, String nombre,int cilindros) {
        // Invocar al constructor indicando 4 ruedas
        super(codigo, nombre, 4) ;
        this.cilindros = cilindros ;
    }
    
    /**
     * Calcular la velocidad máxima del coche
     * @return velocidad máxima del coche
     */
    @Override
    float getVelocidadMaxima() {
        return (float) (this.cilindros * 100 / 1.85) ;
    }

    @Override
    public String toString() {
        return super.toString() + " con " + this.cilindros + " cilíndros." ;    
    }   
    
}