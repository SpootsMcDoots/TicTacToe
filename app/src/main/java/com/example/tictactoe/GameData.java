package com.example.tictactoe;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;

public class GameData extends ViewModel{
    public MutableLiveData<Profile> player1;
    public MutableLiveData<Profile> player2;
    public MutableLiveData<ArrayList> players;
    public MutableLiveData<Profile> turnPlayer;


    public GameData() {
        player1 = new MediatorLiveData<Profile>();
        player2 = new MediatorLiveData<Profile>();
        players = new MediatorLiveData<ArrayList>();
        ArrayList<Profile> newList = new ArrayList<Profile>();
        players.setValue(newList);
    }

    public void setPlayer1(Profile p1) { player1.setValue(p1); }

    public void setPlayer2(Profile p2) { player2.setValue(p2); }

    public Profile getPlayer1() { return player1.getValue(); }

    public Profile getPlayer2() { return player2.getValue(); }

    //public Profile getPlayer(String username) {}
    public boolean playersIsEmpty() {
        return players.getValue().isEmpty();
    }

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

}