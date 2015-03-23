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
public class Move {

    private int coordX = 0;
    private int coordY = 0;
    private int coord1X = 0;
    private int coord1Y = 0;

    public Move(int itemX, int itemY, int item1X, int item1Y) {
        this.coordX = itemX;
        this.coordY = itemY;
        this.coord1X = item1X;
        this.coord1Y = item1Y;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public int getCoord1X() {
        return coord1X;
    }

    public int getCoord1Y() {
        return coord1Y;
    }

    public int[] getCoord() {
        return new int[]{coordX, coordY, coord1X, coord1Y};
    }
    @Override
    public String toString(){
        int[] tmp= this.getCoord();
        return "Inicial:"+tmp[0]+", "+tmp[1]+ "/ Final:"+tmp[2]+", "+tmp[3];
    }
}
