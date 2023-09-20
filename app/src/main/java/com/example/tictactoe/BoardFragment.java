package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
        Chronometer timer = rootView.findViewById(R.id.timer);
        TextView playerIndicator = rootView.findViewById(R.id.tv_current_player);

        RecyclerView rv = rootView.findViewById(R.id.boardRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), gameDVM.getBoardSize(), GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        BoardAdapter adapter = new BoardAdapter(gameDVM.getBoard(), mainActivityDVM, gameDVM);
        rv.setAdapter(adapter);

        Log.d("TAG", Integer.toString(mainActivityDVM.getProfileCount()));
        if(mainActivityDVM.playersIsEmpty()) {
            mainActivityDVM.addPlayer(new Profile(mainActivityDVM.getProfileCount()+1,R.drawable.cross,"Player1"));
            mainActivityDVM.addPlayer(new Profile(mainActivityDVM.getProfileCount()+1,R.drawable.naught,"Player2"));
            Log.d("TAG", mainActivityDVM.getProfile(0).getUsername());
            Log.d("TAG", mainActivityDVM.getProfile(1).getUsername());
            gameDVM.setPlayer1(mainActivityDVM.getProfile(0));
            gameDVM.setPlayer2(mainActivityDVM.getProfile(1));
            Log.d("TAG", Integer.toString(gameDVM.getPlayer1().getProfileID()) + Integer.toString(gameDVM.getPlayer2().getProfileID()));
       }
       gameDVM.newGame();
	   timer.start();

        //TODO: use these in the switch turn methods!
        //This displays the current players turn.
        playerIndicator.setText(gameDVM.player1.getValue().getUsername());
        //TODO: Can probably display the profile pic in an imageview as well

       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mainActivityDVM.setMenuClicked(0);
            }
       });

        return rootView;
    }

    //start timer function
    void startTimer() {
        CountDownTimer cTimer = null;
        //Countdown timer
        TextView countdown = rootView.findViewById(R.id.countdown);
        long duration = TimeUnit.MINUTES.toMillis(1);
        cTimer = new CountDownTimer(duration, 1000) {
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
                //TODO: Toast is for small pop up info, use this for win/draw/invalid notifications
                Toast.makeText(getActivity(), "Turn has ended.", Toast.LENGTH_LONG).show();
            }
        };
        cTimer.start();
    }

}