/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

/**
 *
 * @author Manuel Manzano López.
 */
public class Moves {
    private static int access=0;
    private int coordX=0;
    private int coordY=0;
    private int coord1X=0;
    private int coord1Y=0;
    private int element=0;
    
    public Moves(int itemX, int itemY, int item1X, int item1Y){
        this.coordX=itemX;
        this.coordY=itemY;
        this.coord1X=item1X;
        this.coord1Y=item1Y;
        access+=1;
        element=access;
    }
    static int getAccess(){
        
        return access;
        
    }

    public int getCoordX() {
        access=element;
        return coordX;
    }

    public int getCoordY() {
        access=element;
        return coordY;
    }

    public int getCoord1X() {
        access=element;
        return coord1X;
    }

    public int getCoord1Y() {
        access=element;
        return coord1Y;
    }
    
    public int[] getCoord(){
        access=element;
        return new int[]{coordX,coordY,coord1X,coord1Y};
    }
            
    
}
