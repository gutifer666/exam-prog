package tarea07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/** Ejercicio 2. Clasificación de mascotas
 * @author Profesor
 */

public class Ejercicio02 {

    public static void main(String[] args) {
       
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        
        final int NUMERO_MASCOTAS = 10;
        
        // Variables de entrada
        
        // Variables auxiliares
        Mascota mascota;
        // nos permitirá llevar la cuenta de posiciones para la lista de posiciones eliminadas
        int cont = 0;
        
        // Variables de salida
        List<Mascota> listaMascotas = new ArrayList<>();
        List<Mascota> listaMascotasPerros = new ArrayList<>();
        List<Mascota> listaMascotasGatos = new ArrayList<>();
        List<Mascota> listaMascotasHembras = new ArrayList<>();
        List<Mascota> listaMascotasMachos = new ArrayList<>();
        List<String> listaMascotasEliminadas = new ArrayList<>();
        Set<String> setMascotasEliminadas = new HashSet<>();
        List<Integer> listaPosicionesEliminadas = new ArrayList<>();
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("CLASIFICACIÓN DE MASCOTAS");
        System.out.println("-------------------------");

        // Rellenamos la lista con mascotas aleatorias hasta que haya NUMERO_MASCOTAS
        
        for (int i = 0; i < NUMERO_MASCOTAS; i++) {
            
            // Si la mascota ya está en la lista, no la añadimos
            
            mascota = Utilidades.mascotaAleatoria();
            
            if (!listaMascotas.contains(mascota)) {
            
                listaMascotas.add(mascota); 
            }
        }

        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------

        // Recorremos la lista mediante un iterador
        
        Iterator it = listaMascotas.iterator();
        
        while (it.hasNext()) {
        
            // Llevamos la cuenta de las posiciones para la lista de posiciones eliminadas
            cont++;

            mascota = (Mascota) it.next();
            
            // clasificamos las mascotas por tipo (Perr@, Gat@)
            // otra opción: comparar con los valores Perro y Perra
            // if (mascota.getTipo().equalsIgnoreCase("perro") || mascota.getTipo().equalsIgnoreCase("perra")) {
            if (mascota.getTipo().startsWith("P")) {
            
                listaMascotasPerros.add(mascota);
                
                // eliminamos l@s perr@s de la lista, almacenando su nombre
                listaMascotasEliminadas.add(mascota.getNombre());
                setMascotasEliminadas.add(mascota.getNombre());
                listaPosicionesEliminadas.add(cont);
                it.remove();
                
                // otras opciones para borrar de la lista
//                listaMascotas.remove(mascota);
//                listaMascotas.remove(cont);
                
            } else {
            
                listaMascotasGatos.add(mascota);
            }
            
            // clasificamos las mascotas por sexo (Macho, Hembra)
            if (mascota.getSexo().equalsIgnoreCase("macho")) {
            
                listaMascotasMachos.add(mascota);
                
            } else {
            
                listaMascotasHembras.add(mascota);
            }
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
      
        System.out.printf("1. Contenido inicial de la lista mascotas:\n %s\n", listaMascotas.toString());
        System.out.printf("2. Contenido final de la lista de mascotas:\n  %s\n", listaMascotas.toString());
        System.out.printf("3. Contenido final de la lista de perr@s:\n  %s\n", listaMascotasPerros.toString());
        System.out.printf("4. Contenido final de la lista de gat@s:\n  %s\n", listaMascotasGatos.toString());
        System.out.printf("5. Contenido final de la lista de mascotas machos:\n  %s\n", listaMascotasMachos.toString());
        System.out.printf("6. Contenido final de la lista de mascotas hembras:\n  %s\n", listaMascotasHembras.toString());
        System.out.printf("7. Contenido final de la lista de nombres de mascotas eliminadas:\n %s\n", listaMascotasEliminadas.toString());
        System.out.printf("8. Contenido final de la lista de posiciones eliminadas:\n %s\n", listaPosicionesEliminadas.toString());
        System.out.printf("9. Contenido final del conjunto de nombres de mascotas eliminadas:\n %s\n", setMascotasEliminadas.toString());
        
    }
}
