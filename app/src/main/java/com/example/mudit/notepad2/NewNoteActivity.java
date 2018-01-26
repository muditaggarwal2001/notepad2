package com.example.mudit.notepad2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    private EditText title;
    private EditText note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        title = (EditText)findViewById(R.id.note_title);
        note= (EditText)findViewById(R.id.note_desc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu,menu);
        return true;
    }
}
