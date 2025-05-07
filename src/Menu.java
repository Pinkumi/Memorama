import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private static Memorama m;
    public static void main(String[] args) {


        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground( Color.WHITE );

        frame.setLocationRelativeTo(null);
        JLabel labelT = new JLabel();
        ImageIcon titulo = new ImageIcon("src/images/titulo.png");
        labelT.setIcon(titulo);
        labelT.setBounds((700-500)/2, 0, 500, 200);

        JComboBox<String> opcionCarta = new JComboBox<String>();
        opcionCarta.addItem("Cartas Kirby ⭐");
        opcionCarta.addItem("Cartas Payaso 🃏");
        opcionCarta.addItem("Cartas Perros 🐶");
        opcionCarta.setBounds(100, 350, 120, 30);
        opcionCarta.setBackground(Color.lightGray);
        opcionCarta.setForeground(Color.BLACK);

        JComboBox<String> opcionCantJugadores = new JComboBox<String>();
        opcionCantJugadores.addItem("2 👨");
        opcionCantJugadores.addItem("3 👨");
        opcionCantJugadores.addItem("4 👨");
        opcionCantJugadores.setBounds(320, 350, 50, 30);
        opcionCantJugadores.setBackground(Color.lightGray);
        opcionCantJugadores.setForeground(Color.BLACK);

        JComboBox<String> opcionDificultad = new JComboBox<String>();
        opcionDificultad.addItem("Normal 👌");
        opcionDificultad.addItem("Dificil 👾");
        opcionDificultad.setBounds(470, 350, 120, 30);
        opcionDificultad.setBackground(Color.lightGray);
        opcionDificultad.setForeground(Color.BLACK);


        ImageIcon play = new ImageIcon("src/images/play.png");
        JButton botonPlay = new JButton();
        botonPlay.setIcon(play);
        botonPlay.setBounds((700-94)/2, 190, 94, 90);
        botonPlay.setBorderPainted(false);
        botonPlay.addActionListener(a -> {
            int cartaTipo = opcionCarta.getSelectedIndex()+1;
            int cantJugadores = opcionCantJugadores.getSelectedIndex()+2;
            String dificultad = (String) opcionDificultad.getSelectedItem();
            if (dificultad.equals("Normal 👌")) {
               m = new MemoramaFacil(cartaTipo, cantJugadores);
            } else {
               m = new MemoramaEspecial(cartaTipo, cantJugadores);
            }
            //frame.setState(JFrame.ICONIFIED);
        });
        frame.add(botonPlay);
        frame.add(opcionDificultad);
        frame.add(opcionCantJugadores);
        frame.add(opcionCarta);
        frame.add(labelT);
        frame.setVisible(true);


    }
}
