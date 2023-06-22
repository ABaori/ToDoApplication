package com.example.todoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseModel extends SQLiteOpenHelper {
    public static final String NOTE = "NOTE";
    public static final String NOTES_TABLE = "NOTES_TABLE";
    public static final String ID = "ID";
    public static final String TITLE = "TITLE";
    protected String TAG = "DatabaseModel";

    public DatabaseModel(@Nullable Context context) {
        super(context, "ToDo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strquery = "CREATE TABLE " + NOTES_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + TITLE + " TEXT , " + NOTE + " TEXT)";
        db.execSQL(strquery);
        Log.i(TAG, "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean add_note(NoteModel nm) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITLE, nm.getTitle());
        cv.put(NOTE, nm.getNote());
        long insert = db.insert(NOTES_TABLE, null, cv);
        return insert != -1;
    }
    @NonNull
    public ArrayList<NoteModel> get_notes() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<NoteModel> returnList = new ArrayList<>();

        String strquery = "SELECT * FROM " + NOTES_TABLE;
        Cursor cursor = db.rawQuery(strquery, null);

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(1);
                String note = cursor.getString(2);
                int id = cursor.getInt(0);
                NoteModel nm = new NoteModel(title, note, id);
                returnList.add(nm);
            } while (cursor.moveToNext());


        }else{

        }
        cursor.close();
        return returnList;
    }
}
