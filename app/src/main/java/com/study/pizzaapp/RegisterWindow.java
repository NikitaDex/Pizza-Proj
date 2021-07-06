package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.study.pizzaapp.R.layout.activity_register_window;

public class RegisterWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register_window);
    }

    public void register_btn(View view) {
        Intent Enter = new Intent("com.study.pizzaapp.MainActivity");
        startActivity(Enter);
    }
}