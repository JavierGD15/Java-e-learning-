package Ejemplo_28_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivos {

    public void leerarchivo() {

        File archivo; //Variable de tipo File
        FileReader leer; //Variable de tipo FILEREADER
        BufferedReader almacenamiento; //Funciona para leer el documento  
        archivo = new File("ejemplo.txt");

        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);

            String linea = "";
            while ((linea = almacenamiento.readLine()) != null) {

                for (int i = 0; i < linea.length(); i++) {
                    System.out.println(linea.charAt(i));
                }

            }

        } catch (Exception e) {
            System.out.println("El archivo no se encontro");
        }

    }

    public void creararchivo() {
        File archivo = new File("usuario.txt");
        FileWriter escribir;
        PrintWriter lineas;
        
        String dato = "hola mundo";
        
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo,true);
                lineas = new PrintWriter(escribir);
                lineas.println(dato);
                lineas.println("Hola, esto es una prueba");
                lineas.print("sin espacios");
                lineas.print("-prueba prueba");
                lineas.close();
                escribir.close();
            } catch (Exception e) {
            }
            
        } else {
            try {
                escribir = new FileWriter(archivo,true);
                lineas = new PrintWriter(escribir);
                lineas.println("Hola, este documento ya existe");
                lineas.print("sin espacios");
                lineas.print("-prueba prueba");
                lineas.close();
                escribir.close();
            } catch (Exception e) {
            }
        }

    }

    public static void main(String[] args) {
        Archivos a = new Archivos();
        a.creararchivo();

    }

}
