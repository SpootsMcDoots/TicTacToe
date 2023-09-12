package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    // Fragment Declaration
    MenuFragment menuFragment = new MenuFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    /**
    *   I'm just chucking variables in atm
    */
    int boardsize;

    int winCond;

    int playermarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void loadMenuFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.frameLayout);
        if(frag == null) {
            fm.beginTransaction().add(R.id.frameLayout, menuFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.frameLayout, menuFragment).commit();
        }
    }
}