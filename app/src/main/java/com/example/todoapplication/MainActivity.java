package com.example.todoapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    Button button;
    EditText Title, Note;
    Context context = MainActivity.this;
    RecyclerViewInterface recyclerViewInterface;

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

                img.animate().scaleX(3f).scaleY(3f).alpha(0f).setDuration(800);
                img.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        img.setScaleX(1f);
                        img.setScaleY(1f);
                        img.setAlpha(1f);
                    }
                }, 1010);
            }

        };
        adapter = new RecyclerAdapter(context, dm.get_notes() , recyclerViewInterface);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable.run();
                if (!Title.getText().toString().equals("") && !Note.getText().toString().equals("")) {
                    NoteModel nm = new NoteModel(Title.getText().toString(), Note.getText().toString(), -1);
                    boolean x = dm.add_note(nm);
                    adapter = new RecyclerAdapter(context, dm.get_notes(), recyclerViewInterface);
                    recyclerView.setAdapter(adapter);
                    Log.i("Main", Boolean.toString(x));
                    Title.setText("");
                    Note.setText("");
                }
            }
        });




    }


    @Override
    public void onItemClick(int position) {
        DatabaseModel db = new DatabaseModel(context);
        db.get_notes().remove(position);
    }
}

