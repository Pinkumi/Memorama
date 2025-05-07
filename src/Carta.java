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
        protected int width;
        protected int height;

        public Carta(int numCarta,int width, int height) {
            this.numCarta = numCarta;
            this.isVisible = false;
            this.width = width;
            this.height = height;


            Image imagenEscalada = new ImageIcon("src/images/carta.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(imagenEscalada);

            setLayout(null);
            setSize(width+20, height+50);
            setLocation(0, 0);

            iconLabel.setSize(width, height);
            iconLabel.setLocation(10, 10);
            iconLabel.setIcon(icon);

            voltearBoton.setSize(width, 20);
            voltearBoton.setLocation(10, height+20);
            voltearBoton.setFocusable(false);
            //voltearBoton.addActionListener(a -> voltear());

            add(iconLabel);
            add(voltearBoton);

            setBackground(Color.WHITE);
            setOpaque(true);
            definirIcon(numCarta);
        }
        public int getNumCarta() {
            return numCarta;
        }

        public void voltear(){// Para mostrarla
            isVisible = true;
            actualizarImagen();
            voltearBoton.setEnabled(false);

        }
        public void ocultar(){
            isVisible = false;
            actualizarImagen();
            voltearBoton.setEnabled(true);

        }
        public boolean esIgual(int nCarta){
            return numCarta == nCarta;
        }

    public void actualizarImagen() {
        if(!isVisible){
            Image imagenEscalada = new ImageIcon("src/images/carta.png").getImage().getScaledInstance(width ,height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(imagenEscalada);
        }else{
            definirIcon(numCarta);


        }
        iconLabel.setIcon(icon);
    }
        public ImageIcon obtenerIcon(){
            return this.icon;
        }
        public abstract ImageIcon obtenerPortada();
        public abstract void definirIcon(int numCarta);
        public abstract void accionEspecialEncontrado();
        public abstract void accionEspecialIncorrecta();


}
