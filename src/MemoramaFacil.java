import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import java.util.TimerTask;

public class MemoramaFacil extends Memorama{
    private int paresMostrados= 0;
    public MemoramaFacil(int cartaTipo, int cantJugadores){
        super(cartaTipo, cantJugadores);
        llenarCartas(cartaTipo,140,170);
        agregarEfectoBotones();
        generarTablero();
        JLabel labelTipoCarta = new JLabel("Tipo Carta: ");
        labelTipoCarta.setSize(80,10);
        labelTipoCarta.setFont(new Font("MV Boli",Font.PLAIN,20));
        JLabel labelCartaImagen = new JLabel();
        ImageIcon cartaImagen = cartas.getFirst().obtenerPortada();
        cartaImagen.setImage(cartaImagen.getImage().getScaledInstance(120,160 , Image.SCALE_SMOOTH));
        labelCartaImagen.setIcon(cartaImagen);
        labelCartaImagen.setSize(100,140);
        panelTemporizador.setBounds(833,0,500,160);
        panelTemporizador.add(labelTipoCarta);
        panelTemporizador.add(labelCartaImagen);
    }
    @Override
    public void generarTablero() {
        int y = 190;
        int x = 15;
        int cartaPos = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                Carta carta = cartas.get(cartaPos);
                carta.setLocation(x, y);
                frameJuego.add(carta);
                x += carta.getWidth()+5;
                cartaPos++;
            }
            y += cartas.getFirst().getHeight()+50; // o usa carta.getHeight()
            x = 15;
        }
    }

    @Override
    public void iniciarTurno(){
        ArrayList<Integer> cartasVolteadasPos = encontrarCartasVolteadas();
        if(cartasVolteadasPos.size() ==2){
            if(cartas.get(cartasVolteadasPos.getFirst()).getNumCarta() == cartas.get(cartasVolteadasPos.getLast()).getNumCarta()){
                jugadores.get(jugadorEnTurno).addScore(1);
                paresMostrados++;
                cartas.remove(cartasVolteadasPos.getFirst());
                cartas.remove(cartasVolteadasPos.getLast());
            }else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                cartas.get(cartasVolteadasPos.getFirst()).ocultar();
                cartas.get(cartasVolteadasPos.getLast()).ocultar();
            }
            cartasVolteadasPos.clear();
            if (jugadorEnTurno == jugadores.size()-1) {
                jugadorEnTurno = 0;
            } else {
                jugadorEnTurno++;
            }
            actualizarInformacion();
        }
    }
    @Override
    public void verificarEmparejamiento() {
        Carta c1 = cartasVolteadas.get(0);
        Carta c2 = cartasVolteadas.get(1);
        cartasVolteadas.clear();
        if (c1.getNumCarta() == c2.getNumCarta()) {
            paresMostrados++;
            jugadores.get(jugadorEnTurno).addScore(1);
            cartas.get(cartas.indexOf(c1)).accionEspecialEncontrado();
            cartas.get(cartas.indexOf(c2)).accionEspecialEncontrado();
            cartas.remove(c1);
            cartas.remove(c2);
            actualizarInformacion();
            if (paresMostrados == 8) {
                JOptionPane.showMessageDialog(null, "¡Juego terminado!");
                String message = ("El ganador es el Jugador: "+(getGanador()));
                JOptionPane.showMessageDialog(null,message);
                isOver=true;
                frameJuego.dispose();
            }
        } else {
            Timer timer = new Timer(1000, e -> {
                cartas.get(cartas.indexOf(c1)).ocultar();
                cartas.get(cartas.indexOf(c2)).ocultar();
                cartas.get(cartas.indexOf(c1)).accionEspecialIncorrecta();
                cartas.get(cartas.indexOf(c2)).accionEspecialIncorrecta();
            });
            timer.setRepeats(false);
            timer.start();
            if (jugadorEnTurno == jugadores.size()-1) {
                jugadorEnTurno = 0;
            } else {
                jugadorEnTurno++;
            }
            actualizarInformacion();
        }
    }
}
