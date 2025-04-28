import javax.swing.*;

public class CartaPerro extends Carta {
    //subclase de la clase carta
    public CartaPerro(int numCarta) {
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
                icon = new ImageIcon("src/perros/perro1.png");
                break;
            case 2:
                icon = new ImageIcon("src/perros/perro2.png");
                break;
            case 3:
                icon = new ImageIcon("src/perros/perro3.png");
                break;
            case 4:
                icon = new ImageIcon("src/perros/perro4.png");
                break;
            case 5:
                icon = new ImageIcon("src/perros/perro5.png");
                break;
            case 6:
                icon = new ImageIcon("src/perros/perro6.png");
                break;
            case 7:
                icon = new ImageIcon("src/perros/perro7.png");
                break;
            case 8:
                icon = new ImageIcon("src/perros/perro8.png");
                break;

        }
    }
}
