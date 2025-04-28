import javax.swing.*;
import java.util.ArrayList;

public abstract class Carta {
    //SuperClase abstracta para solo definir el enunciado del metodo
        protected int numCarta;
        protected boolean isVisible;
        ImageIcon icon;

        public Carta(int numCarta) {
            this.numCarta = numCarta;
            this.isVisible = false;
            definirIcon(numCarta);
        }

        public abstract void voltear();  // Para mostrarla
        public abstract boolean esIgual(int nCarta);

        public abstract void definirIcon(int numCarta);
}
