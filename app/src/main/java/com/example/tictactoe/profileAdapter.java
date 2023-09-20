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

public class profileAdapter extends RecyclerView.Adapter<profileVH>{
    Context context;
    //create recycle view class for profile adapter
    List<Profile> profile;
    AppData mainActivityDVM;
    GameData gameDVM;
    int currentSelection;
    public profileAdapter(Context context, ArrayList<Profile> profile,AppData newMainActivityDVM, GameData newGameDVM){
        this.context = context;
        this.profile = profile;
        mainActivityDVM = newMainActivityDVM;
        gameDVM = newGameDVM;
        this.currentSelection = 1;
        }
        @NonNull
        @Override
        public profileVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.profile_list_element,parent,false);
            profileVH profileViewHolder = new profileVH(view);
            return profileViewHolder;
        }
    @Override
    public void onBindViewHolder(@NonNull profileVH holder, int position) {
        Profile sdata = profile.get(position);
        holder.textView.setText(sdata.getUsername());
        holder.profileAvatar.setImageResource(sdata.getAvatarId());
        holder.select.setBackgroundResource(R.drawable.default_button);
        holder.button.setBackgroundResource(R.drawable.default_button);
        if(gameDVM.getPlayer1() == sdata || gameDVM.getPlayer2() == sdata) {
            holder.select.setBackgroundResource(R.drawable.default_button_pressed);
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setMenuClicked(5);
                mainActivityDVM.setCurrentEditProfile(sdata);
            }
        });
        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentSelection%2 == 0) {
                    gameDVM.setPlayer1(sdata);
                }
                else {
                    gameDVM.setPlayer2(sdata);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return profile.size();
    }
}
