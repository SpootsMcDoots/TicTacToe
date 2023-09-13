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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        NavigationData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(NavigationData.class);

        Button backButton = view.findViewById(R.id.back);

        //Declare buttons and set the drawable
        Button size3 = view.findViewById(R.id.size3x3);
        Button size4 = view.findViewById(R.id.size4x4);
        Button size5 = view.findViewById(R.id.size5x5);
        size3.setBackgroundResource(R.drawable.default_button);
        size4.setBackgroundResource(R.drawable.default_button);
        size5.setBackgroundResource(R.drawable.default_button);

        Button win3 = view.findViewById(R.id.win3);
        Button win4 = view.findViewById(R.id.win4);
        Button win5 = view.findViewById(R.id.win5);
        win3.setBackgroundResource(R.drawable.default_button);
        win4.setBackgroundResource(R.drawable.default_button);
        win5.setBackgroundResource(R.drawable.default_button);

        mainActivityDataViewModel.boardSize.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            //Monitor for changes, if the buttons are pressed, change the drawable to reflect that to the user
            public void onChanged(Integer integer) {
                if (mainActivityDataViewModel.getBoardSize() == 3) {
                    size3.setBackgroundResource(R.drawable.default_button_pressed);
                    size4.setBackgroundResource(R.drawable.default_button);
                    size5.setBackgroundResource(R.drawable.default_button);
                }
                if (mainActivityDataViewModel.getBoardSize() == 4) {
                    size3.setBackgroundResource(R.drawable.default_button);
                    size4.setBackgroundResource(R.drawable.default_button_pressed);
                    size5.setBackgroundResource(R.drawable.default_button);
                }
                if (mainActivityDataViewModel.getBoardSize() == 5) {
                    size3.setBackgroundResource(R.drawable.default_button);
                    size4.setBackgroundResource(R.drawable.default_button);
                    size5.setBackgroundResource(R.drawable.default_button_pressed);

                }
            }
        });

        //OnClick Data back to data handler
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setMenuClicked(0);
            }
        });
        size3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardSize(3);
            }
        });
        size4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardSize(4);
            }
        });
        size5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardSize(5);
            }
        });
        win3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setWinCon(3);
            }
        });
        win4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setWinCon(4);
            }
        });
        win5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setWinCon(5);
            }
        });
        return view;
    }
}