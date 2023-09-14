package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public MenuFragment menuFragment = new MenuFragment();
    public SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMenuFragment();
        NavigationData mainActivityDataViewModel = new ViewModelProvider(this).get(NavigationData.class);
        mainActivityDataViewModel.menuClicked.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (mainActivityDataViewModel.getMenuClicked() == 1) {
                    loadBoardFragment();
                }
                if (mainActivityDataViewModel.getMenuClicked() == 2) {
                    loadSettingsFragment();
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