package com.example.tictactoe;


/**
 * This holds the information for user profiles
 */
public class Profile {

        private int avatarId;
        private int gameIconId;
        private String playerName;

    /**
     * Default Id
     */
    public Profile() {
            //avatarId = newDrawableId;
        }

        public int getAvatarId() {
            return avatarId;
        }

        public void setAvatarId(int newDrawableId) {
            avatarId = newDrawableId;
        }
}
