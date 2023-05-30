/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author profesorado
 */
public class InformeComercial {
    
    private String nombre;
    private String nif;
    
    private double ventasInternacional;
    private double ventasNacional;
    
    private double sueldo;
    
    private boolean objetivoCumplido;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the ventasInternacional
     */
    public double getVentasInternacional() {
        return ventasInternacional;
    }

    /**
     * @param ventasInternacional the ventasInternacional to set
     */
    public void setVentasInternacional(double ventasInternacional) {
        this.ventasInternacional = ventasInternacional;
    }

    /**
     * @return the ventasNacional
     */
    public double getVentasNacional() {
        return ventasNacional;
    }

    /**
     * @param ventasNacional the ventasNacional to set
     */
    public void setVentasNacional(double ventasNacional) {
        this.ventasNacional = ventasNacional;
    }

    /**
     * @return the sueldo
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @return the objetivoCumplido
     */
    public boolean isObjetivoCumplido() {
        return objetivoCumplido;
    }

    /**
     * @param objetivoCumplido the objetivoCumplido to set
     */
    public void setObjetivoCumplido(boolean objetivoCumplido) {
        this.objetivoCumplido = objetivoCumplido;
    }
   
    @Override
    public String toString(){
      //usamos el método format para rellenar con espacios
         return String.format("%-50s", this.nombre)+String.format("%-14s", this.nif)+String.format("%-14s", this.ventasNacional)+String.format("%-14s", this.ventasInternacional)+String.format("%-14s", this.sueldo)+String.format("%-14s", this.objetivoCumplido);
    }
}
