package com.example.mudit.notepad2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Mudit on 27-01-2018.
 */

public class DataAdapter extends CursorAdapter {

    public DataAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.notelayout, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id = view.findViewById(R.id.noteviewid);
        TextView title = view.findViewById(R.id.viewtitle);
        TextView shownote = view.findViewById(R.id.notetext);
        id.setText(cursor.getString(0));
        title.setText(cursor.getString(1));
        shownote.setText(cursor.getString(2));
    }
}
