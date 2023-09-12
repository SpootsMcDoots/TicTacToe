package com.example.tictactoe;

import android.view.View;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationData extends ViewModel {
    public MutableLiveData<Integer> menuClicked;

    public NavigationData() {
        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);
    }

    public int getMenuClicked() {
        return menuClicked.getValue();
    }

    public void setMenuClicked(int value) {
        menuClicked.setValue(value);
    }
}
