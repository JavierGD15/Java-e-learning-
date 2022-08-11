package proyecto_final;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class administrador extends JFrame {

    JTable tabla = new JTable();
    JScrollPane sp = new JScrollPane();
    JLabel usuario_inicio = new JLabel();
    JPanel p1 = new JPanel();
    Object usuarios[][] = new Object[50][10];

    private void crear() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        setMaximumSize(new Dimension(1000, 1000));
        setVisible(true);
        p1.setBackground(Color.CYAN);
        p1.setLayout(null);
        add(p1);

        JButton crear = new JButton("Agregar Usuario");
        crear.setBounds(70, 550, 200, 30);
        p1.add(crear);
        //agregar funcionalidad
        ActionListener accion_crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                form_usuario s = new form_usuario();
                s.agregar_usuario();
                sp.setVisible(false);
                try {
                    tabla();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(administrador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };

        //Acción del evento
        crear.addActionListener(accion_crear);

        JButton modificar = new JButton("Modificar Usuario");
        modificar.setBounds(300, 550, 200, 30);
        p1.add(modificar);
        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(520, 550, 200, 30);
        p1.add(eliminar);
        JButton salir = new JButton("Salir");
        salir.setBounds(0, 0, 100, 30);
        p1.add(salir);

    }

    public void tabla() throws ClassNotFoundException {

        load();
        String[] columnas = {"No.", "Nombre", "Apellido", "Rol", "Correo", "Teléfono"};
        tabla = new JTable(usuarios, columnas);
        sp = new JScrollPane(tabla);
        sp.setSize(820, 450);
        sp.setLocation(20, 40);
        sp.setVisible(true);
        p1.add(sp);

    }
    
    public void load() throws ClassNotFoundException {

        try {

            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("usuarios.dat"));

            usuarios = (Object[][]) recuperar.readObject();
            recuperar.close();

        } catch (IOException e) {
        }

    }

    public void ejecutar() throws ClassNotFoundException {

        crear();
        tabla();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        administrador a = new administrador();
        a.ejecutar();
    }

}
