package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MenuFragment menuFragment = new MenuFragment();
    public SettingsFragment settingsFragment = new SettingsFragment();
    public BoardFragment boardFragment = new BoardFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout menuFrame = findViewById(R.id.menus_container);
        FrameLayout boardFrame = findViewById(R.id.board_container);
        NavigationData mainActivityDataViewModel = new ViewModelProvider(this).get(NavigationData.class);
        GameData gameDVM = new ViewModelProvider(this).get(GameData.class);

        loadMenuFragment();

        mainActivityDataViewModel.menuClicked.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (mainActivityDataViewModel.getMenuClicked() == 1) {
                    menuFrame.setVisibility(View.GONE);
                    boardFrame.setVisibility(View.VISIBLE);
                    loadBoardFragment();
                }
                if (mainActivityDataViewModel.getMenuClicked() == 2) {
                    loadSettingsFragment();
                }
            }
        });

        mainActivityDataViewModel.backClicked.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (mainActivityDataViewModel.getBackClicked() == 1) {
                    mainActivityDataViewModel.setBackClicked(0);
                    boardFrame.setVisibility(View.GONE);
                    menuFrame.setVisibility(View.VISIBLE);
                    loadMenuFragment();
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
        Fragment frag = fm.findFragmentById(R.id.board_container);
        if(frag == null) {
            fm.beginTransaction().add(R.id.board_container, boardFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.board_container, boardFragment).commit();
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
}