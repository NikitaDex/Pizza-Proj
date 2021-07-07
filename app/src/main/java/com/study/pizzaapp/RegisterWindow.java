package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;


import java.io.IOException;

import static com.study.pizzaapp.R.layout.activity_register_window;

public class RegisterWindow extends AppCompatActivity {
    EditText mail;
    EditText pass;
    EditText repeatPass;
    EditText name;
    EditText birthday;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register_window);
        mail = (EditText)findViewById(R.id.mail_reg);
        pass = (EditText)findViewById(R.id.pass_reg);
        repeatPass = (EditText)findViewById(R.id.pass_reg_again);
        name = (EditText)findViewById(R.id.name_reg);
        birthday = (EditText)findViewById(R.id.wasBorn);


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
    }
    public boolean allFieldsFilled() {
        if (mail.getText().toString().length() != 0 &
                pass.getText().toString().length() != 0 &
                repeatPass.getText().toString().length() != 0 &
                name.getText().toString().length() != 0 &
                birthday.getText().toString().length() != 0) {
            return true;
        }
        return false;
    }
    public boolean rightPassword() {
        if (pass.getText().toString().equals(repeatPass.getText().toString())) {
            return true;
        }
        return false;
    }
    public void OnRegButtonClick(View view) {
        System.out.println(allFieldsFilled());
        System.out.println(rightPassword());
        if (allFieldsFilled() & rightPassword()) {

            //Добавление в базу данных
            mDBHelper.insertUser(mail.getText().toString(),pass.getText().toString(),name.getText().toString(),birthday.getText().toString());


            Authorization user = new Authorization(getApplicationContext(),
                    name.getText().toString(),
                    pass.getText().toString(),
                    mail.getText().toString(),
                    "-",
                    "-",
                    "-",
                    birthday.getText().toString(),
                    mDBHelper.getLastUserID());
            user.setAuthorization(true);
            user.Save();
            user = Authorization.Load(getApplicationContext());
            Intent MainActivity = new Intent("com.study.pizzaapp.ZakazActivity");
            startActivity(MainActivity);

        }
    }

    public void register_btn(View view) {
        Intent Enter = new Intent("com.study.pizzaapp.MainActivity");
        startActivity(Enter);

    }
}