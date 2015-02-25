/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicializavector;

/**
 *
 * @author Manuel Manzano López
 */
public class InicializaVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] listnumber={11,22,33,44,55,66,77,88,99,100};
        
        for(int i=0; i<listnumber.length;i++){
            System.out.print((i+1));
            System.out.print("....");
            System.out.println(listnumber[i]);
        }
    }
}
