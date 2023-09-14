package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        NavigationData mainActivityDVM = new ViewModelProvider(getActivity())
                .get(NavigationData.class);

        //TODO: implement game data
        //GameData mainActivityDVM = new ViewModelProvider(getActivity())
        //  .get(GameData.class);

        Button[] boardSizes =   {   rootView.findViewById(R.id.size3x3),
                                    rootView.findViewById(R.id.size4x4),
                                    rootView.findViewById(R.id.size5x5)};

        Button[] winCons =   {  rootView.findViewById(R.id.win3),
                                rootView.findViewById(R.id.win4),
                                rootView.findViewById(R.id.win5)};

        Button back = rootView.findViewById(R.id.backButton);

        //Boardsizes listeners.
        boardSizes[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GameData.setBoardSize(3);
            }
        });
        boardSizes[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GameData.setBoardSize(4);
            }
        });
        boardSizes[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GameData.setBoardSize(5);
            }
        });

        //WinCons listeners
        winCons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GameData.setWinCon(3);
            }
        });
        winCons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GameData.setWinCon(4);
            }
        });
        winCons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GameData.setWinCon(5);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mainActivityDVM.setSettingsClicked(1);
        }
        });

        return rootView;
    }
}