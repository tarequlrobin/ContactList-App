package com.tareqrobin.contactlist16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {

    private static String DBNAME="mydatabase";
    private static  int VERSION=1;

    public MyDB( Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table contact (id integer primary key autoincrement not null,name text,phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists contact");
        onCreate(db);
    }

    public  boolean insertData(String name, String phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("phone",phone);
        db.insert("contact",null,cv);
        return true;
    }
    public ArrayList<Model> getAllData(){
        ArrayList<Model> arrayList=new ArrayList<Model>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from contact",null);

        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            arrayList.add(new Model(cursor.getString(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("phone"))));
            cursor.moveToNext();
        }
        return arrayList;
    }
}