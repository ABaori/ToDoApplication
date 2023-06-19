package com.example.todoapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.ExecutorService;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    EditText Title , Note;
    Context context = MainActivity.this;

    ImageView img;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        button = findViewById(R.id.Add_btn);
        Title = findViewById(R.id.Title_edt);
        Note = findViewById(R.id.Note_edt);
        img = findViewById(R.id.Img1);
        handler = new Handler();


//        thread = new Thread();


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                runnable = new Runnable() {
                    @Override
                    public void run() {

                        img.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000)
                                .withEndAction(new Runnable() {
                                    @Override
                                    public void run() {

                                        img.setImageResource(R.drawable.btn_anmt_bg);
                                        Log.i(String.valueOf(context), "Inside runnable");

                                    }

                                });
                    }

                };
                runnable.run();



            }
        });






    }




}