package com.example.tictactoe;

/**
 * This needs a lot of work but its a start
 */

public class Board {
    private BoardCell[][] board;
    private static int size;
    private static Board instance = null;

    public static Board get(int newSize)
    {
        if(instance == null)
        {
            instance = new Board(newSize);
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

    protected Board(int newSize)
    {
        size = newSize;
        board = generateBoard();
    }

    public void regenerate()
   {
       board = generateBoard();
   }

    public void setSize(int newSize) {
        size = newSize;
    }

    public int getSize() {
        return size;
    }

    public int getTotalSize() {
    return size*size;
}

    public void setBoardCell(int ii, int jj, int player) {
        board[ii][jj].setPlayerID(player);
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

    public void reset() {
        for (int ii = 0; ii < size; ii++) {
            for (int jj = 0; jj < size; jj++) {
                board[ii][jj].setPlayerID(0);
                board[ii][jj].setMarkerId(android.R.color.transparent);
            }
        }
    }
}