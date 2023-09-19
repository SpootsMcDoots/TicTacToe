package com.example.tictactoe;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class AppData extends ViewModel {
    public MutableLiveData<Integer> menuClicked;

    //Settings Menu Data
    public MutableLiveData<ArrayList> players;

    //Initialise to defaults
    public AppData() {
        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);
        players = new MutableLiveData<ArrayList>();
        players.setValue(new ArrayList<Profile>());
    }

    //Getters and setters
    public int getMenuClicked() {
        return menuClicked.getValue();
    }
    public void setMenuClicked(int value) {
        menuClicked.setValue(value);
    }

    //store the array from the profile
    public void addPlayer(Profile player) {players.getValue().add(player); }

    //public Profile getPlayer(String username) {}
    public boolean playersIsEmpty() {
        return players.getValue().isEmpty();
    }
}