package sieteymedia;

/**
 *
 * @author profesorado
 */
public class SieteYMedia {

    

    static final float[] valores = {1, 2, 3, 4, 5, 6, 7, 0.5f, 0.5f, 0.5f};
    public Mazo jugador1, jugador2, jugador3, jugador4;
    public Mazo baraja;
   

    public SieteYMedia() {

        baraja = new Mazo("Baraja");
        jugador1 = new Mazo("Jugador 1");
        jugador2 = new Mazo("Jugador 2");
        jugador3 = new Mazo("Jugador 3");
        jugador4 = new Mazo("Jugador 4");

        baraja.crearBaraja(valores);
        baraja.barajar();
    }
}
