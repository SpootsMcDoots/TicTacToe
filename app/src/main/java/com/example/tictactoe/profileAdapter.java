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
    public profileAdapter(Context context, ArrayList<Profile> profile,AppData newMainActivityDVM){
        this.context = context;
        this.profile = profile;
        mainActivityDVM = newMainActivityDVM;
        }
        @NonNull
        @Override
        public profileVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.profile_list_element,parent,false);
            profileVH profileViewHolder = new profileVH(view,parent,profile.size());
            return profileViewHolder;
        }
    @Override
    public void onBindViewHolder(@NonNull profileVH holder, int position) {
        Profile sdata = profile.get(position);
        holder.textView.setText(sdata.getUsername());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDVM.setMenuClicked(5);
                mainActivityDVM.setCurrentEditProfile(sdata);
            }
        });

    }

    @Override
    public int getItemCount() {
        return profile.size();
    }
}
