package com.example.tictactoe;

import android.view.View;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationData extends ViewModel {
    public MutableLiveData<Integer> menuClicked;

    //Settings Menu Data
    public MutableLiveData<Integer> boardSize;
    public MutableLiveData<Integer> winCon;

    public NavigationData() {
        menuClicked = new MediatorLiveData<Integer>();
        menuClicked.setValue(0);

        boardSize = new MediatorLiveData<Integer>();
        boardSize.setValue(3);

        winCon = new MediatorLiveData<Integer>();
        winCon.setValue(3);
    }

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


}
