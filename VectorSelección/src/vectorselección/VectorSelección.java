/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorselección;
/**
 *
 * @author Manuel Manzano López
 */
public class VectorSelección {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size=0;
        int[] vectororigen={1,4,10,32,60,91,34,56,73,88,86};
        System.out.print("Elementos del array de origen.");
        for(int i=0;i<vectororigen.length;i++){
            if(vectororigen[i]>50 && (vectororigen[i]%2)==0){
               size++; 
            }
            System.out.print(vectororigen[i]+" ");
        }
        System.out.print("\n");
        System.out.println(size);
        System.out.println("Elementos del array de destino. ");
        int[] vectordestino= new int[size];
        int j=0;
        for(int i=0;i<vectororigen.length;i++){
            if(vectororigen[i]>50 && (vectororigen[i]%2)==0){
                vectordestino[j]=vectororigen[i];
                System.out.print(vectordestino[j]+" ");
                j++;
            }  
        }
    }
}
