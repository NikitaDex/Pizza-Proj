package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Enter_activity extends AppCompatActivity {

    EditText mail;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        mail = (EditText)findViewById(R.id.username1);
        password = (EditText)findViewById(R.id.password1);
    }

    public void btn_reg(View view) {
        Intent Reg = new Intent("com.study.pizzaapp.RegisterWindow");
        startActivity(Reg);
    }


    public void enter_btn(View view) {
        Authorization user = Authorization.Load(getApplicationContext());
        //System.out.println(user.getMail() + " " + user.getPassword());
        if (mail.getText().toString().equals(user.getMail()) &
                password.getText().toString().equals(user.getPassword())) {
            Intent Enter = new Intent("com.study.pizzaapp.MainActivity");
            startActivity(Enter);
        }
    }
}