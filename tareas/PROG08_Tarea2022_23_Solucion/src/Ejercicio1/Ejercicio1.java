/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Programa para trabajar con archivos de texto.
 *
 * @profesorado
 */
public class Ejercicio1 {

    private static final String RUTA = System.getProperty("user.dir");

    /**
     * Método principal.
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        String rutaCoeficientes = RUTA + "/recursos/coeficientes.txt";
        String rutaComerciales = RUTA + "/recursos/listadoComerciales.txt";
        String rutaSalida = RUTA + "/recursos/informe.txt";

        String[] coeficientes = new String[4];

        double cN, cI;
        int limitePrima, minimoObjetivos;

        List<InformeComercial> listaInfomComer = new ArrayList<InformeComercial>();

        try ( BufferedReader bufferedReaderCoef = new BufferedReader(new FileReader(rutaCoeficientes))) {
            try ( BufferedReader bufferedReaderComer = new BufferedReader(new FileReader(rutaComerciales))) {

                // Lee la línea del archivo
                String lineCoef = bufferedReaderCoef.readLine();
                coeficientes = lineCoef.split(";");

                cN = Double.parseDouble(coeficientes[0]);
                cI = Double.parseDouble(coeficientes[1]);

                minimoObjetivos = Integer.parseInt(coeficientes[2]);
                limitePrima = Integer.parseInt(coeficientes[3]);
                
                String linea;
                while ((linea = bufferedReaderComer.readLine()) != null) {
                   String[] infoCOmercial = linea.split(";");
                   InformeComercial infCom = new InformeComercial();
                   infCom.setNombre(infoCOmercial[0]);
                   infCom.setNif(infoCOmercial[1]);
                   
                   infCom.setVentasNacional(Double.parseDouble(infoCOmercial[2]));                   
                   infCom.setVentasInternacional(Double.parseDouble(infoCOmercial[3]));
                   infCom.setSueldo(calcularSueldoComercial(infCom.getVentasNacional(), infCom.getVentasInternacional(), cN, cI, limitePrima));
                   infCom.setObjetivoCumplido(objetivosCumplidos(infCom.getVentasNacional(), infCom.getVentasInternacional(), minimoObjetivos));
                   
                   listaInfomComer.add(infCom);
                   System.out.println(infCom);
                }

            } catch (IOException e) {
                System.err.println("Error al leer el archivo comerciales: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo coeficientes: " + e.getMessage());
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida))) {
            bw.write(String.format("%-50s", "Nombre y apellidos")+String.format("%-14s", "DNI")+String.format("%-14s", "Ventas Nac.")+String.format("%-14s", "Ventas Inter.")+String.format("%-14s", "Sueldo")+String.format("%-14s", "Objetivos cumplidos"));
            bw.newLine();
            // Escribir cada línea del archivo
            for (InformeComercial informe : listaInfomComer) {
                bw.write(informe.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de salida: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Archivos cerrados y procesamento finalizado");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }

    /**
     *
     * @param ventasN Importe de ventas nacionales
     * @param ventasI Importe de ventas internacionales
     * @param cN Coeficiente que corresponde al tanto por ciento que recibe el
     * comercial por ventas nacionales
     * @param cI Coeficiente que corresponde al tanto por ciento que recibe el
     * comercial por ventas internacionales
     * @param limitePrima Cantidad a partir de la cual se cobra la prima extra
     * @return
     */
    public static double calcularSueldoComercial(double ventasN, double ventasI, double cN, double cI, int limitePrima) {
        double sueldoComercial = (ventasN * cN) / 100 + (ventasI * cI) / 100;
        if ((ventasN + ventasI) >= limitePrima) {
            sueldoComercial += (ventasN + ventasI) * 7 / 100;
        }
        return sueldoComercial;
    }

    /**
     *
     * @param ventasN Importe de ventas nacionales
     * @param ventasI Importe de ventas internacionales
     * @param minimoObjetivos Cantidad mínima en ventas para cubrir obejivos.
     * @return
     */
    public static boolean objetivosCumplidos(double ventasN, double ventasI, int minimoObjetivos) {
        return ((ventasN + ventasI) >= minimoObjetivos);
    }
}
