package com.example.knowyourrights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class PolicyDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_display);

        Intent i=getIntent();
        final String cat=i.getStringExtra("CAT");
        final String pol=i.getStringExtra("POL");
        dbHelper databaseHelper =new dbHelper(getApplicationContext());
        final Policy policy =databaseHelper.findPolicyByName(pol);
        Log.d("TAG", "onCreate: "+policy);

    }
}
