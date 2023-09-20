package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.util.Arrays;

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

        RecyclerView rv = rootView.findViewById(R.id.boardRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), gameDVM.getBoardSize(), GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        BoardAdapter adapter = new BoardAdapter(gameDVM.getBoard());
        rv.setAdapter(adapter);

        if(mainActivityDVM.playersIsEmpty()) {
            Profile p1 = new Profile(1,"Player1");
            Profile p2 = new Profile(2,"Player2");
            Log.d("TAG", p1.getUsername());
            Log.d("TAG", p2.getUsername());
            mainActivityDVM.addPlayer(p1);
            mainActivityDVM.addPlayer(p2);
            gameDVM.setPlayer1(mainActivityDVM.getProfile(0));
            Log.d("TAG", gameDVM.getPlayer1().getUsername());
            gameDVM.setPlayer2(mainActivityDVM.getProfile(1));
            Log.d("TAG", gameDVM.getPlayer2().getUsername());
            Log.d("TAG", Integer.toString(gameDVM.getPlayer1().getProfileID()) + Integer.toString(gameDVM.getPlayer2().getProfileID()));
       }
       gameDVM.newGame();

        //TODO
       //Log.d("TAG", (Arrays.deepToString(board.getBoard())));

       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mainActivityDVM.setMenuClicked(0);
            }
       });

        return rootView;
    }

}