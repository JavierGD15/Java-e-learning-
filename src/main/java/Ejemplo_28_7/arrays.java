package Ejemplo_28_7;

import java.util.ArrayList;
import java.util.Scanner;

public class arrays {
    
    

    int array []= new int [4];
    

    public static void main(String[] args) {
        
        
        
        ArrayList<alumnos> lista = new ArrayList<>();
              
                
        lista.add(new alumnos(2020,"Jorge",24,"5to Semestre"));
        lista.add(new alumnos(2021,"Juan",24,"6to Semestre"));
        lista.add(new alumnos(2022,"Noemi",24,"7to Semestre"));
        lista.add(new alumnos(2023,"Carlos",24,"8to Semestre"));
        lista.add(new alumnos(2024,"Maria",24,"9to Semestre"));
        
        //por su medida 
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).nombre+""+lista.get(i).carnet);             
        }
        
        
        
        //For each
        for (alumnos sp : lista) {
            System.out.println(sp.carnet);
        }
        
        
        
    }
}
