package com.example.tictactoe;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class profileVH extends RecyclerView.ViewHolder {
    public TextView textView;
    public Button button;
    public profileVH(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        button = itemView.findViewById(R.id.button);
    }
}
