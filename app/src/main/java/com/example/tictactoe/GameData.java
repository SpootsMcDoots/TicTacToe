package com.example.tictactoe;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;

public class GameData extends ViewModel{
    public MutableLiveData<Profile> player1;
    public MutableLiveData<Profile> player2;
    public ArrayList<Profile> players;

    public GameData() {
        player1 = new MediatorLiveData<Profile>();
        player2 = new MediatorLiveData<Profile>();

        players = new ArrayList<Profile>();
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