package com.kartik.date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdetails(name text primary key, email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Userdetails");
    }
    public boolean insertUserData(String name, String mail, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name);
        contentValues.put("email" , mail);
        contentValues.put("password" , password);
        long result = db.insert("Userdetails", null , contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

//    public boolean checkLogin(String mail, String pass){
//
//    }
}