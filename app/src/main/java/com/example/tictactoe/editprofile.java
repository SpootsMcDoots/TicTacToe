package com.example.tictactoe;

import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link editprofile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class editprofile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public editprofile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment editprofile.
     */
    // TODO: Rename and change types and number of parameters
    public static editprofile newInstance(String param1, String param2) {
        editprofile fragment = new editprofile();
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
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        AppData mainActivityDVM = new ViewModelProvider(getActivity()).get(AppData.class);
        Profile target = mainActivityDVM.getCurrentEditProfile();
        AppCompatImageButton avatar1 = view.findViewById(R.id.Avatar1);
        AppCompatImageButton avatar2 = view.findViewById(R.id.Avatar2);
        AppCompatImageButton avatar3 = view.findViewById(R.id.Avatar3);
        AppCompatImageButton avatar4 = view.findViewById(R.id.Avatar4);
        AppCompatImageButton avatar5 = view.findViewById(R.id.Avatar5);
        AppCompatImageButton avatar6 = view.findViewById(R.id.Avatar6);
        ImageView currentAvatar =  view.findViewById(R.id.currentAvatar);
        EditText username = view.findViewById(R.id.profileName);
        Button back = view.findViewById(R.id.saveButton);
        username.setText(target.getUsername());
        currentAvatar.setImageResource(target.getAvatarId());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                target.setUsername(username.getText().toString());
                mainActivityDVM.setMenuClicked(3);
            }
        });
        avatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatar.setImageResource(R.drawable.cross);
                target.setAvatarId(R.drawable.cross);
            }
        });
        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatar.setImageResource(R.drawable.naught);
                target.setAvatarId(R.drawable.naught);
            }
        });
        avatar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatar.setImageResource(R.drawable.scissors);
                target.setAvatarId(R.drawable.scissors);
            }
        });
        avatar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatar.setImageResource(R.drawable.battler);
                target.setAvatarId(R.drawable.battler);
            }
        });
        avatar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatar.setImageResource(R.drawable.gabumon);
                target.setAvatarId(R.drawable.gabumon);
            }
        });
        avatar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatar.setImageResource(R.drawable.download);
                target.setAvatarId(R.drawable.download);
            }
        });

        return view;
    }
}