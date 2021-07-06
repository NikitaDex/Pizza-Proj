package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Enter_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void btn_reg(View view) {
        Intent Reg = new Intent("com.study.pizzaapp.RegisterWindow");
        startActivity(Reg);
    }


    public void enter_btn(View view) {
        Intent Enter = new Intent("com.study.pizzaapp.MainActivity");
        startActivity(Enter);
    }
}