import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Carta extends JLabel{
    //SuperClase abstracta para solo definir el enunciado del metodo
        protected int numCarta;
        protected boolean isVisible;
        ImageIcon icon;
        public JButton voltearBoton = new JButton("Voltear");
        //protected JLabel fondoCarta = new JLabel();
        protected JLabel iconLabel = new JLabel();

        public Carta(int numCarta) {
            this.numCarta = numCarta;
            this.isVisible = false;


            Image imagenEscalada = new ImageIcon("src/images/carta.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH);
            icon = new ImageIcon(imagenEscalada);

            setLayout(null);
            setSize(162, 250);
            setLocation(0, 0);

            iconLabel.setSize(149, 180);
            iconLabel.setLocation(6, 10);
            iconLabel.setIcon(icon);

            voltearBoton.setSize(149, 40);
            voltearBoton.setLocation(6, 200);
            voltearBoton.setFocusable(false);
            voltearBoton.addActionListener(a -> voltear());

            add(iconLabel);
            add(voltearBoton);

            setBackground(Color.WHITE);
            setOpaque(true);
            definirIcon(numCarta);
        }

        public void voltear(){// Para mostrarla
            isVisible = !isVisible;
            actualizarImagen();

        }
        public boolean esIgual(int nCarta){
            return numCarta == nCarta;
        }

    public void actualizarImagen() {
        if(!isVisible){
            Image imagenEscalada = new ImageIcon("src/images/carta.png").getImage().getScaledInstance(149, 180, Image.SCALE_SMOOTH);
            icon = new ImageIcon(imagenEscalada);
        }else{
            definirIcon(numCarta);
        }
        iconLabel.setIcon(icon);
    }

        public abstract void definirIcon(int numCarta);
        public abstract void accionEspecialEncontrado();
        public abstract void accionEspecialIncorrecta();

}
