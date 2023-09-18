package com.example.tictactoe;


import android.media.Image;
import android.widget.ImageButton;

/**
 * This holds the information for individual cells
 * drawableID can be used to change the board from X to 0;
 */

public class BoardCell {
    private int markerId;
    private int playerId = 0; //If cell is occupied (1 for player1, 2 for player2, 0 for unoccupied)

     public BoardCell() {
         markerId = android.R.color.transparent;
         playerId = 0;
     }

     /* public void fillCell(int markerId, int newPlayerId) {
         playerId = newPlayerId;
         markerId.setImageResource(markerId);
     } */

    public int getMarkerId() {
        return markerId;
    }

     public int getPlayerID() {
         return playerId;
     }

    public void setPlayerID(int newId) {
        playerId = newId;
    }

    public void setMarkerId(int newId) {
        markerId = newId;
    }

    public boolean isEmpty() {
         boolean isEmpty = false;
         if( playerId != 0) {
             isEmpty = true;
         }
         return isEmpty;
    }
}
