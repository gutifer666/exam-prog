package tarea07;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 1. Gestionando mascotas
 * @author Profesor
 */

public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        
        final int NUMERO_MASCOTAS = 4;
        
        // Variables de entrada
        
        // Variables auxiliares
        Mascota mascota;
        
        // Variables de salida
        Set<Mascota> setMascotas1, setMascotas2, unionMascotas, interseccionMascotas, diferenciaMascotas;
        
        // Usamos conjuntos Set
        setMascotas1 = new HashSet<>();
        setMascotas2 = new HashSet<>();
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE MASCOTAS");
        System.out.println("---------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Rellenamos los conjuntos con aleatorios hasta que haya NUMERO_MASCOTAS
        while (setMascotas1.size() < NUMERO_MASCOTAS && setMascotas2.size() < NUMERO_MASCOTAS) {
            
            // Si la mascota ya está en el conjunto, no la añadimos
            
            mascota = Utilidades.mascotaAleatoria();
            
            if (!setMascotas1.contains(mascota)) {
            
                setMascotas1.add(mascota); 
            }
            
            // Si la mascota ya está en el conjunto, no la añadimos
            
            mascota = Utilidades.mascotaAleatoria();
            
            if (!setMascotas2.contains(mascota)) {
                
                setMascotas2.add(mascota); 
            }
        }
        
        // Unión de los dos conjuntos 
        unionMascotas = new HashSet<>(setMascotas1);
        unionMascotas.addAll(setMascotas2);
        
        // Intersección del conjunto de unión con el primer conjunto de mascotas
        interseccionMascotas = new HashSet<>(unionMascotas);
        interseccionMascotas.retainAll(setMascotas1);
        
        // Diferencia de los conjuntos de unión con el primer conjunto de mascotas
        diferenciaMascotas = new HashSet<>(unionMascotas);
        diferenciaMascotas.removeAll(setMascotas1);
        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        
        // Mostramos los conjuntos por pantalla
        System.out.printf("Conjunto Mascotas1:\n %s\n", setMascotas1);
        System.out.printf("Conjunto Mascotas2:\n %s\n", setMascotas2);
        System.out.println();
        System.out.printf("Unión Mascotas1 y Mascotas2:\n %s\n", unionMascotas);
        System.out.printf("Intersección Unión y Mascotas1:\n %s\n", interseccionMascotas);
        System.out.printf("Diferencia Unión-Mascotas1:\n %s\n", diferenciaMascotas);
        System.out.println();
    }
}
