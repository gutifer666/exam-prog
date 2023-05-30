package Ejercicio3;

import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

public class AeroGeneradorXML {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos
     * AeroGenerador
     */
    private String rutaArchivo;
    /**
     * Objeto Xstream que permite la L/E con archivos XML
     */
    private XStream xstream;

    /**
     * Método constructor
     *
     * @param archivo Ruta del archivo donde se lee y escribe la colección de
     * objetos AeroGenerador
     */
    public AeroGeneradorXML(String nombreArchivo) {
        super();
        this.rutaArchivo = nombreArchivo;
        xstream = new XStream(new DomDriver("UTF-8"));
//        Permite asignar privilegios para poder operar con los archivos XML
        xstream.allowTypesByWildcard(new String[]{
            "Ejercicio3.**"
        });
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
            FileWriter ficheroSalida;
            ficheroSalida = new FileWriter(new File(rutaArchivo));
            // Escribo el array en el fichero
            xstream.alias("aeroGenerador", AeroGenerador.class);

            ficheroSalida.write(xstream.toXML(aeroGens));

            // Cerramos el fichero
            ficheroSalida.close();

            System.out.println("El archivo " + rutaArchivo + " se ha cargado con éxito...");
        } catch (FileNotFoundException fnfe) {
            System.err.println("El fichero " + rutaArchivo + " no existe.");
        } catch (IOException ioe) {
            System.err.println("Error: falló la escritura en el fichero " + rutaArchivo);
        }
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
            
            File archivo = new File(rutaArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder ficheroString = new StringBuilder();
            
            String linea = "";
            while ((linea = br.readLine()) != null){
                ficheroString.append(linea);
            }
            xstream.alias("list", List.class);
            xstream.alias("aeroGenerador", AeroGenerador.class);
            xstream.autodetectAnnotations(true);
            List<Object> list = (List<Object>) xstream.fromXML(ficheroString.toString(), new AeroGenerador());
            // Cerrar el fichero
            br.close();
            fr.close();
            System.out.println("El archivo " + rutaArchivo + " se ha cargado con éxito...");
            return list;
        } catch (FileNotFoundException fnfe) {
            System.err.println("El fichero " + rutaArchivo + " no existe.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error de Entrada/Salida: Falló la lectura del fichero. La aplicación sigue funcionando sin haber cargado los datos del archivo, para permitir crearlo de nuevo.");
        }
        return new ArrayList();
    }
}
