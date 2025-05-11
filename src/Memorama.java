import javax.swing.*;
import java.awt.*;
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
    protected JPanel panelTemporizador;
    protected boolean isOver = false;
    protected ArrayList<Carta> cartasVolteadas = new ArrayList<>();
    protected JLabel labelJugadorEnTurno = new JLabel();
    public Memorama(int cartaTipo, int cantJugadores){
        //crea el frame y los paneles donde se mostrara la info del juego
        //genera el tablero y llena las cartas de su respectivo tipo
        jugadorEnTurno=0;
        this.cantJugadores = cantJugadores;
        frameJuego = new JFrame("Memorama");
        frameJuego.setSize(1366,768);
        frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameJuego.setLayout(null);
        panelJugadores = new JPanel();
        panelJugadores.setBounds(33,10,500, 150);
        panelJugadores.setBackground(Color.WHITE);
        panelTemporizador = new JPanel();
        panelTemporizador.setBackground(Color.WHITE);
        panelTemporizador.setBounds(33+500+300,10,500,150);
        panelJugadorEnTurno = new JPanel();
        frameJuego.getContentPane().setBackground( Color.WHITE );
        labelJugadorEnTurno.setText((jugadorEnTurno+1)+"");
        labelJugadorEnTurno.setForeground(Color.WHITE);
        labelJugadorEnTurno.setFont(new Font("MV Boli",Font.PLAIN,40));
        JLabel tituloJugador = new JLabel("Jugador: ");
        tituloJugador.setFont(new Font("MV Boli",Font.PLAIN,40));
        tituloJugador.setForeground(Color.WHITE);
        panelJugadorEnTurno.add(tituloJugador);
        panelJugadorEnTurno.add(labelJugadorEnTurno);
        JLabel tituloPuntuaciones = new JLabel("             Puntuaciones:             ");
        tituloPuntuaciones.setFont(new Font("MV Boli",Font.PLAIN,25));
        panelJugadores.add(tituloPuntuaciones);
        panelJugadorEnTurno.setBounds(33+500,10,300, 150);
        panelJugadorEnTurno.setBackground(Color.BLACK);
        for(int i = 1; i<=cantJugadores; i++){
            Jugador jugador = new Jugador(i);
            jugadores.add(jugador);
            JLabel nombreJugador = new JLabel(jugadores.get(i-1).toString()+" ");
            nombreJugador.setFont(new Font("MV Boli",Font.PLAIN,15));
            puntuacionesArray.add(nombreJugador);
            panelJugadores.add(puntuacionesArray.get(i-1));
        }
        cartas = new ArrayList<>();
        frameJuego.add(panelJugadores);
        frameJuego.add(panelJugadorEnTurno);
        frameJuego.add(panelTemporizador);
        frameJuego.setVisible(true);
    }

    protected void actualizarInformacion(){ // actualiza la informacion del juego
        puntuacionesArray.clear();
        panelJugadores.removeAll();
        panelJugadores.revalidate();
        panelJugadores.repaint();

        panelJugadorEnTurno.removeAll();
        panelJugadorEnTurno.revalidate();
        panelJugadorEnTurno.repaint();

        labelJugadorEnTurno.setText((jugadorEnTurno+1)+"");
        labelJugadorEnTurno.setFont(new Font("MV Boli",Font.PLAIN,40));
        JLabel tituloJugador = new JLabel("Jugador: ");
        tituloJugador.setFont(new Font("MV Boli",Font.PLAIN,40));
        tituloJugador.setForeground(Color.WHITE);
        panelJugadorEnTurno.add(tituloJugador);
        panelJugadorEnTurno.add(labelJugadorEnTurno);
        JLabel tituloPuntuaciones = new JLabel("             Puntuaciones:             ");
        tituloPuntuaciones.setFont(new Font("MV Boli",Font.PLAIN,25));
        panelJugadores.add(tituloPuntuaciones);
        for(int i = 0; i<cantJugadores; i++){
            JLabel nombreJugador = new JLabel(jugadores.get(i).toString()+" ");
            nombreJugador.setFont(new Font("MV Boli",Font.PLAIN,15));
            puntuacionesArray.add(nombreJugador);
            panelJugadores.add(puntuacionesArray.get(i));
        }
        frameJuego.setVisible(true);
    }
    protected void llenarCartas(int cartaTipo, int width, int height) {
        //llena las cartas de su respectivo tipo y tamaño
            switch (cartaTipo){
                case 1:
                    for(int i = 1; i <= CARTAS_SIZE; i++){
                        cartas.add(new CartaKirby(i,width,height));
                        cartas.add(new CartaKirby(i,width,height));
                    }
                    frameJuego.setBackground(Color.PINK);
                    break;
                case 2:
                    for(int i = 1; i <= CARTAS_SIZE; i++){
                        cartas.add(new CartaPayaso(i,width,height));
                        cartas.add(new CartaPayaso(i,width,height));
                    }
                    frameJuego.setBackground(Color.CYAN);

                    break;
                case 3:
                    for(int i = 1; i <= CARTAS_SIZE; i++){
                        cartas.add(new CartaPerro(i,width,height));
                        cartas.add(new CartaPerro(i,width,height));
                    }

                    frameJuego.setBackground(Color.LIGHT_GRAY);

                    break;
            }
            Collections.shuffle(cartas);
    }
    public void agregarEfectoBotones(){
         // agrega los efectos a todos los botones
        for(Carta carta: cartas){
            carta.voltearBoton.addActionListener(a->{
                carta.voltear();
                registrarCartaVolteada(carta);
            });
        }
    }
    public void registrarCartaVolteada(Carta carta) {
        //registra la carta que fue volteada, si hay 2 entonces se revisa si son o no iguales
        cartasVolteadas.add(carta);
        if (cartasVolteadas.size() == 2) {
            verificarEmparejamiento();
        }
    }
    protected int getGanador(){
        //obtiene el ganador del turno
        int scoreGanador = jugadores.get(0).getScore();
        int ganador = 1;
        for(int i = 1; i<jugadores.size(); i++){
            if(scoreGanador < jugadores.get(i).getScore()){
                scoreGanador = jugadores.get(i).getScore();
                ganador = i+1;
            }
        }
        return ganador;
    }
    protected abstract void generarTablero();//genera el tablero
    protected abstract void verificarEmparejamiento();
    //verifica que si sean 2 o 3 iguales dependiendo la dificultad

}

