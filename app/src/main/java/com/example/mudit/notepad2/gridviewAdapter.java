package com.example.mudit.notepad2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Mudit on 26-01-2018.
 */

public class gridviewAdapter extends ArrayAdapter {
    public gridviewAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}
