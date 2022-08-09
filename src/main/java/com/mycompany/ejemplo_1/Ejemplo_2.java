package com.mycompany.ejemplo_1;

import java.util.Scanner;



public class Ejemplo_2 {
    int cumpleaños;
    
    

    public static void main(String[] args) {
       
        Ejemplo_1 cuenta1 = new Ejemplo_1();        
        Ejemplo_1 cuenta2 = new Ejemplo_1();
        
        while (true) {            
            Scanner sp = new Scanner(System.in);
            System.out.println("=================================");
            System.out.println("|           Menu Principal      |");
            System.out.println("| 1. Mostrar                    |");
            System.out.println("| 2. Sumar                      |");
            System.out.println("| 3. Restar                     |");
            System.out.println("| 4. Cerrar                     |");
            System.out.println("=================================");
            int respuesta = sp.nextInt();

            switch (respuesta) {
                case 1:
                    System.out.println(cuenta1.getCuenta());
                    System.out.println(cuenta2.getCuenta());
                    break;
                case 2:
                    Scanner sp1 = new Scanner(System.in);
                    System.out.println("Que cuenta desea sumar 1 o 2?");
                    int resp_cuenta = sp1.nextInt();
                    
                    if (resp_cuenta == 1) {
                        System.out.println("Ingrese el valor");
                        cuenta1.setCuenta(sp1.nextInt());
                    }else{
                    System.out.println("Ingrese el valor");
                    cuenta2.setCuenta(sp1.nextInt());
                    
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.exit(0);
                    break;
                
                default:
                    throw new AssertionError();
            }
        }
        
        
        
        
    }
}
