package Ejercicio2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AeroGeneradorIO {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos
     * AeroGenerador
     */
    private String rutaArchivo;

    /**
     * Método constructor
     *
     * @param archivo Ruta del archivo donde se lee y escribe la colección de
     * objetos AeroGenerador
     */
    public AeroGeneradorIO(String archivo) {
        this.rutaArchivo = archivo;
    }

    /**
     * Método que lee, desde un archivo binario, una colección de objetos
     * AeroGenerador serializados.
     *
     * @return Lista de objetos AeroGenerador que estaba almacenada en el
     * archivo binario.
     */
    public List leer() {
        try {
            // Abrimos el fichero para lectura
            FileInputStream fichero = new FileInputStream(new File(rutaArchivo));
            ObjectInputStream ficheroEntrada = new ObjectInputStream(fichero);

            // Recuperar el objeto array del fichero
            List listaAerogen =  (List) ficheroEntrada.readObject();


            // Cerrar el fichero
            ficheroEntrada.close();
            System.out.println("El archivo " + rutaArchivo + " se ha cargado con éxito...");
            return listaAerogen;
        } catch (ClassNotFoundException cnfe) {
            System.err.println("No se pudo acceder a la clase adecuada para revertir la Serialización al leer del fichero.");
        } catch (FileNotFoundException fnfe) {
            System.err.println("El fichero " + rutaArchivo + " no existe.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error de Entrada/Salida: Falló la lectura del fichero. La aplicación sigue funcionando sin haber cargado los datos del archivo, para permitir crearlo de nuevo.");
        }
        return new ArrayList();
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos
     * AeroGenerador serializables.
     *
     * @param aeroGens Lista de objetos AeroGenerador serializables para
     * almacenar en el archivo binario.
     */
    public void escribir(List aeroGens) {
        try {
            // Abrir fichero para escribir en el, en la ruta que me interesa
            FileOutputStream fichero = new FileOutputStream(new File(rutaArchivo));
            ObjectOutputStream ficheroSalida;
            ficheroSalida = new ObjectOutputStream(fichero);
            // Escribo el array en el fichero
            ficheroSalida.writeObject(aeroGens);

            // Cerramos el fichero
            ficheroSalida.close();

            System.out.println("El archivo " + rutaArchivo + " se ha cargado con éxito...");
        } catch (FileNotFoundException fnfe) {
            System.err.println("El fichero " + rutaArchivo + " no existe.");
        } catch (IOException ioe) {
            System.err.println("Error: falló la escritura en el fichero " + rutaArchivo);
        }
    }

}
