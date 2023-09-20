package com.example.tictactoe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardVH>{
    Context context;
    //create recycle view class for profile adapter
    List<Profile> profile;
    public LeaderboardAdapter(Context context, ArrayList<Profile> profile){
        this.context = context;
        this.profile = profile;
        Log.d("TAG", Integer.toString(profile.size()));
    }
    @Override
    public LeaderboardVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.leaderboard_list_element,parent,false);
        LeaderboardVH vh = new LeaderboardVH(view);
        return vh;
    }
    @Override
    public void onBindViewHolder(LeaderboardVH holder, int position) {
        Profile data = profile.get(position);
        holder.username.setText(data.getUsername());
        holder.win.setText(Integer.toString(data.getWin()));
        holder.lose.setText(Integer.toString(data.getLose()));
        holder.draw.setText(Integer.toString(data.getDraw()));
        holder.avatar.setImageResource(data.getAvatarId());
    }
    @Override
    public int getItemCount() {
        return profile.size();
    }

}
