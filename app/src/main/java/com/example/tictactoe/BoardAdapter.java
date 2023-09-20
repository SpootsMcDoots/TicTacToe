package com.example.tictactoe;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class BoardAdapter extends RecyclerView.Adapter<BoardCellVH> {

    Board data;
    AppData mainActivityDVM;
    GameData gameDVM;

    public BoardAdapter(Board newData, AppData newMainActivityDVM, GameData newGameDVM) {
        data = newData;
        mainActivityDVM = newMainActivityDVM;
        gameDVM = newGameDVM;
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
                holder.boardButton.setImageResource(gameDVM.getTurnPlayer().getAvatarId());
                if(data.setBoardCell(position / data.getSize(),position % data.getSize(), gameDVM.getTurnPlayer().getProfileID())) {
                    resetBoard();
                    mainActivityDVM.setMenuClicked(6);
                }
                else {
                    gameDVM.endTurn();
                    if(gameDVM.checkDraw()){
                        resetBoard();
                        mainActivityDVM.setMenuClicked(7);
                    }
                }

            }
        });
    }
    public void resetBoard() {
        data.reset();
    }

    @Override
    public int getItemCount() {
        return data.getTotalSize();
    }
}
