package com.example.tictactoe;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class AppData extends ViewModel {
    public static MutableLiveData<Integer> menuClicked;

    //Settings Menu Data
    public static MutableLiveData<ArrayList> players;

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
    public static void addPlayer(Profile player) {players.getValue().add(player); }

    public static int getProfileCount() {return players.getValue().size();}

    public Profile getProfile(int ID) {return (Profile)players.getValue().get(ID);}

    public boolean playersIsEmpty() {
        boolean result = false;
        if (players.getValue().size() < 2) {
            result = true;
        }
        return result;
    }
}