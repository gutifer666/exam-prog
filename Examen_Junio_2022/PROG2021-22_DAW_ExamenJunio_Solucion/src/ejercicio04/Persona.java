package ejercicio04;

/**
 * Clase Persona, con solo dos atributos: nombre y edad
 * @author Profesor
 */
public class Persona {
    private final String nombre ;
    private int edad ;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append(", edad: ").append(edad);
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    
}
