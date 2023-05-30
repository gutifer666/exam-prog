package compapersonas;

/**
 *
 * @author FPd
 */
public class CompaPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear persona con su nif
        Persona p = new Persona("50000000R") ;
        // Establecer el resto de atributos
        p.setEdad(45); 
        p.setAltura(1.46f) ; 
        p.setNombre("Filemón");
        p.setOcupacion("Agente secreto");
        
        // Crear otra persona con su nif
        Persona m = new Persona("22333444F") ;
        // Establecer el resto de atributos
        m.setEdad(43); 
        m.setAltura(1.75f) ; 
        m.setNombre("Mortadelo");
        m.setOcupacion("Agente secreto");
        
        // Comparar
        int resultado = p.compareTo(m);
        System.out.println(resultado);
        
        
    }
}
