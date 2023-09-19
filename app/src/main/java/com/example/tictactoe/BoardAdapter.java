package com.example.tictactoe;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class BoardAdapter extends RecyclerView.Adapter<BoardCellVH> {

    Board data;

    public BoardAdapter(Board newData) {
        data = newData;
    }

    @NonNull
    @Override
    public BoardCellVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.game_cell, parent, false);
        BoardCellVH boardVH = new BoardCellVH(view, parent, data.getSize());
        return boardVH;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardCellVH holder, int position) {
        BoardCell single = data.getBoardCell(position % data.getSize(), position / data.getSize());
        holder.boardButton.setImageResource(single.getMarkerId());

        holder.boardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.boardButton.setImageResource(R.drawable.cross);
                data.setBoardCell(position / data.getSize(),position % data.getSize(), 1);
                Log.d("TAG", (Arrays.deepToString(data.getBoard())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.getTotalSize();
    }
}
