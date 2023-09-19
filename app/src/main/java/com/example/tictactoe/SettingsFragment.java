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
        AppData mainActivityDVM = new ViewModelProvider(getActivity()).get(AppData.class);

        Button[] boardSizes =   {   rootView.findViewById(R.id.size3x3),
                                    rootView.findViewById(R.id.size4x4),
                                    rootView.findViewById(R.id.size5x5)};
        for (Button button : boardSizes) {
            button.setBackgroundResource(R.drawable.default_button);
        }

        Button[] winCons =   {  rootView.findViewById(R.id.win3),
                                rootView.findViewById(R.id.win4),
                                rootView.findViewById(R.id.win5)};
        for (Button button : winCons) {
            button.setBackgroundResource(R.drawable.default_button);
        }

        Button back = rootView.findViewById(R.id.backButton);

        //BoardSizeMonitor
        mainActivityDVM.boardSize.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            //Monitor for changes, if the buttons are pressed, change the drawable to reflect that to the user
            public void onChanged(Integer integer) {
                for (Button button : boardSizes) {
                    button.setBackgroundResource(R.drawable.default_button);
                }
                if (mainActivityDVM.getBoardSize() == 3) {
                    boardSizes[0].setBackgroundResource(R.drawable.default_button_pressed);
                }
                if (mainActivityDVM.getBoardSize() == 4) {
                    boardSizes[1].setBackgroundResource(R.drawable.default_button_pressed);
                }
                if (mainActivityDVM.getBoardSize() == 5) {
                    boardSizes[2].setBackgroundResource(R.drawable.default_button_pressed);

                }
            }
        });
        //WinConMonitor
        mainActivityDVM.winCon.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            //Monitor for changes, if the buttons are pressed, change the drawable to reflect that to the user
            public void onChanged(Integer integer) {
                for (Button button : winCons) {
                    button.setBackgroundResource(R.drawable.default_button);
                }
                if (mainActivityDVM.getWinCon() == 3) {
                    winCons[0].setBackgroundResource(R.drawable.default_button_pressed);
                }
                if (mainActivityDVM.getWinCon() == 4) {
                    winCons[1].setBackgroundResource(R.drawable.default_button_pressed);
                }
                if (mainActivityDVM.getWinCon() == 5) {
                    winCons[2].setBackgroundResource(R.drawable.default_button_pressed);
                }
            }
        });

        //Button listeners.
        //OnClick Data back to data handler
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setMenuClicked(0);
            }
        });
        boardSizes[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setBoardSize(3);
            }
        });
        boardSizes[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setBoardSize(4);
            }
        });
        boardSizes[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setBoardSize(5);
            }
        });
        winCons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setWinCon(3);
            }
        });
        winCons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setWinCon(4);
            }
        });
        winCons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setWinCon(5);
            }
        });
        return rootView;
    }
}