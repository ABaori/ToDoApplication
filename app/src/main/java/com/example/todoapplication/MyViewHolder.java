package com.example.todoapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView title,note;
    public CardView cardView;
    public RecyclerViewInterface viewInterface;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_riv);
        note = itemView.findViewById(R.id.note_riv);
        cardView = itemView.findViewById(R.id.CardView);



    }
    

}
