package com.example.tictactoe;


/**
 * This holds the information for individual cells
 * drawableID can be used to change the board from X to 0;
 */

public class BoardCell {

    private int drawableId;
    private boolean occupied;
    //private int playerID?

     public BoardCell() {
         drawableId = 0;
         occupied = false;
     }

     public int getDrawableId() {
         return drawableId;
     }

     public void setDrawableId(int newDrawableId) {
         drawableId = newDrawableId;
     }

     public boolean isOccupied() {
         return occupied;
     }

    public void setOccupied(boolean newbool) {
        occupied = newbool;
    }
}
