package com.example.tictactoe;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class AppData extends ViewModel {
    public static MutableLiveData<Integer> menuClicked;

    //Settings Menu Data
    public static MutableLiveData<ArrayList> players;
    public static MutableLiveData<Profile> currentEditProfile;

    //Initialise to defaults
    public AppData() {

        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);
        players = new MutableLiveData<ArrayList>();
        players.setValue(new ArrayList<Profile>());
        addPlayer(new Profile(getProfileCount()+1,R.drawable.cross,"Player1"));
        addPlayer(new Profile(getProfileCount()+1,R.drawable.naught,"Player2"));
        currentEditProfile = new MutableLiveData<Profile>();
        currentEditProfile.setValue(getProfile(1));

    }

    //Getters and setters
    public int getMenuClicked() {
        return menuClicked.getValue();
    }
    public void setMenuClicked(int value) {
        menuClicked.setValue(value);
    }

    public ArrayList<Profile> getPlayers() { return players.getValue();}

    //store the array from the profile
    public static void addPlayer(Profile player) {players.getValue().add(player); }

    public static int getProfileCount() {return players.getValue().size();}

    public Profile getProfile(int ID) {return (Profile)players.getValue().get(ID);}

    public void setCurrentEditProfile(Profile profile) {currentEditProfile.setValue(profile);}

    public Profile getCurrentEditProfile() {return currentEditProfile.getValue(); }

    public boolean playersIsEmpty() {
        boolean result = false;
        if (players.getValue().size() < 2) {
            result = true;
        }
        return result;
    }
}