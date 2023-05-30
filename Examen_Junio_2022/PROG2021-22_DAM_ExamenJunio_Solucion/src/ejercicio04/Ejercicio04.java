package ejercicio04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Dada la clase Coche que se te da ya en el ejercicio (atributo: nombre).
 *  Crear un mapa para almacenar los valores leídos, por tanto la clave 
 * entera y el valor de la clase Coche
 * Abrir el fichero coches.txt que se te proporciona y para cada línea leíada,
 * crear el objeto coche con el valor leído, almacenar el el mapa con la clave
 * contador actual y el objeto coche recién creado
 * 
 * 
 * @author Profesor.
 */
public class Ejercicio04 {
    
    public static void main(String[] args) {
        
        System.out.println("-- Lectura de fichero de Texto --");
        System.out.println("---------------------------------");

  
     
        Map<Integer, Coche> map = new HashMap<>();
        
        
        try {
            // Abrimos el fichero para electura
            File doc = new File("coches.txt");

            try (BufferedReader obj = new BufferedReader(new FileReader(doc))) {
                String strng;
                int contador = 1 ;
                while ((strng = obj.readLine()) != null) {
                    //System.out.println(strng);
                    Coche miCoche = new Coche(strng) ;
                    map.put(contador, miCoche);
                    contador++ ;
                }
            }
            
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("Error");
        } 
        
       // Escribir el contenido del mapa
       // Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
       
       System.out.println("\n\n----- Contenido del mapa -----");
       
       Iterator it = map.keySet().iterator();
       while(it.hasNext()){
           Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
        }
        
    }
    
}