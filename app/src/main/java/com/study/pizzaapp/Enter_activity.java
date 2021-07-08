package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class Enter_activity extends AppCompatActivity {

    EditText mail;
    EditText password;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Authorization user = Authorization.Load(getApplicationContext());
        if (!user.isAuthorized()) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_enter);
            mail = (EditText) findViewById(R.id.username1);
            password = (EditText) findViewById(R.id.password1);


            mDBHelper = new DBHelper(this);

            try {
                mDBHelper.updateDataBase();
            } catch (IOException mIOException) {
                throw new Error("UnableToUpdateDatabase");
            }

            try {
                mDb = mDBHelper.getWritableDatabase();
            } catch (SQLException mSQLException) {
                throw mSQLException;
            }
        } else {
            Intent Main = new Intent("com.study.pizzaapp.MainActivity");
            startActivity(Main);
        }
    }

    public void btn_reg(View view) {
        Intent Reg = new Intent("com.study.pizzaapp.RegisterWindow");
        startActivity(Reg);
    }


    public void enter_btn(View view) {
        Authorization user = Authorization.Load(getApplicationContext());
        user.printData();
        //System.out.println(user.getMail() + " " + user.getPassword());
        if (mail.getText().toString().equals(user.getMail()) &
                password.getText().toString().equals(user.getPassword())) {
            user.setAuthorization(true);
            user.Save();
            Intent Enter = new Intent("com.study.pizzaapp.MainActivity");
            startActivity(Enter);
        }
    }
}