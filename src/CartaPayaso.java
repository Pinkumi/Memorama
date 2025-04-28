import javax.swing.*;

public class CartaPayaso extends Carta {
    //subclase de la clase carta
    public CartaPayaso(int numCarta) {
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
                icon = new ImageIcon("src/payasos/payaso1.png");
                break;
            case 2:
                icon = new ImageIcon("src/payasos/payaso2.png");
                break;
            case 3:
                icon = new ImageIcon("src/payasos/payaso3.png");
                break;
            case 4:
                icon = new ImageIcon("src/payasos/payaso4.png");
                break;
            case 5:
                icon = new ImageIcon("src/payasos/payaso5.png");
                break;
            case 6:
                icon = new ImageIcon("src/payasos/payaso6.png");
                break;
            case 7:
                icon = new ImageIcon("src/payasos/payaso7.png");
                break;
            case 8:
                icon = new ImageIcon("src/payasos/payaso8.png");
                break;

        }
    }
}
