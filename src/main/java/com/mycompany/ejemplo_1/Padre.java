/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo_1;


public class Padre {
    //atributos
    protected int matricula;
    String marca;
    String color;
    
    //metodos
    
    public void encender(){
        int x = 0;
        while (x<20) {            
            System.out.println("Hola Walter");
            x++;
        }
    
    }
    
    public void apagar(){
    
        System.out.println("El carro esta apagado");
    }
    
    public static void main(String[] args) {
        Padre p = new Padre();
        p.encender();
    }
}
