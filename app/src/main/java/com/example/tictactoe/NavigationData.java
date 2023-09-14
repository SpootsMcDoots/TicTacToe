package com.example.tictactoe;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationData extends ViewModel {
    public MutableLiveData<Integer> menuClicked;
    public MutableLiveData<Integer> backClicked;
    public NavigationData() {
        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);

        backClicked = new MediatorLiveData<Integer>();
        backClicked.setValue(0);
    }

    public int getMenuClicked() {
        return menuClicked.getValue();
    }

    public void setMenuClicked(int value) {
        menuClicked.setValue(value);
    }

    public int getBackClicked()  { return backClicked.getValue(); }

    public void setBackClicked(int value)  { backClicked.setValue(value); }
}
