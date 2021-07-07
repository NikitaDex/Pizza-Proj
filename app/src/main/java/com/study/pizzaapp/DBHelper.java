package com.study.pizzaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "Пиццерия.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 7;

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private boolean mNeedUpdate = false;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }
    private void copyDBFile() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }
//Метод, выводящий таблицу с пользователями в консоль
    public void getTitle(){
        String title="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query("Пользователи",new String[]{"*"},null,null,null,null,null);
        //cursor.moveToFirst();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int index=cursor.getColumnIndex("ID");
            title+=cursor.getString(index)+"\n";

            System.out.print(cursor.getString(index)+" ");

            index = cursor.getColumnIndex("ФИО");
            System.out.print(cursor.getString(index)+" ");
            index = cursor.getColumnIndex("Дата");
            System.out.print(cursor.getString(index)+" ");
            index = cursor.getColumnIndex("Адрес");
            System.out.print(cursor.getString(index)+" ");
            index = cursor.getColumnIndex("Почта");
            System.out.print(cursor.getString(index)+" ");
            index = cursor.getColumnIndex("Телефон");
            System.out.print(cursor.getString(index)+" ");
            index = cursor.getColumnIndex("Карта");
            System.out.print(cursor.getString(index)+" ");
            index = cursor.getColumnIndex("Пароль");
            System.out.println(cursor.getString(index)+" ");

            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        //return title;
    }

    public void insertUser(String mail, String pass, String name, String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Почта",mail);
        cv.put("Пароль",pass);
        cv.put("ФИО",name);
        cv.put("Дата",date);

        cv.put("Телефон","-");
        cv.put("Адрес","-");
        cv.put("Карта","-");
        db.insertWithOnConflict("Пользователи",null,cv,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
    public void updateUser(String ID, String mail, String phone, String address, String card){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Почта",mail);
        cv.put("Телефон",phone);
        cv.put("Адрес",address);
        cv.put("Карта",card);
        db.updateWithOnConflict("Пользователи",cv,"ID="+ID,null,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

//    public ArrayList<String> getMail(){
//        ArrayList<String> arrayList;
//
//
//        return arrayList;
//    }


    public String getLastUserID(){
        String lastID="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query("Пользователи",new String[]{"ID"},null,null,null,null,null);
        cursor.moveToFirst();
        int index=cursor.getColumnIndex("ID");
        lastID=cursor.getString(index);
        return lastID;
    }
}





