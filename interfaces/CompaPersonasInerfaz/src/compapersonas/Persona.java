package compapersonas;
/**
 * Clase Persona que implemente el interface Comparable.
 * Por ello, además del implements Comparable que hay al inicio de la clase, se
 * debe implementar el método:  int compareTo. 
 * 
 * @author Profesor
 */
public class Persona implements Comparable {

    protected String nombre;
    protected int edad;
    protected float altura;
    protected String ocupacion;
    protected String nif; 

    /**
     * Constructor por defecto de la clase Persona.*/
    public Persona(String nif) throws IllegalArgumentException{
        nombre = "Sin nombre";
        edad = 0;
        altura = 0.0f;
        ocupacion = "Sin ocupación";
        this.setNif(nif);   
    }

     /**
     * Constructor de la clase Persona.
     * Se inicializa con los valores recibidos por parámetros.
     * 
     * @param nombre El nombre de la persona. 
     * @param edad La edad de la persona. 
     * @param altura La altura de la persona, con decimales. 
     * @param ocupacion La ocupación de la persona. 
     * @param nif El nif que se pretende asignar a esa persona.
     * 
     */
    public Persona(String nombre, int edad, float altura, String ocupacion, String nif) throws IllegalArgumentException { 
        this(nif);                                                                       
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.ocupacion = ocupacion;
       // this.setNif(nif);
    }
/* Métodos get*/    
    /**
     * Devuelve el nombre de la persona.
     * 
     * @return nombre de la persona
     */
     protected String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve la edad de la persona.
     * 
     * @return edad de la persona
     */
    protected int getEdad() {
        return edad;
    }
    
     /**
     * Devuelve la altura de la persona.
     * 
     * @return altura de la persona
     */
     protected float getAltura() {
        return altura;
    }
    /**
     * Devuelve la ocupación de la persona.
     * 
     * @return ocupación de la persona.
     */
    protected String getOcupacion() {
        return ocupacion;
    }
    
     /**
     * Devuelve el NIF de la persona.
     * 
     * @return el NIF de la persona.
     */
    protected String getNif() {
        return nif;
    }

/* Métodos set*/    
   
    /**
     * Asigna un nuevo nombre a la persona.
     * 
     * @param nombre 
     */
    protected void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre==null){
             throw new IllegalArgumentException("Se debe indicar el nombre que hay que asignar.");
        }else{
           this.nombre = nombre;
        }
    }

    /**
     * Asigna una nueva edad a la persona.
     * 
     * @param edad 
     */
    protected void setEdad(int edad) throws IllegalArgumentException  {
        if (edad<0){
             throw new IllegalArgumentException("La edad debe ser un entero positivo.");
        }else{
           this.edad = edad;
        }
    
    }

    /**
     * Asigna una nueva altura a la persona.
     * 
     * @param altura 
     */
    protected void setAltura(float altura) {
        if (altura<0){
             throw new IllegalArgumentException("La altura debe ser un número positivo.");
        }else{
          this.altura = altura;
        }
    }

    /**
     * Asigna una nueva ocupación a la persona.
     * 
     * @param ocupacion 
     */
    protected void setOcupacion(String ocupacion) {
        if (ocupacion==null){
             throw new IllegalArgumentException("Se debe indicar la ocupación que hay que asignar.");
        }else{
             this.ocupacion = ocupacion;
        }
    }
    
    /**
     * Suponemos queque el NIF que se pasa como argumento es válido y 
     * lo asigna a la persona.
     * 
     * @param nif El NIF que se pretende asignar a la persona. 
     */
    protected void setNif(String nif) throws IllegalArgumentException {
        if (nif == null)
            throw new IllegalArgumentException("No se puede asignar un NIF, no se  ha facilitado el NIF a asignar");
        else {
            nif = nif.toUpperCase(); // para que la letra se pase a mayúscula 
            this.nif = nif;
        }
    }
    
    /**
     * 
     * @return  Una cadena con los datos de una persona.
     */
    @Override
    public String toString(){
        String cadena="\tNombre: "+this.nombre+". NIF: "+this.nif+".\n\t"+"Edad: "+this.edad+". Altura: "+this.altura+". Ocupación: "+this.ocupacion+".";
        return cadena;
    }

    /**
     * 
     * @param objeto de tipo persona
     * @return 0 si la edad es la misma.
     *         1 si la edad es menor que la del objeto parámetro
     *        -1 si la edad es mayor que la del objeto parámetro
     */
    @Override
    public int compareTo(Object o) {
        int resultado = 0 ;
       
        Persona otra = (Persona)o ;
        if (this.edad < otra.edad) 
            resultado = -1;      
        else if (this.edad > otra.edad)
            resultado = 1;  

        return resultado;
    }
}
