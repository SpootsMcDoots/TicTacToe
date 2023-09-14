package com.example.tictactoe;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationData extends ViewModel {
    public MutableLiveData<Integer> menuClicked;
    public MutableLiveData<Integer> settingsClicked;
    public NavigationData() {
        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);

        settingsClicked = new MediatorLiveData<Integer>();
        settingsClicked.setValue(0);
    }

    public int getMenuClicked() {
        return menuClicked.getValue();
    }

    public void setMenuClicked(int value) {
        menuClicked.setValue(value);
    }

    public int getSettingsClicked()  { return settingsClicked.getValue(); }

    public void setSettingsClicked(int value)  { settingsClicked.setValue(value); }
}
