package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    // Fragment Declaration
    MenuFragment menuFragment = new MenuFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    BoardFragment boardFragment = new BoardFragment();
    ProfileFragment profileFragment = new ProfileFragment();
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
        loadMenuFragment();
        AppData mainActivityDataViewModel = new ViewModelProvider(this).get(AppData.class);
        mainActivityDataViewModel.menuClicked.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (mainActivityDataViewModel.getMenuClicked() == 0) {
                    loadMenuFragment();
                }
                if (mainActivityDataViewModel.getMenuClicked() == 1) {
                    loadBoardFragment();
                }
                if (mainActivityDataViewModel.getMenuClicked() == 2) {
                    loadSettingsFragment();
                }
                if (mainActivityDataViewModel.getMenuClicked() == 3) {
                    //loadProfileFragment();
                }
            }
        });
    }

    private void loadMenuFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, menuFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, menuFragment).commit();
        }
    }

    private void loadBoardFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, boardFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, boardFragment).commit();
        }
    }

    private void loadSettingsFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, settingsFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, settingsFragment).commit();
        }
    }
   /* private void loadProfileFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, profileFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, profileFragment).commit();
        }
    }*/
}