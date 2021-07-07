package com.study.pizzaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private static final String dbName="PizzaOneLove";
    private static final int dbVer=1;
    private static final String dbTable="Заказы";
    private static final String dbColumn="Стоимость";

    public DataBase(Context context) {
        super(context, dbName, null, dbVer);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s(ID INTEGER PRIMARY KEY AUTOINCREMENT, [Заказы] TEXT)",dbTable);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = String.format("DELETE TABLE IF EXISTS %s)",dbTable);
        db.execSQL(query);
        onCreate(db);
    }
    public void insertData(String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbColumn,price);
        db.insertWithOnConflict(dbTable,null,values,SQLiteDatabase.CONFLICT_REPLACE);

    }

    public void deleteData(String price){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(dbTable,dbColumn+" = ?", new String[]{price});
        db.close();
    }

    public ArrayList<String> getAllPrices(){
        ArrayList<String> prices=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(dbTable,new String[]{dbColumn},null,null,null,null,null);
        while (cursor.moveToNext()){
            int index=cursor.getColumnIndex(dbColumn);
            prices.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return prices;
    }
}
