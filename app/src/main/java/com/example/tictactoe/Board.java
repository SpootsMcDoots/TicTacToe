package com.example.tictactoe;

/**
 * This needs a lot of work but its a start
 */

public class Board {
        //private static final int WATER = R.drawable.ic_water;
        //private static final Random rng = new Random();

        //TODO: change to boardCell array
        private int[][] board;
        private static int size;

        private static Board instance = null;

        public static Board get()
        {
            if(instance == null)
            {
                instance = new Board(generateBoard());
            }
            return instance;
        }

        private static int[][] generateBoard()
        {
            int[][] board = new int[size][size];

            for(int ii = 0; ii < size; ii++)
            {
                for(int jj = 0; jj < size; jj++)
                {
                    board[ii][jj] = 0;
                }
            }

            return board;
        }

        protected Board(int[][] grid)
        {
            size = 3;
            board = grid;
        }

    /**
     *      public void regenerate()
     *      {
     *          this.board = generateBoard();
     *      }
     */
        public void setSize(int newSize) {
            size = newSize;
        }

        public int getSize() {
            return size;
        }

        public int getBoard(int ii, int jj)
        {
            return board[ii][jj];
        }
}
