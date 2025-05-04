import javax.swing.*;
import java.awt.*;

public class CartaKirby extends Carta {
    //subclase de la clase carta

    public CartaKirby(int numCarta) {
        super(numCarta);
        setBackground(Color.PINK);
        setOpaque(true);

    }

    @Override
    public void definirIcon(int numCarta) {
        switch (numCarta) {
            case 1:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby1.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 2:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby2.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 3:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby3.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 4:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby4.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 5:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby5.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 6:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby6.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 7:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby7.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;
            case 8:
                icon = new ImageIcon((new ImageIcon("src/kirbys/kirby8.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH)));
                break;

        }

    }

    @Override
    public void accionEspecialIncorrecta() {
        ImageIcon iconoOriginal = (ImageIcon) iconLabel.getIcon();
        ImageIcon gif = new ImageIcon("src/kirbys/kirbyCaida.gif");
        iconLabel.setIcon(gif);
        Timer timer = new Timer(1300, e -> iconLabel.setIcon(iconoOriginal));
        timer.setRepeats(false);
        timer.start();
    }
    @Override
    public void accionEspecialEncontrado() {
        ImageIcon iconoOriginal = (ImageIcon) iconLabel.getIcon();
        ImageIcon gif = new ImageIcon("src/kirbys/kirbyYei.gif");
        iconLabel.setIcon(gif);
        Timer timer = new Timer(4000, e -> iconLabel.setIcon(iconoOriginal));
        timer.setRepeats(false);
        timer.start();
    }
}
