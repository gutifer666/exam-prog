/*
 * Clase Profesor
 */
package ejemplointerfazimprimible;



/**
 *
 * Clase Profesor
 */
public class Profesor extends Persona {
	String especialidad;
	double salario; 
        
        // Constructor
        // -----------

        public Profesor (String nombre, String apellidos, String domicilio, String especialidad, double salario) {
            super (nombre, apellidos, domicilio);
            this.especialidad= especialidad;
            this.salario= salario;            
        }

        // Métodos get
        // -----------
        
        // Método getEspecialidad
        public String getEspecialidad (){
            return especialidad;
        }

        // Método getSalario
        public double getSalario (){
            return salario;
        }

        // Métodos set
        // -----------

        // Método setSalario
        public void setSalario (double salario){
            this.salario= salario;
        }
        
        // Método setESpecialidad
        public void setESpecialidad (String especialidad){
            this.especialidad= especialidad;
        }

        
        // Redefinición de los métodos de la interfaz Imprimible
        // -------------------------------------------------------
        
        // Método getNumAtributos
        @Override
        public int getNumAtributos () {
            // La clase Profesor tiene dos atributos más los que tenga Persona
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
            // Incluimos a continuación los nombres de los atributos específicos de Profesor
            resultado[i]= "especialidad";
            resultado[i+1]= "salario";

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
            resultado[i]= this.especialidad;
            resultado[i+1]= Double.toString(this.salario);

            return resultado;
        }

        // Método getContenidoString 
        // Este método sería exactamente igual que en su clase padre Persona.
        // No hsría falta "rescribirlo". Podemos "heredarlo" directamente.
        
}

