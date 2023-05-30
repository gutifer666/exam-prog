package ejercicio04;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Dada la clase Persona que se te da ya en el ejercicio (atributos: nombre, edad).
 *  Crear una lista enlazada LinkedList 
 *  Rellenar la lista con los siguintes valores.
 *  Recorrer la lista de modo que si la edad de la persona es mayor o igual 
 *  que 18, añada a una línea en el fichero de texto adultos.txt y si es menor
 *  añada una línea en el fichero de texto jovenicos.txt
 * 
 * 
 * @author Profesor.
 */
public class Ejercicio04 {
    
    public static void main(String[] args) {
        
        System.out.println("-- De Lista a fichero de TEXTO --");
        System.out.println("---------------------------------");

        List<Persona> listalinked = new LinkedList<>();
        
        listalinked.add(new Persona("Arturo" ,25)); 
        listalinked.add(new Persona("Diana" ,24)); 
        listalinked.add(new Persona("Vicente", 7)); 
        listalinked.add(new Persona("Carlos", 3)); 
        listalinked.add(new Persona("Ada", 49)); 
        
     
        
        try ( // Abrimos los archivos para escritura (creación o sobrescriturasi ya existe).
                FileWriter ficheroAdul = new FileWriter("adultos.txt"); 
                PrintWriter paw = new PrintWriter(ficheroAdul);
                FileWriter ficheroJov = new FileWriter("jovenicos.txt"); 
                PrintWriter pjw = new PrintWriter(ficheroJov);) {  
            
            Iterator<Persona> iterator = listalinked.iterator();
            while (iterator.hasNext()) {
                // Elemento:
                Persona miPersona = iterator.next() ;
                
                // 
                if (miPersona.getEdad() >= 18 ) {
                    // Añadir a fichero
                    paw.println(miPersona.toString());
                } else {
                    // Añadir a fichero
                    pjw.println(miPersona.toString());
                }
                
                System.out.println(miPersona.toString());
                

            }
        
            // No es necesario close() porque se usa un try-with-resources.
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("Error");
        } 
        
    }
    
}