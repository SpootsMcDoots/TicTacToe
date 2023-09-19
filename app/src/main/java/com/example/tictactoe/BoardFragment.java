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
           gameDVM.setPlayer1(new Profile(R.drawable.cross, "Player 1"));
           gameDVM.setPlayer2(new Profile(R.drawable.naught, "Player 2"));
           mainActivityDVM.players.getValue().add(gameDVM.getPlayer1());
           mainActivityDVM.players.getValue().add(gameDVM.getPlayer2());
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