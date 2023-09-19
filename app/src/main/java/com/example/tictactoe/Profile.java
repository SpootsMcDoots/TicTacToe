package com.example.tictactoe;

import androidx.lifecycle.ViewModelProvider;

/**
 * This holds the information for user profiles
 */
public class Profile {
    private int profileID;
    private String username;
    private int winCount = 0;
    private int loseCount = 0;
    private int draw = 0;
    private int avatarId = 0;
    private AppData mainActivityDVM = new ViewModelProvider().get(AppData.class);


    public Profile(int newAvatarId, String newUsername) {
        setAvatarId(newAvatarId);
        setUsername(newUsername);
        setProfileID();
    }
    public int getProfileID() {return profileID;}
    public void setProfileID() {profileID = appData.getProfileCount();}
    public int getAvatarId() {return avatarId;}
    public void setAvatarId (int newDrawableId) {avatarId = newDrawableId;}
    public String getUsername () {return username;}
    public void setUsername (String username){this.username = username;}
    public void win_match () {this.winCount++;}
    public void lost_match () {this.loseCount++;}
    public void draw_match () {this.draw++;}

    // Return win/lose/draw percentages for the user,
    public float[] user_statistic() {
        float total = draw + loseCount + winCount;
        float drawPercentage = (float) draw / total;
        float losePercentage = (float) loseCount / total;
        float winPercentage = (float) winCount / total;
        //NOTE: return an array in here
        return new float[]{drawPercentage, losePercentage, winPercentage};
    }

        public int win_number () {
            return winCount;
        }
    }