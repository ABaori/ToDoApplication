package com.example.todoapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
import androidx.recyclerview.widget.LinearLayoutManager;
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
    RecyclerAdapter adapter;

    DatabaseModel dm = new DatabaseModel(context);
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
        runnable = new Runnable() {
            @Override
            public void run() {

                img.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {

                                img.setScaleX(1f);
                                img.setScaleY(1f);
                                img.setAlpha(1f);
                                Log.i(String.valueOf(context), "Inside runnable");

                            }

                        });
            }

        };
        adapter = new RecyclerAdapter(context , dm.get_notes());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                runnable.run();
                NoteModel nm = new NoteModel(Title.getText().toString() , Note.getText().toString() , -1);
                boolean x = dm.add_note(nm);
                adapter = new RecyclerAdapter(context , dm.get_notes());
                recyclerView.setAdapter(adapter);
                Log.i("Main" ,Boolean.toString(x));
                Title.setText("");
                Note.setText("");
            }
        });






    }




}