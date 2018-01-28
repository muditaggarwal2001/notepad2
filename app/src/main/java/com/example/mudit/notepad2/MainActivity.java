package com.example.mudit.notepad2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView ;
    private DBHelperClass dbHelperClass;
    private Cursor result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.main_listview);
        dbHelperClass = new DBHelperClass(this);
        dbHelperClass.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        MenuItem nNote = (MenuItem)findViewById(R.id.new_note);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_note:
                startActivity(new Intent(MainActivity.this,NewNoteActivity.class));
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        result=dbHelperClass.getData();
        ArrayList buffer = new ArrayList<String>();
        if(result.moveToNext())
        {   startManagingCursor(result);
            String[] from = {DBHelperClass.title, DBHelperClass.note};
            int[] to = {R.id.viewtitle, R.id.notetext};
            SimpleCursorAdapter mainActivitynote = new SimpleCursorAdapter(getApplicationContext(),R.layout.notelayout , result, from,to,0);
                    // DataAdapter(this,result,0);
                    //SimpleCursorAdapter(this,R.layout.notelayout , result, from,to,0);
               /*if(result.moveToNext()) {
                do {
                    buffer.add(result.getString(1) + "\n" + result.getString(2));
                } while (result.moveToNext());
                ArrayAdapter mainActivitynote = new ArrayAdapter(getApplicationContext(), R.layout.notelayout);
                */
               listView.setAdapter(mainActivitynote);

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperClass.close();
    }
}
