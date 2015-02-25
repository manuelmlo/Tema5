/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadradomagico;

import java.util.Random;

/**
 *
 * @author Manuel Manzano López
 */
public class MagicSquare {
    
    private int[][] matrix;
    private int size;
    
    public MagicSquare(int tam){
        this.size=tam;
        createMatrix(tam);
    }
    public MagicSquare(){
        this.size=3;
        createMatrix(3);
    }
    private void createMatrix( int size){
        matrix = new int[size][size];
        this.size = 3;
        generalMagicSquare();
    }

    private void generalMagicSquare() {
        Random random = new Random();
        int number;
        boolean repeated;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                do {
                    number = random.nextInt(9) + 1;
                    repeated=isRepeated(number);
                    if (!repeated){
                        matrix[i][j] = number;
                    }
                } while(repeated);
            }
        }
    }
   public int [][] getMatrix(){
       return matrix;
   }
   private boolean isCorrect(){
       int sum1= matrix[0][0]+ matrix[0][1]+matrix[0][2];
       if(sum1 !=(matrix[1][0]+ matrix[1][1]+matrix[1][2])){
            return false;
       }
       if(sum1 !=(matrix[2][0]+ matrix[2][1]+matrix[2][2])){
            return false;
       }
       if(sum1 !=(matrix[0][1]+ matrix[0][1]+matrix[2][1])){
            return false;
       }
       if(sum1 !=(matrix[0][2]+ matrix[1][2]+matrix[2][])){
            return false;
       }
       
   }

    @Override
    public String toString() {
        String result="";
        for(int i=0; i<size; i++){
            for(int j=0; j<size;j++){
               result +=matrix[i][j]+" ";
            }
            result+="\n";
        }
        return result;
    }
   private boolean isRepeated(int number){
       for(int i=0;i<size;i++){
           for(int j=0;j<size;j++){
               if(matrix[i][j]==number){
                   return true;
               }
           }
       }
       return false;
   }
}
