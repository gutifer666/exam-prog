package sieteymedia;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author profesorado
 */
public class Mazo {

    private String nombre;
    private LinkedList<Carta> mazo;

    private static final char[] palos
            = {Carta.PICA, Carta.TREBOL, Carta.CORAZON, Carta.DIAMANTE};
    private static final char[] simbolos
            = {'A', '2', '3', '4', '5', '6', '7', 'J', 'Q', 'K'};
    //private static final float[] valores =
    //    {1,2,3,4,5,6,7,0.5f,0.5f,0.5f};

    Mazo(String nombre) {
        this.nombre = nombre;
        this.mazo = new LinkedList<Carta>();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void crearBaraja(float[] valores) {
        int p, s, orden;
        Carta nuevaCarta;

        orden = 0;
        for (p = 0; p < palos.length; p++) {
            for (s = 0; s < simbolos.length; s++) {
                nuevaCarta = new Carta(simbolos[s], palos[p], valores[s], orden);
                orden++;
                this.mazo.add(nuevaCarta);
            }
        }

    }

    public String mostrar() {
        String txtBaraja="";
        String aux = "";
        int contador = 0;
        if (!hayCartas()) {
            txtBaraja = new String( " Sin cartas\n");
        } else {
            //txtBaraja = new String(this.nombre + "\n");
            for (Carta c : this.mazo) {
                aux = c.mostrar();
                txtBaraja = txtBaraja.concat((String) aux);

                
                contador++;
                if (contador % 10 == 0) {
                    txtBaraja = txtBaraja.concat("\n");
                }
            }
        }
        return txtBaraja;
    }

    public void barajar() {
        Collections.shuffle(this.mazo);
    }

    public int cuantasCartas() {
        return this.mazo.size();
    }

    public boolean hayCartas() {
        return !(this.mazo.isEmpty());
    }

    public void vaciar() {
        this.mazo.clear();
    }

    public Carta extraerCarta() {
        // extrae la carta de arriba;
        return this.mazo.poll();
    }

    public void insertarCarta(Carta nueva) {
        this.mazo.add(nueva);
    }

    public void ordenar() {
        Collections.sort(this.mazo);
    }

    public void agrupar() {
        Collections.sort(this.mazo, new AgrupadorCartasSimbolo());
    }

    public float sumarPuntos() {
        Carta c;
        float suma = 0f;
        Iterator<Carta> it = this.mazo.iterator();

        while (it.hasNext()) { // Mientras que haya un siguiente elemento, seguiremos en el bucle.
            c = it.next(); // Escogemos el siguiente elemento.
            suma += c.obtenerValor();

        }
        return suma;
    }
}
