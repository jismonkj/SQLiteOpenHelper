package com.ajce.blake.sqliteopenhelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ls;
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls = findViewById(R.id.listview);
        DBHelper db = new DBHelper(MainActivity.this);
        SQLiteDatabase sqliteDb = db.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put("name", "Jismon");
        if(db.insertData(cValues, sqliteDb)>=0)
        {
            Toast.makeText(this, "Sucessful", Toast.LENGTH_LONG).show();
        }

        list = db.viewData(sqliteDb);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ls.setAdapter(adapter);

    }
}
