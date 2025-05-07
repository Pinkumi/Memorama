import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Random;

public class MemoramaEspecial extends Memorama{
    private JPanel panelCarta;
    private Carta cartaEspecial;
    private int triplesMostrados;

    private Timer temporizadorTurno;
    private int segundosRestantes = 8;
    private JLabel labelTiempoRestante;

    public MemoramaEspecial(int cartaTipo, int cantJugadores){
        super(cartaTipo, cantJugadores);
        triplesMostrados = 0;
        JLabel tituloTemporizador = new JLabel("      Temporizador:       ");
        tituloTemporizador.setFont(new Font("MV Boli",Font.PLAIN,30));
        panelTemporizador.add(tituloTemporizador);
        panelJugadorEnTurno.setLocation(533,0);
        panelJugadores.setLocation(33,0);
        panelTemporizador.setLocation(833,0);
        panelJugadorEnTurno.setSize(300, 130);
        panelJugadores.setSize(500,130);
        panelTemporizador.setSize(350,130);
        panelCarta = new JPanel();
        //panelCarta.setLayout(null);
        panelCarta.setBackground(Color.pink);
        panelCarta.setLocation(1183, 0);
        panelCarta.setSize(145, 130);


        llenarCartas(cartaTipo);
        generarTablero();
        agregarEfectoBotones();
        cartaEspecial = encontrarCartaEspecial();

        Image image = cartaEspecial.obtenerIcon().getImage().getScaledInstance(90,111, Image.SCALE_SMOOTH);
      //  iconCartaEspecial.setImage(image);
        JLabel labelCartaEspecial = new JLabel(new ImageIcon(image));
        //labelCartaEspecial.setIcon(iconCartaEspecial);

        labelCartaEspecial.setSize(80,111);
        labelCartaEspecial.setLocation(1900,0);

        panelCarta.add(labelCartaEspecial);
        frameJuego.add(panelCarta);

        JLabel labelCarta = new JLabel(cartaEspecial.obtenerIcon());
        JLabel mensaje = new JLabel("Carta Especial:");
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(mensaje, BorderLayout.NORTH);
        panel.add(labelCarta, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Carta especial", JOptionPane.INFORMATION_MESSAGE);

        labelTiempoRestante = new JLabel("8");
        labelTiempoRestante.setFont(new Font("MV Boli", Font.BOLD, 30));
        labelTiempoRestante.setHorizontalAlignment(JLabel.CENTER);
        panelTemporizador.add(labelTiempoRestante);

        iniciarTemporizador();

    }
    public void iniciarTemporizador() {
        if (temporizadorTurno != null && temporizadorTurno.isRunning()) {
            temporizadorTurno.stop();
        }
        segundosRestantes = 8;
        labelTiempoRestante.setText(String.valueOf(segundosRestantes));
        temporizadorTurno = new Timer(1000, e -> {
            segundosRestantes--;
            labelTiempoRestante.setText(String.valueOf(segundosRestantes));
            if (segundosRestantes == 0) {
                temporizadorTurno.stop();
                cartas.forEach(carta -> {
                    if(carta.isVisible) {
                        carta.ocultar();
                    }} );
                jugadores.get(jugadorEnTurno).addScore(-1);
                if (jugadorEnTurno == jugadores.size() - 1) {
                    jugadorEnTurno = 0;
                } else {
                    jugadorEnTurno++;
                }
                System.out.println("Tiempo finado, el jugador pierde 1 punto");
                cartasVolteadas.clear();

                actualizarInformacion();
                iniciarTemporizador();
            }
        });
        temporizadorTurno.start();
    }
    public Carta encontrarCartaEspecial(){
        Carta cartaEspecial;
        Random rnd = new Random(System.currentTimeMillis());
        int numRand = rnd.nextInt(cartas.size()-1);
        cartaEspecial = cartas.get(numRand);

        return cartaEspecial;
    }
    public void llenarCartas(int cartaTipo){
        switch (cartaTipo){
            case 1:
                for(int i = 1; i <= CARTAS_SIZE; i++){
                    cartas.add(new CartaKirby(i,119,150));
                    cartas.add(new CartaKirby(i,119,150));
                    cartas.add(new CartaKirby(i,119,150));
                }
                break;
            case 2:
                for(int i = 1; i <= CARTAS_SIZE; i++){
                    cartas.add(new CartaPayaso(i,119,150));
                    cartas.add(new CartaPayaso(i,119,150));
                    cartas.add(new CartaPayaso(i,119,150));
                }

                break;
            case 3:
                for(int i = 1; i <= CARTAS_SIZE; i++){
                    cartas.add(new CartaPerro(i,119,150));
                    cartas.add(new CartaPerro(i,119,150));
                    cartas.add(new CartaPerro(i,119,150));
                }
                break;
        }
        Collections.shuffle(cartas);
    }

    @Override
    public void generarTablero(){
        int y = 130;
        int x = 33;
        int cartaPos = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                Carta carta = cartas.get(cartaPos);
                carta.setLocation(x, y);
                frameJuego.add(carta);
                x += carta.getWidth()+25;
                cartaPos++;
            }
            y += cartas.getFirst().getHeight()+3; // o usa carta.getHeight()
            x = 33;
        }
    }
    public void registrarCartaVolteada(Carta carta) {
        System.out.println("la carta se ha registrado");
        cartasVolteadas.add(carta);
        if (cartasVolteadas.size() == 3) {
            verificarEmparejamiento();
        }
    }

    @Override
    public void iniciarTurno(){
        System.out.println("Iniciando Turno");
    }
    @Override
    public void verificarEmparejamiento(){
        Carta c1 = cartasVolteadas.get(0);
        Carta c2 = cartasVolteadas.get(1);
        Carta c3 = cartasVolteadas.get(2);
        cartasVolteadas.clear();
        if (c1.getNumCarta() == c2.getNumCarta() && c1.getNumCarta() == c3.getNumCarta()) {
            triplesMostrados++;
            if(c1.getNumCarta() == cartaEspecial.getNumCarta()){

                jugadores.get(jugadorEnTurno).addScore(4);
            }
            jugadores.get(jugadorEnTurno).addScore(2);
            cartas.get(cartas.indexOf(c1)).accionEspecialEncontrado();
            cartas.get(cartas.indexOf(c2)).accionEspecialEncontrado();
            cartas.get(cartas.indexOf(c3)).accionEspecialEncontrado();
            cartas.remove(c1);
            cartas.remove(c2);
            cartas.remove(c3);
            temporizadorTurno.stop();
            iniciarTemporizador();
            actualizarInformacion();

            if (triplesMostrados == 8) {
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
                cartas.get(cartas.indexOf(c3)).ocultar();

                cartas.get(cartas.indexOf(c1)).accionEspecialIncorrecta();
                cartas.get(cartas.indexOf(c2)).accionEspecialIncorrecta();
                cartas.get(cartas.indexOf(c3)).accionEspecialIncorrecta();
            });
            timer.setRepeats(false);
            timer.start();
            temporizadorTurno.stop();
            iniciarTemporizador();
            if (jugadorEnTurno == jugadores.size()-1) {
                jugadorEnTurno = 0;
            } else {
                jugadorEnTurno++;
            }
            actualizarInformacion();
        }
    }
}
