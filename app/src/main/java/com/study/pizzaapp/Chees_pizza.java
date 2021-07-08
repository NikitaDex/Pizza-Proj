package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chees_pizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chees_pizza);
    }

    public void carb_bask2(View view) {
        Intent info = new Intent("com.study.pizzaapp.BasketActivity");
        startActivity(info);
    }
}