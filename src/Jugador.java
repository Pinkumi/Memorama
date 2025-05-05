import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Jugador {

    public HashMap<Character,Integer> letras;
    private int puntos;
    private int nJugador;
    // constructor
    Jugador(int nJugador) {
        this.nJugador = nJugador;
        puntos = 0;
    }
    public void addScore(int nPuntos)
    {
        puntos += nPuntos;
    }

    public Integer getScore()
    {
        return puntos;
    }
    public String toString()
    {
        return  "Jugador No."+nJugador +" - "+ puntos;
    }
    public int getNumeroJugador() {
        return nJugador;
    }


}
