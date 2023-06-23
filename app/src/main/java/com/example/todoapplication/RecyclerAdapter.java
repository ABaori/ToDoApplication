package com.example.todoapplication;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<NoteModel> arrayList;

    public RecyclerAdapter(Context context, ArrayList<NoteModel> arrayList , RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.arrayList = arrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycleritemiew,parent,false)) ;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.note.setText(arrayList.get(position).getNote());
        int posit
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewInterface.onItemClick(position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
