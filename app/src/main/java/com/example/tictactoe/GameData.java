package com.example.tictactoe;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;

public class GameData extends ViewModel{
    public MutableLiveData<Profile> player1;
    public MutableLiveData<Profile> player2;
    public MutableLiveData<ArrayList> players;

    public static MutableLiveData<Integer> boardSize;

    public static MutableLiveData<Integer> winCon;

    public GameData() {
        player1 = new MediatorLiveData<Profile>();
        player2 = new MediatorLiveData<Profile>();
        players = new MediatorLiveData<ArrayList>();
        ArrayList<Profile> newList = new ArrayList<Profile>();
        players.setValue(newList);
        boardSize = new MediatorLiveData<Integer>();
        boardSize.setValue(3);
        winCon = new MediatorLiveData<Integer>();
        winCon.setValue(3);
    }

    public void setPlayer1(Profile p1) { player1.setValue(p1); }

    public void setPlayer2(Profile p2) { player2.setValue(p2); }

    public Profile getPlayer1() { return player1.getValue(); }

    public Profile getPlayer2() { return player2.getValue(); }

    //public Profile getPlayer(String username) {}
    public boolean playersIsEmpty() {
        return players.getValue().isEmpty();
    }

    public static void setBoardSize(int value) { boardSize.setValue(value); }
    public static void setWinCon(int value) { winCon.setValue(value); }

    public int getBoardSize() { return boardSize.getValue(); }
    public int getWinCon() { return winCon.getValue(); }
}