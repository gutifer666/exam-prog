package tarea07;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** Ejercicio 5. Ordenación de mascotas (por nombre, por edad, por número de características)
 * @author Profesor
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        
        // Variables de entrada
        
        // Variables auxiliares
        
        // Variables de salida
       
        List<Mascota> listaMascotas = new LinkedList<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que vamos a introducir unos datos concretos
        
        System.out.println("ORDENACIÓN DE MASCOTAS");
        System.out.println("----------------------");

        // Rellenamos la lista con las mascotas
        
        listaMascotas.add(new Mascota("Happy End", 14, "Gata", "Hembra", "Europeo", "Pelo corto", "Tricolor"));
        listaMascotas.add(new Mascota("Nube", 8, "Perro", "Macho", "Samoyedo", "Pelo largo", "Blanco", "25kg"));
        listaMascotas.add(new Mascota("Tana", 7, "Gata", "Hembra", "Azul ruso", "Pelo largo"));
        listaMascotas.add(new Mascota("Khal", 6, "Perro", "Macho", "Akita Inu"));
        
        
        // Mostramos el contenido inicial de la lista
        System.out.printf("Contenido inicial de la lista:\n\n");
        mostrarListaMascotas(listaMascotas);
        
        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------

        // Ordenación de la lista por nombre de la mascota (alfabético) y la mostramos por pantalla
        System.out.printf ("\nOrdenación de la lista por nombre (alfabético):\n\n");
        Collections.sort(listaMascotas, new ComparadorMascotasPorNombre() );
        mostrarListaMascotas(listaMascotas);
        
        // Ordenación de la lista por edades y la mostramos por pantalla
        System.out.printf ("\nOrdenación de la lista por edad:\n\n");
        Collections.sort(listaMascotas, new ComparadorMascotasPorEdad() );
        mostrarListaMascotas(listaMascotas);

        // Ordenación de la lista por número de características de las mascotas y la mostramos por pantalla
        System.out.printf ("\nOrdenación de la lista por número de características que describen a la mascota:\n\n");
        Collections.sort(listaMascotas, new ComparadorMascotasPorNumCaracteristicas() );
        mostrarListaMascotas(listaMascotas);
    }

    // Método que recorre una lista de mascotas y las muestra cada una por pantalla
    static void mostrarListaMascotas (List<Mascota> listaMascotas) {
        
        int cont = 0;
        Iterator it = listaMascotas.iterator();
        
        while (it.hasNext()) {
        
            System.out.printf("%d. %s\n", ++cont, (Mascota)it.next());
        }        
    }
            
}

/**
 * Clase que permite comparar dos objetos Mascota usando como criterio
 * de comparación el nombre de esas mascotas. Se trata de una comparación
 * alfabética.
 * @author Profesor
 */
class ComparadorMascotasPorNombre implements Comparator<Mascota> {
    
    @Override
    public int compare (Mascota m1, Mascota m2) {
        
        return m1.getNombre().compareToIgnoreCase(m2.getNombre());
    }
}

/**
 * Clase que permite comparar dos objetos Mascota usando como criterio
 de comparación la edad de esas mascotas. 
 * @author Profesor
 */
class ComparadorMascotasPorEdad implements Comparator<Mascota> {
    
    @Override
    public int compare (Mascota m1, Mascota m2) {
       
        return m1.getEdad() -  m2.getEdad();
    }
}

/**
 * Clase que permite comparar dos objetos Mascota usando como criterio
 de comparación la cantidad de características que describen a esas mascotas.
 * @author Profesor
 */
class ComparadorMascotasPorNumCaracteristicas implements Comparator<Mascota> {
    
    @Override
    public int compare (Mascota m1, Mascota m2) {
        
        return m1.getCaracteristicas().size() -  m2.getCaracteristicas().size();
    }   
}
    
    
