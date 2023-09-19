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

    public BoardCell getBoardCell(int ii, int jj) { return board[ii][jj]; }

    public void reset() {
        for (int ii = 0; ii < size; ii++) {
            for (int jj = 0; jj < size; jj++) {
                board[ii][jj].setPlayerID(0);
                board[ii][jj].setMarkerId(android.R.color.transparent);
            }
        }
    }
}