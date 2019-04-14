package com.example.knowyourrights;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "POLICY_DATABASE";
    private static final String TABLE_POLICIES = "Policies";
    private static final String POLICY_NAME = "name";
    private static final String POLICY_CATEGORY = "category";
    private static final String POLICY_ELIGIBILITY = "eligibility";
    private static final String POLICY_DISCRIPTION = "discription";
    private static final String POLICY_LINK = "link";


    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POLICY_TABLE = "CREATE TABLE " + TABLE_POLICIES + "(" + POLICY_NAME + " TEXT," + POLICY_CATEGORY + " TEXT," + POLICY_ELIGIBILITY + " TEXT," + POLICY_LINK + " TEXT," + POLICY_DISCRIPTION +" TEXT "+ ")";
        db.execSQL(CREATE_POLICY_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLICIES);
        onCreate(db);
    }

    public ArrayList<Policy> findPolicyForCategory(String category){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Policy>list =new ArrayList<>();

        Cursor cursor = db.query(TABLE_POLICIES, null, POLICY_CATEGORY + "=?",
                new String[] { category }, null, null, null, null);
        cursor.moveToFirst();
        while (cursor != null) {
                Policy policy = new Policy(cursor.getString(cursor.getColumnIndex(POLICY_NAME)), cursor.getString(cursor.getColumnIndex(POLICY_CATEGORY)), cursor.getString(cursor.getColumnIndex(POLICY_ELIGIBILITY)), cursor.getString(cursor.getColumnIndex(POLICY_DISCRIPTION)), cursor.getString(cursor.getColumnIndex(POLICY_LINK)));
                list.add(policy);
                if(!cursor.moveToNext())break;

        }
        cursor.close();
        db.close();
        return list;
    }

    public Policy findPolicyByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_POLICIES, null, POLICY_NAME + "=?",
                new String[] { name }, null, null, null, null);
        cursor.moveToFirst();
                Policy policy = new Policy(cursor.getString(cursor.getColumnIndex(POLICY_NAME)), cursor.getString(cursor.getColumnIndex(POLICY_CATEGORY)), cursor.getString(cursor.getColumnIndex(POLICY_ELIGIBILITY)), cursor.getString(cursor.getColumnIndex(POLICY_DISCRIPTION)), cursor.getString(cursor.getColumnIndex(POLICY_LINK)));
                cursor.close();
                db.close();
                return policy;
    }

    void addPolicy(Policy policy) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(POLICY_NAME, policy.name);
        values.put(POLICY_CATEGORY, policy.category);
        values.put(POLICY_ELIGIBILITY,policy.eligibility);
        values.put(POLICY_DISCRIPTION,policy.discription);
        values.put(POLICY_LINK,policy.link);

        // Inserting Row
        db.insert(TABLE_POLICIES, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

}
