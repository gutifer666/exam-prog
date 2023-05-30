package ejercicio04;

/**
 * Clase Coche, con solo un atributo: nombre
 * @author Profesor
 */
public class Coche {
    private final String nombre ;
    
    public Coche(String nombre) {
        this.nombre = nombre;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coche: ").append(nombre);
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

       
    
}
