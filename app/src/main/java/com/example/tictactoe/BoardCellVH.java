package com.example.tictactoe;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

public class BoardCellVH extends RecyclerView.ViewHolder {

    public ImageButton boardButton;

    public BoardCellVH(@NonNull View itemView, ViewGroup parent) {
        super(itemView);
        int hSize = parent.getMeasuredHeight() / 3;
        int wSize = parent.getMeasuredWidth() / 3;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.height = hSize;
        lp.width = wSize;
        boardButton = itemView.findViewById(R.id.cellButton);
    }
}
