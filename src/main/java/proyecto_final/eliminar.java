package proyecto_final;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class eliminar extends JFrame {

    Object usuarios[][] = new Object[50][9];
    JPanel panel2 = new JPanel();
    JButton b1;
    JButton b2;

    public void eliminar_usuario(int id) throws ClassNotFoundException {
        load();
        setSize(900, 650);
        setLocationRelativeTo(null);
        setMaximumSize(new Dimension(1000, 1000));
        setVisible(true);
        panel2.setBackground(Color.CYAN);
        panel2.setLayout(null);
        add(panel2);

        JLabel titulo = new JLabel("Eliminar Usuario");
        titulo.setFont(new Font("Serig", Font.PLAIN, 25));
        titulo.setBounds(350, 20, 400, 50);

        JLabel label = new JLabel("Nombre: ");
        label.setBounds(30, 85, 500, 50);
        label.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text = new JTextField(15);
        text.setText(usuarios[id][1] + "");
        text.setEnabled(false);
        text.setBounds(150, 100, 250, 20);

        JLabel label1 = new JLabel("Apellido: ");
        label1.setBounds(450, 85, 500, 50);
        label1.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text1 = new JTextField(15);
        text1.setText(usuarios[id][2].toString());
        text1.setEnabled(false);
        text1.setBounds(560, 100, 250, 20);

        JLabel label2 = new JLabel("Teléfono: ");
        label2.setBounds(30, 200, 500, 50);
        label2.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text2 = new JTextField(15);
        text2.setText(usuarios[id][3].toString());
        text2.setEnabled(false);
        text2.setBounds(150, 215, 250, 20);

        JLabel label3 = new JLabel("Dirección: ");
        label3.setBounds(450, 200, 500, 50);
        label3.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text3 = new JTextField(15);
        text3.setText(usuarios[id][4].toString());
        text3.setEnabled(false);
        text3.setBounds(560, 215, 250, 20);

        JLabel label4 = new JLabel("Correo: ");
        label4.setBounds(30, 315, 500, 50);
        label4.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text4 = new JTextField(15);
        text4.setText(usuarios[id][5].toString());
        text4.setEnabled(false);
        text4.setBounds(150, 330, 250, 20);

        JLabel label5 = new JLabel("Fecha de Nacimiento: ");
        label5.setBounds(450, 315, 500, 50);
        label5.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text5 = new JTextField(15);
        text5.setText(usuarios[id][6].toString());
        text5.setEnabled(false);
        text5.setBounds(650, 330, 200, 20);

        JLabel label6 = new JLabel("Contraseña: ");
        label6.setBounds(30, 430, 500, 50);
        label6.setFont(new Font("Serig", Font.PLAIN, 20));
        JTextField text6 = new JTextField(15);
        text6.setText(usuarios[id][7].toString());
        text6.setEnabled(false);
        text6.setBounds(150, 445, 250, 20);

        panel2.add(titulo);

        panel2.add(label);
        panel2.add(text);

        panel2.add(label1);
        panel2.add(text1);

        panel2.add(label2);
        panel2.add(text2);

        panel2.add(label3);
        panel2.add(text3);

        panel2.add(label4);
        panel2.add(text4);

        panel2.add(label5);
        panel2.add(text5);

        panel2.add(label6);
        panel2.add(text6);

        b1 = new JButton();
        b2 = new JButton();

        b1.setText("Eliminar");
        b1.setBounds(150, 500, 200, 40);
        panel2.add(b1);

        b2.setText("Cancelar");
        b2.setBounds(500, 500, 200, 40);
        panel2.add(b2);

        ActionListener cancelar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                setVisible(false);
                //eliminar el frame de memoria
                dispose();

            }
        };

        //Acción del evento
        b2.addActionListener(cancelar);

        ActionListener guardar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = id; i < usuarios.length; i++) {

                    if (i == usuarios.length - 1) {
                        usuarios[i][0] = null;
                        usuarios[i][1] = null;
                        usuarios[i][2] = null;
                        usuarios[i][3] = null;
                        usuarios[i][4] = null;
                        usuarios[i][5] = null;
                        usuarios[i][6] = null;
                        usuarios[i][7] = null;
                        usuarios[i][8] = null;
                    }else if (usuarios[i][0] == null) {
                        break;
                    } 
                    else {
                        usuarios[i][0] = i + 1;
                        usuarios[i][1] = usuarios[i + 1][1];
                        usuarios[i][2] = usuarios[i + 1][2];
                        usuarios[i][3] = usuarios[i + 1][3];
                        usuarios[i][4] = usuarios[i + 1][4];
                        usuarios[i][5] = usuarios[i + 1][5];
                        usuarios[i][6] = usuarios[i + 1][6];
                        usuarios[i][7] = usuarios[i + 1][7];
                        usuarios[i][8] = usuarios[i + 1][8];
                    }
                }
                save();
                dispose();
            }
        };

        //Acción del evento
        b1.addActionListener(guardar);

    }

    public void save() {

        try {
            ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            tabla.writeObject(usuarios);
            tabla.close();
        } catch (IOException s) {
        }

    }

    public void load() throws ClassNotFoundException {

        try {

            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("usuarios.dat"));

            usuarios = (Object[][]) recuperar.readObject();
            recuperar.close();

        } catch (IOException e) {
        }

    }
}
