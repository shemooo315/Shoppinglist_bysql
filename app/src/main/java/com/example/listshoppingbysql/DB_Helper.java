package com.example.listshoppingbysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Blob;

public class DB_Helper extends SQLiteOpenHelper {
    private static String databaseName="Shopping_itemsDatabase";
    SQLiteDatabase Shopping_itemsDatabase;
    public DB_Helper(Context context){

        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Categories(Name text primary key ,Price text not null,Description text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Categories");
        onCreate(db);
    }
    public void AddingItems(String name, String price, String description){

        ContentValues row=new ContentValues();
        row.put("Name",name);
        row.put("Price",price);
        row.put("Description",description);
        Shopping_itemsDatabase=getWritableDatabase();
        Shopping_itemsDatabase.insert("Categories",null,row);
        Shopping_itemsDatabase.close();

    }
    public Cursor Get_all_Categories(){

        Shopping_itemsDatabase = getReadableDatabase();
        Cursor cursor;
        String[] row_details={"Name","Price","Description"};
        cursor=Shopping_itemsDatabase.query("Categories",row_details,null,null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        Shopping_itemsDatabase.close();

        return cursor;

    }
}
