package interfaz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class guardado {
    
    Object filas [][] = new Object[100][3];

    public void save() {

        try {
            ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("tabla_sucursales.dat"));
            tabla.writeObject(filas);
            tabla.close();
        } catch (IOException s) {
        }

    }

    public void load() throws ClassNotFoundException {

        try {

            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_sucursales.dat"));

            filas = (Object[][]) recuperar.readObject();
            recuperar.close();

        } catch (IOException e) {
        }

    }

}
