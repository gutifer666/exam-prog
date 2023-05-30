package tarea07;

/**
 * Clase Utilidades
 * @author Profesor
 */
public class Utilidades {

    private final static String[] nombresMasculinos = {"Coco", "Lassie", "Milo", "Toby", "Pancho", "Salem", "Ciro"};

    private final static String[] nombresFemeninos = {"Luna", "Mía", "Nala", "Nina", "Lola", "India", "Misha"};
    
    private final static String[] sexo = {"Macho", "Hembra"};
    
    private final static String[] razaPerros = {"Mestizo", "Caniche", "Labrador", "Yorkshire", "Boxer", "Beagle", "Dachshund"};
    
    private final static String[] razaGatos = {"Mestizo", "Siamés", "Azul ruso", "Europeo", "Americano", "Angora", "Snowshoe"};
    
    private final static String[] caracteristicas = {"Pelo corto", "Pelo largo", "Negro", "Blanco", "Manchas", "Pardo", "Castaño"};
    
    /** Devuelve un objeto que representa una mascota aleatoria.
     * 
     * @return Mascota un objeto de la clase Mascota aleatoria
     */
    
    public static Mascota mascotaAleatoria() {
        
        int aleatorioSexo = (int) (Math.random() * sexo.length);
        int aleatorio = (int) (Math.random() * nombresMasculinos.length);
        int aleatorioCaracteristicas = (int) (2 + Math.random() * (caracteristicas.length - 2));
        
        String nombre = "Macho".equals(sexo[aleatorioSexo]) ? nombresMasculinos[aleatorio] : nombresFemeninos[aleatorio];
        
        int edad = (int) (Math.random()*12);
        
        // si aleatorio es par animal será perro; si aleatorio es impar animal será gato
        
        String tipo = aleatorio % 2 == 0 ? ("Macho".equals(sexo[aleatorioSexo]) ? "Perro" : "Perra") : ("Macho".equals(sexo[aleatorioSexo]) ? "Gato" : "Gata");
        
        String raza = tipo.startsWith("P") ? razaPerros[aleatorio] : razaGatos[aleatorio];
        
        return new Mascota(nombre, edad, tipo, sexo[aleatorioSexo], raza, caracteristicas[aleatorio % 2], caracteristicas[aleatorioCaracteristicas]);
    }
}