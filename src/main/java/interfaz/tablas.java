
package interfaz;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class tablas extends JFrame{
    JTable tabla = new JTable();
    JScrollPane sp = new JScrollPane();
    JPanel p1 = new JPanel();
    
    private void crear(){
        
        setTitle("Mostrar tablas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 400);
        setVisible(true);
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);
        add(p1);
    
    }
    
    private void tabla(){
    String columnas [] ={"Nombre", "Apellido", "Teléfono"};
    Object filas [][] ={{"Erick","Baeza",7777},{"Blanca","Recinos",12345678},
        {"Juan","Rowe",12345},{"Jorge","Garcia",7777},{"Noemi","Girón",1234}};
    
    tabla = new JTable(filas,columnas);
    sp = new JScrollPane(tabla);
    sp.setBounds(10, 20, 500, 300);
    p1.add(sp);
    sp.setVisible(true);
    
    }
    
    
    public void ejecutar(){
    crear();
    tabla();
    
    }
    public static void main(String[] args) {
        tablas t = new tablas();
        t.ejecutar();
    }
}
