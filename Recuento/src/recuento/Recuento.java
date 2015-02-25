/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuento;

import java.util.Scanner;

/**
 *
 * @author Manuel Manzano López
 */
public class Recuento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String caracter="";
        byte num=0;
        char[] arraycaracter = {'a','a','g','r','e','t','d','c','a','c'};
        System.out.println("Introduce un caracter a contabilizar:");
        Scanner entradaEscaner = new Scanner (System.in);
        caracter =entradaEscaner.nextLine ();
        for(int i=0; i<arraycaracter.length;i++){
            
            if(arraycaracter[i]==caracter.charAt(0)){
               num++;
            }
        }
       System.out.print(caracter);
       System.out.print(" se repite,");
       System.out.print(num);
       System.out.println(" veces.");
        
    }
    
}
