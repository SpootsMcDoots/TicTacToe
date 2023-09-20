package com.example.tictactoe;


import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class LeaderboardVH extends RecyclerView.ViewHolder {
    public TextView username;
    public TextView win;
    public TextView lose;
    public TextView draw;
    public ImageView avatar;

    public LeaderboardVH(View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.username);
        win = itemView.findViewById(R.id.win);
        lose = itemView.findViewById(R.id.lose);
        draw = itemView.findViewById(R.id.draw);
        avatar = itemView.findViewById(R.id.avatar);
    }
}
