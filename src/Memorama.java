import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public abstract class Memorama {
    protected int CARTAS_SIZE=8;
    protected ArrayList<Carta> cartas;
    protected JFrame frameJuego;
    protected ArrayList<Jugador> jugadores = new ArrayList<>();
    protected ArrayList<JLabel> puntuacionesArray = new ArrayList<>();
    protected int cantJugadores;
    protected int jugadorEnTurno;
    protected JPanel panelJugadores;
    protected JPanel panelJugadorEnTurno;

    protected JLabel labelJugadorEnTurno;

    public Memorama(int cartaTipo, int cantJugadores){
        jugadorEnTurno=1;
        this.cantJugadores = cantJugadores;
        frameJuego = new JFrame("Memorama");
        frameJuego.setSize(1366,768);

        panelJugadores = new JPanel();
        panelJugadores.add(new JLabel("Puntuaciones: "));
        panelJugadores.setBounds(33,10,500, 192);

        panelJugadorEnTurno = new JPanel();
        panelJugadorEnTurno.add(new JLabel("Jugador: "));
        panelJugadorEnTurno.setBounds(33+500,10,300, 192);

        for(int i = 1; i<=cantJugadores; i++){
            Jugador jugador = new Jugador(i);
            jugadores.add(jugador);
            puntuacionesArray.add(new JLabel(jugador.toString()));
            panelJugadores.add(puntuacionesArray.get(i-1));
        }

        cartas = new ArrayList<>();
        frameJuego.add(panelJugadores);
        frameJuego.add(panelJugadorEnTurno);
        llenarCartas(cartaTipo);
    }

    protected void actualizarInformacion(){

        puntuacionesArray.clear();
        panelJugadores.removeAll();
        panelJugadores.revalidate();
        panelJugadores.repaint();

        panelJugadorEnTurno.removeAll();
        panelJugadorEnTurno.revalidate();
        panelJugadorEnTurno.repaint();
        labelJugadorEnTurno.setText(jugadorEnTurno+"");
        panelJugadorEnTurno.add(new JLabel("Jugador: "));
        panelJugadorEnTurno.add(labelJugadorEnTurno);

        panelJugadores.add(new JLabel("Puntuaciones: "));
        for(int i = 0; i<cantJugadores; i++){
            puntuacionesArray.add(new JLabel(jugadores.get(i).toString()));
            panelJugadores.add(puntuacionesArray.get(i));
        }
        frameJuego.setVisible(true);

    }
    protected void llenarCartas(int cartaTipo){
            switch (cartaTipo){
                case 1:
                    for(int i = 1; i <= CARTAS_SIZE; i++){
                        CartaKirby cartaKirby = new CartaKirby(i);
                        cartas.add(cartaKirby);cartas.add(cartaKirby);
                    }
                    break;
                case 2:
                    for(int i = 1; i <= CARTAS_SIZE; i++){
                        CartaPayaso cartaPayaso = new CartaPayaso(i);
                        cartas.add(cartaPayaso);cartas.add(cartaPayaso);
                    }
                    break;
                case 3:
                    for(int i = 1; i <= CARTAS_SIZE; i++){
                        CartaPerro cartaPerro = new CartaPerro(i);
                        cartas.add(cartaPerro);cartas.add(cartaPerro);
                    }
                    break;
            }
            Collections.shuffle(cartas);
    }
    protected abstract void generarTablero();
    protected abstract void iniciarTurno();
}

