package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Testing below
    List<Profile> profiles;
    public MainActivity(){

    }
    public MenuFragment menuFragment = new MenuFragment();
    public SettingsFragment settingsFragment = new SettingsFragment();
    public BoardFragment boardFragment = new BoardFragment();
    public ProfileFragment profileFragment= new ProfileFragment();
    public LeaderboardFragment leaderboardFragment = new LeaderboardFragment();

    public FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout menuFrame = findViewById(R.id.menus_container);
        FrameLayout boardFrame = findViewById(R.id.menus_container);
        AppData mainActivityDVM = new ViewModelProvider(this).get(AppData.class);

        loadMenuFragment();

        mainActivityDVM.menuClicked.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //BACK BUTTON
                if (mainActivityDVM.getMenuClicked() == 0) {
                    boardFrame.setVisibility(View.GONE);
                    menuFrame.setVisibility(View.VISIBLE);
                    loadMenuFragment();
                }
                if (mainActivityDVM.getMenuClicked() == 1) {
                    menuFrame.setVisibility(View.GONE);
                    boardFrame.setVisibility(View.VISIBLE);
                    loadBoardFragment();
                }
                if (mainActivityDVM.getMenuClicked() == 2) {
                    loadSettingsFragment();
                }
                if (mainActivityDVM.getMenuClicked() == 3){
                    loadProfileFragment();
                }
                if (mainActivityDVM.getMenuClicked() == 4){
                    loadLeaderboardFragment();
                }

            }
        });
    }

    private void loadMenuFragment() {
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, menuFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, menuFragment).commit();
        }
    }

    private void loadBoardFragment() {
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, boardFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, boardFragment).commit();
        }
    }

    private void loadSettingsFragment() {
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, settingsFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, settingsFragment).commit();
        }
    }
    private void loadProfileFragment() {
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, profileFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, profileFragment).commit();
        }
    }
    private void loadLeaderboardFragment() {
        Fragment frag = fm.findFragmentById(R.id.menus_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.menus_container, leaderboardFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menus_container, leaderboardFragment).commit();
        }
    }
}