package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formulario extends JFrame {

    public void crear() {
        setTitle("Ejemplo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 400);
        setVisible(true);
        
        

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.ORANGE);
        add(p1);

        JLabel l1 = new JLabel("Ingresa tu nombre");
        //coordenada x, coordenada y, largo y ancho
        l1.setBounds(30, 20, 150, 40);
        p1.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(190, 20, 150, 25);
        p1.add(t1);

        JButton b1 = new JButton("Imprimir");
        b1.setBounds(350, 20, 120, 50);
        p1.add(b1);

        ActionListener imprimir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(t1.getText());
            }
        };

        b1.addActionListener(imprimir);

    }

    public static void main(String[] args) {

        formulario f = new formulario();
        f.crear();
    }
}
