package com.example.todoapplication;

public class NoteModel {
    private String note;
    private String title;
    private int id;

    public NoteModel(String title , String note, int id){
        this.title = title;
        this.note = note;
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
