package com.example.mudit.notepad2;

/**
 * Created by Mudit on 26-01-2018.
 */

public class Note {
    private int ID;
    private String Title;
    private String note;
    private String pics;

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getNote() {
        return note;
    }

    public String getPics() {
        return pics;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

