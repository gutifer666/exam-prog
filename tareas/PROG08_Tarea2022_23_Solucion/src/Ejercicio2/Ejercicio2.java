/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Programa para trabajar con archivos binarios y objetos serializables.
 * @profesorado
 */
public class Ejercicio2 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){
        try {
            System.setOut(new PrintStream(System.out, true, "UTF8"));
            //----------------------------------------------
            //          Declaración de variables
            //----------------------------------------------
            
            // Constantes
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }


        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDAeroGen.dat";
        List<AeroGenerador> misAerog=null;
        AeroGeneradorIO bd = null;
        List aeroGenBD = null;
        
        // Variables de salida

        // Variables auxiliares
        
        //----------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------
        misAerog = new ArrayList<>();
        misAerog.add(new AeroGenerador(LocalDate.now(), 160));
        misAerog.add(new AeroGenerador());
        misAerog.add(new AeroGenerador());
   
        
        bd = new AeroGeneradorIO(ruta);
        
        System.out.printf("He creado y almaceno en el archivo %d aero generadores.\n",misAerog.size());
        System.out.println("LISTADO AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(misAerog.toString());
        
        bd.escribir(misAerog);
          
        misAerog.add(new AeroGenerador());
        misAerog.add(new AeroGenerador());
        
        System.out.printf("Ahora inserto 2 aero generadores más. Tengo ahora %d aero generadores.\n",misAerog.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN EL ARRAYLIST:");
        System.out.println(misAerog.toString());
        
        aeroGenBD = bd.leer();
        System.out.printf("Leo del archivo %d aero generadores.\n",aeroGenBD.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(aeroGenBD.toString());        
    }
}
