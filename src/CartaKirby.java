import javax.swing.*;

public class CartaKirby extends Carta {
    //subclase de la clase carta

    public CartaKirby(int numCarta) {
        super(numCarta);

    }
    @Override
    public void voltear() {
        isVisible = !isVisible;
    }
    @Override
    public boolean esIgual(int nCarta) {
        return nCarta == numCarta;
    }
    @Override
    public void definirIcon(int numCarta) {
        switch (numCarta) {
            case 1:
                icon = new ImageIcon("src/kirbys/kirby1.png");
                break;
            case 2:
                icon = new ImageIcon("src/kirbys/kirby2.png");
                break;
            case 3:
                icon = new ImageIcon("src/kirbys/kirby3.png");
                break;
            case 4:
                icon = new ImageIcon("src/kirbys/kirby4.png");
                break;
            case 5:
                icon = new ImageIcon("src/kirbys/kirby5.png");
                break;
            case 6:
                icon = new ImageIcon("src/kirbys/kirby6.png");
                break;
            case 7:
                icon = new ImageIcon("src/kirbys/kirby7.png");
                break;
            case 8:
                icon = new ImageIcon("src/kirbys/kirby8.png");
                break;

        }
    }
}
