package com.t127.lab_6_lists;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends ArrayAdapter<Item> {

    private ArrayList<Item> dataSet;
    Context context;

    public ItemsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.dataSet = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inf = LayoutInflater.from(context);
            convertView = inf.inflate(R.layout.row_layout,parent,false);
        }

        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView note = convertView.findViewById(R.id.txtNote);

        Item i = dataSet.get(position);
        title.setText(i.getTitle());
        note.setText(i.getNote());

        return convertView;

    }
}
