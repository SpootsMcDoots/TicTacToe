package com.example.tictactoe;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;

public class GameData extends ViewModel{
    public MutableLiveData<Profile> player1;
    public MutableLiveData<Profile> player2;
    public MutableLiveData<Profile> turnPlayer;

    public static MutableLiveData<Integer> boardSize;
    public static MutableLiveData<Integer> winCon;
    public static MutableLiveData<Board> board;

    public GameData() {
        player1 = new MediatorLiveData<Profile>();
        player2 = new MediatorLiveData<Profile>();
        turnPlayer = new MediatorLiveData<Profile>();
        ArrayList<Profile> newList = new ArrayList<Profile>();

        boardSize = new MediatorLiveData<Integer>();
        boardSize.setValue(3);

        winCon = new MediatorLiveData<Integer>();
        winCon.setValue(3);

        board = new MediatorLiveData<Board>();
        board.setValue(new Board(boardSize.getValue(), winCon.getValue()));
    }

    public void setPlayer1(Profile p1) { player1.setValue(p1); }

    public void setPlayer2(Profile p2) { player2.setValue(p2); }

    public Profile getPlayer1() { return player1.getValue(); }

    public Profile getPlayer2() { return player2.getValue(); }

    //public Profile getPlayer(String username) {}

    public Profile getTurnPlayer() {return turnPlayer.getValue(); }

    public void endTurn() {
        if (turnPlayer.getValue() == player1.getValue()) {
            turnPlayer.setValue(player2.getValue());
        }
        else turnPlayer.setValue(player1.getValue());
    }

    public void newGame() {
        turnPlayer.setValue(player1.getValue());
    }

    public static void setBoardSize(int value) {
        boardSize.setValue(value);
        board.getValue().setSize(value);
    }
    public static void setWinCon(int value) { winCon.setValue(value); }

    public Board getBoard() {
        return board.getValue();
    }

    public int getBoardSize() { return boardSize.getValue(); }
    public int getWinCon() { return winCon.getValue(); }
}