/*
 * Clase Persona
 */
package ejemplointerfazimprimible;

/**
 * Clase Persona
 */
public abstract class Persona implements Imprimible {
        protected String nombre;
        protected String apellidos;
        protected String poblacion;

        // Constructores
        // -------------
                
        // Constructor
        public Persona (String nombre, String apellidos, String poblacion) {           
            this.nombre= nombre;
            this.apellidos= apellidos;
            this.poblacion= poblacion;
        }
        
        // Métodos get
        // -------------
        
        // Método getNombre
        protected String getNombre (){
            return nombre;
        }
        
        // Método getApellidos
        protected String getApellidos (){
            return apellidos;
        }
        
        // Método getPoblacion
        protected String getPoblacion (){
            return this.poblacion;
        }

        // Métodos set
        // -------------

        // Método setNombre
        protected void setNombre (String nombre){
            this.nombre= nombre;
        }
        
        // Método setApellidos
        protected void setApellidos (String apellidos){
            this.apellidos= apellidos;
        }
        
        // Método setPoblacion
        protected void setPoblacion (String poblacion){
            this.poblacion= poblacion;
        }       
                
        // Implementación de los métodos de la interfaz Imprimible
        // -------------------------------------------------------

        // Método getNumAtributos
        @Override
public int getNumAtributos () {
    // La clase persona tiene tres atributos
    int resultado= 3;
    return resultado;
}
        
        // Método getNombreAtributos
        @Override
        public String[] getNombreAtributos () {
            String[] resultado= new String [3];
            // Escribimos el nombre de los tres atributos en las posiciones del array
            resultado[0]= "nombre";
            resultado[1]= "apellidos";
            resultado[2]= "poblacion";
            return resultado;
        }

        // Método getContenidoArray 
        @Override
        public String[] getContenidoArray () {
            String[] resultado= new String [3];
            // Escribimos el contenido de los tres atributos en las posiciones del array
            resultado[0]= this.nombre;
            resultado[1]= this.apellidos;
            resultado[2]= this.poblacion;
            return resultado;
        }

        // Método getContenidoString 
        @Override
        public String getContenidoString () {
            String[] arrayNombres= this.getNombreAtributos();
            String[] arrayContenidos= this.getContenidoArray();
            int numAtributos= this.getNumAtributos();
            StringBuilder resultado= new StringBuilder ();

            // Llave de inicio
            resultado.append("{") ;
            // Grueso de los elementos de la lista (todos menos el último)
            int i;
            for (i=0; i<numAtributos-1; i++) {
                resultado.append((arrayNombres[i] + "=" + arrayContenidos[i] + ", "));
            }
            // Último elemento (sin coma al final)
            resultado.append((arrayNombres[numAtributos-1] + "=" + arrayContenidos[numAtributos-1]));
            // Llave de de fin        
            resultado.append("}") ;

            return resultado.toString();
        }
        
        
}

