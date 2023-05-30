/*
 * Clase Alumno.
 */
package ejemplointerfazimprimible;

/**
 *
 * Clase Alumno
 */
public class Alumno extends Persona {
        protected String grupo;
        protected double notaMedia; 
    
        
        // Constructor
        // -----------
        public Alumno (String nombre, String apellidos, String domicilio, String grupo, double notaMedia) {
            super (nombre, apellidos, domicilio);
            this.grupo= grupo;
            this.notaMedia= notaMedia;            
        }
        
        // Métodos get
        // ------------
        
        // Método getGrupo
        public String getGrupo (){
            return grupo;
        }

        // Método getNotaMedia
        public double getNotaMedia (){
            return notaMedia;
        }

        // Métodos set
        // -----------

        // Método setGrupo
        public void setGrupo (String grupo){
            this.grupo= grupo;
        }
        
        // Método setNotaMedia
        public void setNotaMedia (double notaMedia){
            this.notaMedia= notaMedia;
        }
        
        // Redefinición de los métodos de la interfaz Imprimible
        // -------------------------------------------------------
        
        // Método getNumAtributos
        @Override
        public int getNumAtributos () {
            // La clase Alumno tiene dos atributos más los que tenga Persona
            int resultado= super.getNumAtributos() + 2;
            return resultado;
        }
        
        // Método getNombresAtributos
        @Override
        public String[] getNombreAtributos () {
            String[] resultado= new String [this.getNumAtributos()];
            String[] arrayNombresAtributosPersona= super.getNombreAtributos();
            // Incluimos primero los nombres de los atributos de Persona
            int i;
            for (i=0; i<arrayNombresAtributosPersona.length; i++)
                resultado[i]= arrayNombresAtributosPersona[i];
            // Incluimos a continuación los nombres de los atributos específicos de Alumno
            resultado[i]= "grupo";
            resultado[i+1]= "notaMedia";

            return resultado;
        }

        // Método getContenidoArray 
        @Override
        public String[] getContenidoArray () {
            String[] resultado= new String [this.getNumAtributos()];
            String[] arrayAtributosPersona= super.getContenidoArray();
            // Incluimos primero los atributos de Persona
            int i;
            for (i=0; i<arrayAtributosPersona.length; i++)
                resultado[i]= arrayAtributosPersona[i];
            // Incluimos a continuación los atributos específicos de Alumno
            resultado[i]= this.grupo;
            resultado[i+1]= Double.toString(this.notaMedia);

            return resultado;
        }

        // Método getContenidoString 
        // Este método sería exactamente igual que en su clase padre Persona.
        // No hsría falta "rescribirlo". Podemos "heredarlo" directamente.
        
}

