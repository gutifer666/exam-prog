package tarea07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Ejercicio 4. Clasificación de mascotas coincidentes (con el mismo nombre y en
 * la misma posición)
 *
 * @author Profesor
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUMERO_MASCOTAS = 20;

        // Variables de entrada
        // Variables auxiliares
        Mascota mascota1;
        Mascota mascota2;

        List<Mascota> listaMascotas1 = new ArrayList<>();
        List<Mascota> listaMascotas2 = new ArrayList<>();

        // Variables de salida
        Map<String, List<Integer>> mapCoincidencias = new HashMap<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");

        // Rellenamos la lista 1 con mascotas aleatorias hasta que haya NUMERO_MASCOTAS
        
        while (listaMascotas1.size() < NUMERO_MASCOTAS) {

            mascota1 = Utilidades.mascotaAleatoria();

            if (!listaMascotas1.contains(mascota1)) {

                listaMascotas1.add(mascota1);
            }
        }
        
        // Rellenamos la lista 2 con mascotas aleatorias hasta que haya NUMERO_MASCOTAS
        
        while (listaMascotas2.size() < NUMERO_MASCOTAS) {

            mascota2 = Utilidades.mascotaAleatoria();
            
            if (!listaMascotas2.contains(mascota2)) {

                listaMascotas2.add(mascota2);
            }
        }
        
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        Iterator it1 = listaMascotas1.iterator();
        Iterator it2 = listaMascotas2.iterator();

        while (it1.hasNext() && it2.hasNext()) {

            mascota1 = (Mascota) it1.next();
            mascota2 = (Mascota) it2.next();

            if (mascota1.getNombre().equals(mascota2.getNombre())) {
                if (!mapCoincidencias.containsKey(mascota1.getNombre())) {

                    mapCoincidencias.put(mascota1.getNombre(), new ArrayList<>());
                }
                mapCoincidencias.get(mascota1.getNombre()).add(listaMascotas1.indexOf(mascota1));
            }
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido inicial de la lista mascotas1:\n %s\n", listaMascotas1.toString());
        System.out.printf("Contenido inicial de la lista mascotas2:\n %s\n", listaMascotas2.toString());
        System.out.println();

        System.out.printf("Clasificación de coincidencias:\n %s\n", mapCoincidencias.toString());

    }
}
