package com.example.tictactoe;


import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
public class profileVH extends RecyclerView.ViewHolder {
    public TextView textView;
    public Button button;
    public Button select;
    public ImageView profileAvatar;
    public profileVH(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        button = itemView.findViewById(R.id.editbutton);
        select = itemView.findViewById(R.id.selectbutton);
        profileAvatar = itemView.findViewById(R.id.avatarProfile);

    }
}
