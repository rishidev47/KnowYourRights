package com.example.knowyourrights;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_POLICIES = "Policies";
    private static final String POLICY_NAME = "name";
    private static final String POLICY_CATEGORY = "category";
    private static final String POLICY_ELIGIBILITY = "eligibility";
    private static final String POLICY_DISCRIPTION = "discription";
    private static final String POLICY_LINK = "link";


    public dbHelper(Context context) {
        super(context, "name", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POLICY_TABLE = "CREATE TABLE " + TABLE_POLICIES + "(" + "ID" + " INTEGER PRIMARY KEY," + POLICY_NAME + " TEXT," + POLICY_CATEGORY + " TEXT," + POLICY_ELIGIBILITY + " TEXT," + POLICY_LINK + " TEXT," + POLICY_DISCRIPTION +" TEXT "+ ")";
        db.execSQL(CREATE_POLICY_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLICIES);
        onCreate(db);
    }

    public Policy findPolicyForCategory(String category){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_POLICIES, new String[] { POLICY_CATEGORY,
                        }, POLICY_CATEGORY + "=?",
                new String[] { category }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Policy policy = new Policy(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        return policy;
    }

}
