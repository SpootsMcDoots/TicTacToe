package com.example.tictactoe;

public class Profile {
    String username;
    int winCount = 0;
    int loseCount = 0;
    int draw = 0;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    // Call the following methods to update the number of win/lose/draw
    public void win_match(){
        this.winCount++;
    }

    public void lost_match(){
        this.loseCount++;
    }

    public void draw_match(){
        this.draw++;
    }

    // Return win/lose/draw percentages for the user,
    public float[] user_statistic(){
        float total = draw + loseCount + winCount;
        float drawPercentage = (float) draw / total;
        float losePercentage = (float) loseCount / total;
        float winPercentage = (float) winCount / total;
//NOTE: return an array in here
        return new float[]{drawPercentage, losePercentage, winPercentage};
    }

    public int win_number(){
        return winCount;
    }
}
