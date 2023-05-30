/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;


import java.util.ArrayList;
import java.util.List;


/**
 * Programa para trabajar con archivos XML.
 * @profesorado
 */
public class Ejercicio3 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDAeroGens.xml";
        List<AeroGenerador> misAeroGens=null;
        AeroGeneradorXML bd = null;
        List aeroGensBD = null;
        
        // Variables de salida

        // Variables auxiliares
        
        //----------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------        
        misAeroGens = new ArrayList<>();
        misAeroGens.add(new AeroGenerador());
        misAeroGens.add(new AeroGenerador());
        misAeroGens.add(new AeroGenerador());
        
        
        bd = new AeroGeneradorXML(ruta);
        
        System.out.printf("He creado y almaceno en el archivo %d aero generadores.\n",misAeroGens.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(misAeroGens.toString());
        

        bd.escribir(misAeroGens);

        
          
        misAeroGens.add(new AeroGenerador());
        misAeroGens.add(new AeroGenerador());
        
        System.out.printf("Ahora inserto 2 aeroGens más. Tengo ahora %d aero generadores.\n",misAeroGens.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN EL ARRAYLIST:");
        System.out.println(misAeroGens.toString());
        
        aeroGensBD=null;

        aeroGensBD = bd.leer();
 
        System.out.printf("Leo del archivo %d aero generadores.\n",aeroGensBD.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(aeroGensBD.toString());
    }
}
