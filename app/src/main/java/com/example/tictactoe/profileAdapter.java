package com.example.tictactoe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class profileAdapter extends RecyclerView.Adapter<profileVH>{
    //create recycle view class for profile adapter
    ArrayList<Profile> profile = new ArrayList<>();
    public profileAdapter(ArrayList<Profile> profile){
            this.profile = profile;
        }

    @NonNull
    @Override
    public profileVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_userprofile,parent,false);
        profileVH profileViewHolder = new profileVH(view);
        return profileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull profileVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
