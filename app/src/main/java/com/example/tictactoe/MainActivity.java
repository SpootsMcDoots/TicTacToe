package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

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
}