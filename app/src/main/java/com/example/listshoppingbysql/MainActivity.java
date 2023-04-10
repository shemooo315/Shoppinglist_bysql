package com.example.listshoppingbysql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    sectionadapter section_adapter;
    ArrayList<datasectionmodel> info;
    DB_Helper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=new DB_Helper(this);

        listView=findViewById(R.id.list_categories);
        info=new ArrayList<>();

/*
        info.add(new datasectionmodel("Bags",R.drawable.bags,"$200.00","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Berfums",R.drawable.berfums,"$500.00","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Blovars",R.drawable.blovars,"$207.99","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Dresses",R.drawable.dresses,"$600.08","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Eats",R.drawable.vegata,"$245.09","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Heels",R.drawable.heels,"$444.85","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Bags",R.drawable.bags,"$200.00","Suitable for age groups lycra material"));
        info.add(new datasectionmodel("Berfums",R.drawable.berfums,"$500.00","Suitable for age groups lycra material"));
*/

        obj.AddingItems("Bags","$200.00","Suitable for age groups lycra material");
        obj.AddingItems("Berfums","$500.00","Suitable for age groups lycra material");
        obj.AddingItems("Blovars","$207.99","Suitable for age groups lycra material");
        obj.AddingItems("Dresses","$600.08","Suitable for age groups lycra material");
        obj.AddingItems("Eats","$245.09","Suitable for age groups lycra material");
        obj.AddingItems("Heels","$444.85","Suitable for age groups lycra material");

        Cursor cursor=obj.Get_all_Categories();
        while (!cursor.isAfterLast()){

            info.add(new datasectionmodel(cursor.getString(0),R.drawable.bags,cursor.getString(1),cursor.getString(2)));
            cursor.moveToNext();

        }


        section_adapter= new sectionadapter(MainActivity.this,info);
        listView.setAdapter(section_adapter);

    }
}