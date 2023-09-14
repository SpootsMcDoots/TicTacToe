package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

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
        NavigationData mainActivityDVM = new ViewModelProvider(getActivity())
                .get(NavigationData.class);

        BoardCell[][] board = {
                { new BoardCell(rootView.findViewById(R.id.cell_tl)) ,  new BoardCell(rootView.findViewById(R.id.cell_tm)), new BoardCell(rootView.findViewById(R.id.cell_tr)) },
                { new BoardCell(rootView.findViewById(R.id.cell_ml)) ,  new BoardCell(rootView.findViewById(R.id.cell_mm)), new BoardCell(rootView.findViewById(R.id.cell_mr)) },
                { new BoardCell(rootView.findViewById(R.id.cell_bl)) ,  new BoardCell(rootView.findViewById(R.id.cell_bm)), new BoardCell(rootView.findViewById(R.id.cell_br)) }
        };

        Button back = rootView.findViewById(R.id.backButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setBackClicked(1);
            }
        });

        (board[0][0].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[0][0].fillCell(R.drawable.cross, 1);
            }
        });
        (board[0][1].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[0][1].fillCell(R.drawable.cross, 1);
            }
        });
        (board[0][2].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[0][2].fillCell(R.drawable.cross, 1);
            }
        });
        (board[1][0].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[1][0].fillCell(R.drawable.cross, 1);
            }
        });
        (board[1][1].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[1][1].fillCell(R.drawable.cross, 1);
            }
        });
        (board[1][2].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[1][2].fillCell(R.drawable.cross, 1);
            }
        });
        (board[2][0].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[2][0].fillCell(R.drawable.cross, 1);
            }
        });
        (board[2][1].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[2][1].fillCell(R.drawable.cross, 1);
            }
        });
        (board[2][2].getCell()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board[2][2].fillCell(R.drawable.cross, 1);
            }
        });

        return rootView;
    }
}