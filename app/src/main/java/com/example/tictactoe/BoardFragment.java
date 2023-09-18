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
import android.widget.ImageButton;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BoardFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        View rootView = inflater.inflate(R.layout.fragment_board, container, false);
        GameData gameDVM = new ViewModelProvider(getActivity()).get(GameData.class);
        AppData mainActivityDVM = new ViewModelProvider(getActivity()).get(AppData.class);

        Board board = new Board(mainActivityDVM.getBoardSize(), mainActivityDVM.getWinCon());

        RecyclerView rv = rootView.findViewById(R.id.boardRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), board.getSize(), GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        BoardAdapter adapter = new BoardAdapter(board);
        rv.setAdapter(adapter);

       if(gameDVM.playersIsEmpty()) {
           gameDVM.setPlayer1(new Profile(1, R.drawable.cross));
           gameDVM.setPlayer2(new Profile(1, R.drawable.naught));
           gameDVM.players.getValue().add(gameDVM.getPlayer1());
           gameDVM.players.getValue().add(gameDVM.getPlayer2());
       }
       gameDVM.newGame();
       Log.d("TAG", (Arrays.deepToString(board.getBoard())));
       Button back = rootView.findViewById(R.id.backButton);

       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mainActivityDVM.setMenuClicked(0);
            }
       });

        return rootView;
    }
}