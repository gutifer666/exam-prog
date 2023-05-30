package Ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UtilidadDirectorios {

    /**
     * Lista donde se almacenan los diferentes archivos y carpetas existentes en un directorio
     */
    private ArrayList vector;

    /**
     * Método constructor.
     */
    public UtilidadDirectorios() {
        vector = new ArrayList();
    }

    /**
     * Método que comprime una carpeta.
     * @param directorio Ruta del archivo o carpeta a comprimir.
     * @param salida Ruta donde ubicar el archivo comprimido.
     * @param nombreFichero Nombre del archivo comprimido.
     */
    public void zip(File directorio, String salida, String nombreFichero) {
        String outFilename = salida + File.separator + nombreFichero;
        byte[] buf = new byte[1024];
        vector.clear();
        listar(directorio);

        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
            for (int i = 0; i < vector.size(); i++) {
                FileInputStream in = new FileInputStream("" + vector.get(i));
                out.putNextEntry(new ZipEntry("" + vector.get(i)));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método recursivo que va explorando los archivos y carpetas de una carpeta dada.
     * @param dir Arhivo a comprimir.
     */
    private void listar(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                listar(new File(dir, children[i]));
            }
        } else {
            vector.add(dir);
        }
    }

}
