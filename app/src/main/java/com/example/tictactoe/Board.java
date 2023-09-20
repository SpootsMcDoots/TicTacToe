package com.example.tictactoe;

import android.util.Log;

/**
 * This needs a lot of work but its a start
 */

public class Board {
    private BoardCell[][] board;
    private static int size;
    private static Board instance = null;

    private static int winCon;

    public static Board get(int newSize, int newWinCon)
    {
        if(instance == null)
        {
            instance = new Board(newSize, newWinCon);
        }
        return instance;
    }

    private static BoardCell[][] generateBoard()
    {
        BoardCell[][] board = new BoardCell[size][size];

        for(int ii = 0; ii < size; ii++)
        {
            for(int jj = 0; jj < size; jj++)
            {
                board[ii][jj] = new BoardCell();
            }
        }
        return board;
    }

    protected Board(int newSize, int newWinCon)
    {
        size = newSize;
        winCon = newWinCon;
        board = generateBoard();
    }

    public void setSize(int newSize) {
        size = newSize;
        board = generateBoard();
    }

    public int getSize() {
        return size;
    }

    public int getTotalSize() {
    return size*size;
}

    public boolean setBoardCell(int ii, int jj, int player) {
        boolean result = false;
        board[ii][jj].setPlayerID(player);
        if(checkWinner(player)){
            result = true;
        }
        return result;
    }

    public BoardCell getBoardCell(int ii, int jj) { return board[ii][jj]; }

    public int[][] getBoard() {
        int[][] flatBoard = new int[size][size];
        for (int xx = 0; xx < size; xx++) {
            for (int yy = 0; yy < size; yy++) {
                flatBoard[yy][xx] = getBoardCell(yy,xx).getPlayerID();
            }
        }
        return flatBoard;
    }
    public Boolean horizontalCheck(int xx, int yy, int count, int player) {
        boolean result = false;
        try {
            if (count == winCon) {
                result = true;
            } else {
                if (board[yy][xx].getPlayerID() == player) {
                    result = horizontalCheck(xx+1, yy, count+1, player);
                } else {
                    result = false;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            Log.d("TAG", e.toString());
        }
        return result;
    }
    public Boolean verticalCheck(int xx, int yy, int count, int player) {
        boolean result = false;
        try {
            if (count == winCon) {
                result = true;
            } else {
                if (board[yy][xx].getPlayerID() == player) {
                    result = verticalCheck(xx, yy+1, count+1, player);
                } else {
                    result = false;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            Log.d("TAG", e.toString());
        }
        return result;
    }
    public Boolean diagonalCheck1(int xx, int yy, int count, int player) {
        boolean result = false;
        try {
            if (count == winCon) {
                result = true;
            } else {
                if (board[yy][xx].getPlayerID() == player) {
                    result = diagonalCheck1(xx+1, yy+1, count+1, player);
                } else {
                    result = false;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            Log.d("TAG", e.toString());
        }
        return result;
    }
    public Boolean diagonalCheck2(int xx, int yy, int count, int player) {
        boolean result = false;
        try {
            if (count == winCon) {
                result = true;
            } else {
                if (board[yy][xx].getPlayerID() == player) {
                    Log.d("TAG", Integer.toString(yy)+Integer.toString(xx));
                    result = diagonalCheck2(xx+1, yy-1, count+1, player);
                } else {
                    result = false;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            Log.d("TAG", e.toString());
        }
        return result;
    }
    public Boolean checkWinner(int player) {
       boolean result = false;
        for (int xx = 0; xx < size; xx++) {
            for (int yy = 0; yy < size; yy++) {
                if (horizontalCheck(yy,xx,0,player) || verticalCheck(yy,xx,0,player) || diagonalCheck1(yy,xx,0,player) || diagonalCheck2(yy,xx,0,player)) {
                    result = true;
                    return result;
                }
                else {
                    result = false;
                }
            }
        }

        return result;
    }


    public void reset() {
        for (int ii = 0; ii < size; ii++) {
            for (int jj = 0; jj < size; jj++) {
                board[ii][jj].setPlayerID(0);
                board[ii][jj].setMarkerId(android.R.color.transparent);
            }
        }
    }
}