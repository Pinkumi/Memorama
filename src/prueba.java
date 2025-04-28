import javax.swing.*;
import java.awt.*;

public static void main(String[] args) {
    JFrame ventana = new JFrame("Imagen Escalada");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(400, 400);

    // Cargar imagen
    ImageIcon iconoOriginal = new ImageIcon("src/kirbys/kirby4.png");

    // Escalar imagen
    Image imagen = iconoOriginal.getImage();
    Image imagenEscalada = imagen.getScaledInstance(207, 280, Image.SCALE_SMOOTH); // tamaño deseado

    // Crear nuevo icono
    ImageIcon iconoNuevo = new ImageIcon(imagenEscalada);

    // Poner en JLabel
    JLabel etiqueta = new JLabel(iconoNuevo);
    ventana.add(etiqueta);

    ventana.setVisible(true);
}

