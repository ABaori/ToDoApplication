package com.example.todoapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    EditText Title , Note;
    Context context = MainActivity.this;
    Drawable drawable;
    ImageView img, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        button = findViewById(R.id.Add_btn);
        Title = findViewById(R.id.Title_edt);
        Note = findViewById(R.id.Note_edt);
        img = findViewById(R.id.Img1);
        img2 = findViewById(R.id.Img2);
        drawable = getDrawable(R.drawable.animation);
//        thread = new Thread();


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                img2.setVisibility(View.VISIBLE);
                

            }
        });





    }




}