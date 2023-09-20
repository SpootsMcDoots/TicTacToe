package com.example.tictactoe;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BoardFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private View rootView;

    public BoardFragment() {
        // Required empty public constructor
    }

    public static BoardFragment newInstance(String param1, String param2) {
        BoardFragment fragment = new BoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_board, container, false);

        GameData gameDVM = new ViewModelProvider(getActivity()).get(GameData.class);
        AppData mainActivityDVM = new ViewModelProvider(getActivity()).get(AppData.class);

        Button back = rootView.findViewById(R.id.backButton);
        Button reset = rootView.findViewById(R.id.resetButton);
        Chronometer timer = rootView.findViewById(R.id.timer);
        TextView playerIndicator = rootView.findViewById(R.id.tv_current_player);
        ImageView playerAvatar = rootView.findViewById(R.id.avatar_current_player);
        CountDownTimer cTimer = null;

        RecyclerView rv = rootView.findViewById(R.id.boardRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), gameDVM.getBoardSize(), GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        BoardAdapter adapter = new BoardAdapter(gameDVM.getBoard(), mainActivityDVM, gameDVM);
        rv.setAdapter(adapter);
        if(gameDVM.getPlayer1() == null){
            gameDVM.setPlayer1(mainActivityDVM.getProfile(0));
        }
        if(gameDVM.getPlayer2() == null){
            gameDVM.setPlayer2(mainActivityDVM.getProfile(1));
        }

        gameDVM.newGame();
	    timer.start();
        CountDownTimer finalCTimer = startTimer(mainActivityDVM, gameDVM);
        gameDVM.turnPlayer.observe(getActivity(), new Observer<Profile>() {
            public void onChanged(Profile currentPlayer) {
                finalCTimer.cancel();
                playerIndicator.setText(gameDVM.turnPlayer.getValue().getUsername());
                playerAvatar.setImageResource(gameDVM.turnPlayer.getValue().getAvatarId());
                finalCTimer.start();
            }
        });

       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               adapter.resetBoard();
               BoardAdapter adapter = new BoardAdapter(gameDVM.getBoard(), mainActivityDVM, gameDVM);
               rv.setAdapter(adapter);
               mainActivityDVM.setMenuClicked(0);
               finalCTimer.cancel();
            }
       });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.resetBoard();
                BoardAdapter adapter = new BoardAdapter(gameDVM.getBoard(), mainActivityDVM, gameDVM);
                rv.setAdapter(adapter);
                timer.start();
                finalCTimer.cancel();
                finalCTimer.start();
            }
        });

        return rootView;
    }

    //start timer function
    private CountDownTimer startTimer(AppData appData, GameData gameDVM) {
        //Countdown timer
        TextView countdown = rootView.findViewById(R.id.countdown);
        long duration = TimeUnit.SECONDS.toMillis(10);
        CountDownTimer cTimer = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long ll) {
                //Converting milliseconds to minutes and seconds
                //Ref youtube: https://www.youtube.com/watch?v=T_wSEnqGPdo
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(ll), TimeUnit.MILLISECONDS.toSeconds(ll)
                                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ll)));

                //set this to text view
                countdown.setText(sDuration);
            }
            @Override
            public void onFinish() {
                cancel();
                gameDVM.endTurn();
                appData.setMenuClicked(6);
            }
        };
        return cTimer;
    }



}