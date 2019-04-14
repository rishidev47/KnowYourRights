package com.example.knowyourrights;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PolicyAdapter extends ArrayAdapter<Policy> {

    public PolicyAdapter(Context context, ArrayList<Policy> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView!=null){
            Log.d(TAG, "getView: "+"convert");
            TextView name=(TextView) convertView;
            name.setText(((Policy)getItem(position)).name);
            return  name;
        }
        else {
            Log.d(TAG, "getView: "+"fresh");
            TextView name = (TextView) LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, null);
            name.setText(((Policy) getItem(position)).name);
            return  name;
        }
    }

}
