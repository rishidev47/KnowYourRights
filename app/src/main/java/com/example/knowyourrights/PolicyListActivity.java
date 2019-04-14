package com.example.knowyourrights;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PolicyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_list);

        Intent i=getIntent();
        final String cat=i.getStringExtra("CAT");
        dbHelper databaseHelper =new dbHelper(getApplicationContext());
        final ArrayList<Policy> list = databaseHelper.findPolicyForCategory(cat);
        ListView policy_list =findViewById(R.id.policy_list);
        PolicyAdapter adapter=new PolicyAdapter(this,list);
        policy_list.setAdapter(adapter);

        policy_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i= new Intent(PolicyListActivity.this,PolicyDisplayActivity.class);
                i.putExtra("CAT",""+cat);
                i.putExtra("POL",list.get(position).name);
                startActivity(i);
            }
        });

    }
}
