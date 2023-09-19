package com.example.tictactoe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class profileAdapter extends RecyclerView.Adapter<profileVH>{
    Context context;
    //create recycle view class for profile adapter
    ArrayList<Profile> profile;
    public profileAdapter(Context context, ArrayList<Profile> profile){
        this.context = context;
        this.profile = profile;
        }
        @NonNull
        @Override
        public profileVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.fragment_userprofile,parent,false);
            profileVH profileViewHolder = new profileVH(view,parent);
            return profileViewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull profileVH holder, int position) {
        Profile sdata = profile.get(position);
        holder.textView.setText(sdata.getUsername());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Calling "+ sdata.getUsername(),
                        Toast.LENGTH_SHORT).show();
                Log.d("Values", sdata.getUsername());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
