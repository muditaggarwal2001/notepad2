package com.example.mudit.notepad2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by Mudit on 27-01-2018.
 */

public class gridviewAdapter extends SimpleCursorAdapter {
    private Context maincontext;
    private int mlayout;
    private int[] mto;
    private String[] mfrom;
    public gridviewAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        maincontext = context;
        mlayout=layout;
        mto=to;
        mfrom=from;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(maincontext).inflate(mlayout,null);
        }
        Cursor c = getCursor();
        c.moveToPosition(position);
        if(c.moveToNext())
        {
            TextView id = convertView.findViewById(R.id.noteviewid);
            TextView title = convertView.findViewById(R.id.viewtitle);
            TextView shownote = convertView.findViewById(R.id.notetext);
            id.setText(c.getString(c.getColumnIndex(mfrom[0])));
            title.setText(c.getString(c.getColumnIndex(mfrom[1])));
            shownote.setText(c.getString(c.getColumnIndex(mfrom[2])));
        }
        return convertView;
    }
}
