package tarea07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

/** Ejercicio 3. La mascota del mes
 * @author Profesor
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        final int MESES = 12;
        
        // Variables de entrada
        
        // Variables auxiliares
        Mascota mascota;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Variables de salida
        Map<LocalDate, Mascota> mapMascotasPorMes = new TreeMap<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("LA MASCOTA DEL MES");
        System.out.println("-------------------");
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Vamos creando las claves del map y asignando una mascota para cada clave
        
        // La mascota no puede repetirse
        LocalDate fechaInicial = LocalDate.of(2023, 1, 1);  
        
        // Recorremos fechas desde 01/01/2023 hasta 01/12/2023
        for (LocalDate fecha = fechaInicial; fecha.isBefore(fechaInicial.plusMonths(MESES)); fecha = fecha.plusMonths(1)) {
            
            boolean mascotaRepetida = true;
            
            do { // Generamos una mascota aleatoria y la insertamos en la nueva fecha sólo si aún no ha salido
                mascota = Utilidades.mascotaAleatoria();
                
                if (!mapMascotasPorMes.containsValue(mascota)) {
                    mapMascotasPorMes.put(fecha, mascota);
                    mascotaRepetida = false;
                }
            } while (mascotaRepetida);
        }
   
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
        System.out.printf("Contenido final del mapa de mascotas organizado por fechas:\n\n");
        for (Map.Entry<LocalDate, Mascota> elemento: mapMascotasPorMes.entrySet()) {
            
            System.out.printf("Fecha %s: %s\n",elemento.getKey().format(formatoFecha),elemento.getValue());
        }
    }
}
