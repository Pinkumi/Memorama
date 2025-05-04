import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class CartaPerro extends Carta {
    //subclase de la clase carta
    public CartaPerro(int numCarta) {
        super(numCarta);

    }
    @Override
    public void definirIcon(int numCarta) {
        switch (numCarta) {
            case 1:
                icon = new ImageIcon((new ImageIcon("src/perros/perro1.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 2:
                icon = new ImageIcon((new ImageIcon("src/perros/perro2.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 3:
                icon = new ImageIcon((new ImageIcon("src/perros/perro3.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 4:
                icon = new ImageIcon((new ImageIcon("src/perros/perro4.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 5:
                icon = new ImageIcon((new ImageIcon("src/perros/perro5.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 6:
                icon = new ImageIcon((new ImageIcon("src/perros/perro6.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 7:
                icon = new ImageIcon((new ImageIcon("src/perros/perro7.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 8:
                icon = new ImageIcon((new ImageIcon("src/perros/perro8.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;

        }

    }
    @Override
    public void accionEspecialIncorrecta() {
        try {
            File sonido = new File("src/perros/triste.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sonido);
            Clip clp = AudioSystem.getClip();
            clp.open(audioStream);
            clp.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void accionEspecialEncontrado() {
        try {
            File sonido = new File("src/perros/ladrar.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sonido);
            Clip clp = AudioSystem.getClip();
            clp.open(audioStream);
            clp.start();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
