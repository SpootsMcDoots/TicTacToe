package com.example.tictactoe;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class AppData extends ViewModel {
    public MutableLiveData<Integer> menuClicked;

    //Settings Menu Data
    public MutableLiveData<Integer> boardSize;
    public MutableLiveData<Integer> winCon;

    public MutableLiveData<Profile> player1;
    public MutableLiveData<Profile> player2;
    public ArrayList<Profile> players;

    //Initialise to defaults
    public AppData() {
        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);

        boardSize = new MediatorLiveData<Integer>();
        boardSize.setValue(3);

        winCon = new MediatorLiveData<Integer>();
        winCon.setValue(3);

        player1 = new MediatorLiveData<Profile>();
        player2 = new MediatorLiveData<Profile>();
        players = new ArrayList<Profile>();
    }

    //Getters and setters
    public int getMenuClicked() {
        return menuClicked.getValue();
    }
    public void setMenuClicked(int value) {
        menuClicked.setValue(value);
    }

    public int getBoardSize() {
        return boardSize.getValue();
    }
    public void setBoardSize(int value) {
        boardSize.setValue(value);
    }
    public int getWinCon() {
        return winCon.getValue();
    }
    public void setWinCon(int value) {
        winCon.setValue(value);
    }

    public void setPlayer1(Profile p1) { player1.setValue(p1); }

    public void setPlayer2(Profile p2) { player2.setValue(p2); }

    public Profile getPlayer1() { return player1.getValue(); }

    public Profile getPlayer2() { return player2.getValue(); }

    //public Profile getPlayer(String username) {}
    public boolean playersIsEmpty() {
        return players.isEmpty();
    }
}