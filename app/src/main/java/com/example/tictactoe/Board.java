package com.example.tictactoe;

/**
 * This needs a lot of work but its a start
 */

public class Board {
        private BoardCell[][] board;
        private static int size = 3;
        private static Board instance = null;

        public static Board get()
        {
            if(instance == null)
            {
                instance = new Board(generateBoard());
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

        protected Board(BoardCell[][] grid)
        {
            size = 3;
            board = grid;
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

        public BoardCell getBoardCell(int ii, int jj)
        {
            return board[ii][jj];
        }
}