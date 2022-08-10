package proyecto_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class login extends JFrame {

    JPanel p1 = new JPanel();
    JTextField t1 = new JTextField();
    JPasswordField t2 = new JPasswordField();
    Object usuarios[][] = new Object[50][10];
    int oportunidades = 3;

    //metodos
    private void inicio() throws ClassNotFoundException {
        load();

        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(50, 175, 400, 400);
        setVisible(true);
        p1.setLayout(null);
        add(p1);

        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(50, 75, 80, 40);
        p1.add(l1);

        t1.setBounds(150, 79, 100, 30);
        p1.add(t1);

        JLabel l2 = new JLabel("Contraseña:");
        l2.setBounds(50, 175, 80, 40);
        p1.add(l2);

        t2.setBounds(150, 179, 100, 30);
        p1.add(t2);

        JButton b1 = new JButton("Ingresar");
        b1.setBounds(140, 250, 100, 50);
        p1.add(b1);

        ActionListener verificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    user();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };

        b1.addActionListener(verificar);

    }

    public void load() throws ClassNotFoundException {

        try {

            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("usuarios.dat"));

            usuarios = (Object[][]) recuperar.readObject();
            recuperar.close();

        } catch (IOException e) {
        }

    }

    private void user() throws ClassNotFoundException {
        load();
        administrador ad = new administrador();
        if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
            ad.ejecutar();
            setVisible(false);

        } else {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i][1] == t1.getText() && usuarios[i][9] == t2.getText()) {
                    ad.ejecutar();
                    setVisible(false);
                    break;

                }

            }
            oportunidades--;
            if (oportunidades == 0) {
                JOptionPane.showMessageDialog(null, "Se acabaron las oportunidades");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos, te quedan " + oportunidades + " oportunidades");
            }

        }

    }

    public void ejecutar() throws ClassNotFoundException {
        inicio();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        login l = new login();
        l.ejecutar();
    }

}
