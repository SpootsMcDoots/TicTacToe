package com.example.tictactoe;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WinFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_win, container, false);
        AppData mainActivityDVM = new ViewModelProvider(getActivity()).get(AppData.class);
        GameData gameDVM = new ViewModelProvider(getActivity()).get(GameData.class);

        Button back = rootView.findViewById(R.id.back);
        ImageView avatar = rootView.findViewById(R.id.avatar);
        TextView msg = rootView.findViewById(R.id.message);

        avatar.setImageResource(gameDVM.getTurnPlayer().getAvatarId());
        msg.setText(gameDVM.getTurnPlayer().getUsername() + "Wins!");
        if(gameDVM.getTurnPlayer() == gameDVM.getPlayer1()) {
            gameDVM.getPlayer1().win_match();
            gameDVM.getPlayer2().lost_match();
        }
        else{
            gameDVM.getPlayer2().win_match();
            gameDVM.getPlayer1().lost_match();
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setMenuClicked(1);
            }
        });
        return rootView;
    }
}