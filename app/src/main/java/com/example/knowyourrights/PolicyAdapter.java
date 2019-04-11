package com.example.knowyourrights;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PolicyAdapter extends ArrayAdapter<Policy> {

    public PolicyAdapter(Context context, ArrayList<Policy> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView name = (TextView) LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1,parent);
        name.setText(((Policy)getItem(position)).name);
        return  name;
    }

}
