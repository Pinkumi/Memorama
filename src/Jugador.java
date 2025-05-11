import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Jugador {
    private int puntos;
    private int nJugador;
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
}
