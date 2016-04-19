package com.example.a.t10_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by a on 2016-04-19.
 */
public class TestSqliteHandler {
    TestSQLiteOpenHelper helper;
    SQLiteDatabase db;

    public TestSqliteHandler(Context context){
        helper = new TestSQLiteOpenHelper(context, "people", null, 1);
    }

    public void insert(String name, int age, String address){
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        db.insert("student", null, values);
    }

    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("student", "name = ?", new String[]{name});
    }

    public void update(String name, int newAge){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", newAge);

        db.update("student", values, "name = ?", new String[]{name});
    }

    public void selsctAll(){
        db = helper.getWritableDatabase();
        Cursor c = db.query("student", )
    }
}
