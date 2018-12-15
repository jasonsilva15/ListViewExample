package com.example.service_admin.listviewexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String itemTableName = "Items";
    private String columnId="Id";
    private String columnName="Name";
    private String columnDescription="Description";



    public DatabaseHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //segundo paso
        try{
            CreateItemTable(db);

    }catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       //Cuarto paso
        try{
           dropItemTable(db);
           onCreate(db);

        }catch (Exception e){
            throw e;
        }

    }

    //Primer paso
    public void CreateItemTable(SQLiteDatabase db){
        String createTable= "CREATE TABLE "+ itemTableName + "( "
                            + columnId + " INTEGER PRIMARY KEY, "
                            + columnName + " TEXT, "
                            + columnDescription + " TEXT"
                            + ")";
        db.execSQL(createTable);
    }

    //Tercer paso
    public void dropItemTable (SQLiteDatabase db){
        String dropTable = " DROP TABLE IF EXISTS " + itemTableName;
        db.execSQL(dropTable);
    }

    //quinto paso
    public List<Item> getItemList(){

        String query ="SELECT * FROM "+ itemTableName;
        Cursor cursor = getReadableDatabase().rawQuery(query,null, null);

        List<Item> items = new ArrayList<>();
        while (cursor.moveToNext()){
            Item item   = new Item();
            item.setName(cursor.getString(1));
            item.setDescription(cursor.getString(2));
            items.add(item);
        }
        return items;
    }

    //Sexto paso

    public void addItem(Item item){
        ContentValues values = new ContentValues();
        values.put(columnName,item.name);
        values.put(columnDescription,item.description);
        getWritableDatabase().insert(itemTableName,null,values);
        getWritableDatabase().close();

        getItemList();

    }


}
