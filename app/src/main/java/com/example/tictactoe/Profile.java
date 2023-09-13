package com.example.tictactoe;

public class Profile {
    String username;
    int winCount = 0;
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void win_match(){
        this.winCount++;
    }

    public int win_number(){
        return winCount;
    }
}
