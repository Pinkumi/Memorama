import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class CartaPayaso extends Carta {
    //subclase de la clase carta
    public CartaPayaso(int numCarta) {
        super(numCarta);

    }

    @Override
    public void definirIcon(int numCarta) {
        switch (numCarta) {
            case 1:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso1.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 2:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso2.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 3:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso3.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 4:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso4.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 5:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso5.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 6:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso6.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 7:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso7.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 8:
                icon = new ImageIcon((new ImageIcon("src/payasos/payaso8.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;

        }

    }
    @Override
    public void accionEspecialIncorrecta() {
        try {
            File sonido = new File("src/payasos/triste.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sonido);
            Clip clp = AudioSystem.getClip();
            clp.open(audioStream);
            clp.start();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void accionEspecialEncontrado() {
        Color[] colores = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.PINK};
        int duracionParpadeo = 1500; // milisegundos
        int intervalo = 150; // milisegundos entre cambios de color
        int[] contador = {0}; // para contar los parpadeos

        Timer timer = new Timer(intervalo, null);
        timer.addActionListener(e -> { setBackground(colores[contador[0] % colores.length]); contador[0]++; if (contador[0] * intervalo >= duracionParpadeo) { timer.stop(); setBackground(Color.WHITE); } });
        setOpaque(true); // asegurarse de que el fondo sea visible
        timer.start();
    }
}
