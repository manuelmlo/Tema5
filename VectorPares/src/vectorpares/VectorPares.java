/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorpares;

/**
 *
 * @author Manuel Manzano López
 */
public class VectorPares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      final int TAMAÑOARRAY =10;
      
      int[] arraynumerospares = new int[TAMAÑOARRAY];
      
      for(int i=0;i<arraynumerospares.length;i++){
          arraynumerospares[i]=(i*2)+2;
          System.out.print(i+1);
          System.out.print("....");
          System.out.println(arraynumerospares[i]);
      }
       
        
    }
    
}
