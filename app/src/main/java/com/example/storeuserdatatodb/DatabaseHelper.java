package com.example.storeuserdatatodb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String dbname,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(name varchar(20),phone varchar(10),location varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        onCreate(db);
    }

    //to save data
    public long saveNewUserData(String name,String phone,String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("location",location);

        long reacordid = db.insert("users",null,cv);

        return reacordid;
    }

    //view all data
    public String getAllRecords(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users",null);
        String output = "";
        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            String phone = cursor.getString(1);
            String location = cursor.getString(2);
            output = output + name +"-"+phone+"-"+location+"\n";
        }
        return output;
    }
}
