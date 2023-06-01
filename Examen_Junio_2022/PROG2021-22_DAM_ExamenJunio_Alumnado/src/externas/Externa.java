package externas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Externa {
    public static void main(String[] args) {
        
        String nuevoCoche = "Coche Nuevo 3";
    
        try {
            // Abrimos el fichero para electura
            File doc = new File("coches.txt");
            
            // Creamos el objeto de tipo BufferedReader para leer el archivo de texto con el constructor FileReader, que recibe el objeto File.
            try (BufferedReader obj = new BufferedReader(new FileReader(doc))) {
                
                String linea;

                while ((linea = obj.readLine()) != null){
                    
                    System.out.println(linea);
                    
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado.");
        } catch (IOException e) {
            // si no se tienen permisos de lectura o escritura o si el archivo est? da?ado
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error");
        }

        // Añadir un nuevo coche al fichero
        // Abrimos el fichero para escritura
        try {
            File doc = new File("coches.txt");
            // Creamos el objeto de tipo BufferedWriter para escribir en el archivo de texto con el constructor FileWriter, que recibe el objeto File.
            try (BufferedWriter obj = new BufferedWriter(new FileWriter(doc, true))) {
                // Escribimos en el archivo con el método write
                obj.write(nuevoCoche);
                // Escribimos en el archivo con el método newLine
                obj.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado.");
        } catch (IOException e) {
            // si no se tienen permisos de lectura o escritura o si el archivo est? da?ado
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error");
        }

    }
}
