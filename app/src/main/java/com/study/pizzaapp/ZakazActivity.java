package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ZakazActivity extends AppCompatActivity {

    String[] dostavka = {"доставка", "самовывоз"};
    String[] oplata = {"карта", "наличные"};
    String[] cupon = {"здесь подключат базу данных"};
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz);

        ArrayAdapter<String> DostavkaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dostavka);
        DostavkaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(DostavkaAdapter);

        ArrayAdapter<String> OplataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, oplata);
        OplataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(OplataAdapter);

        ArrayAdapter<String> CuponAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cupon);
        CuponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setAdapter(CuponAdapter);
        result = (TextView)findViewById(R.id.result);
        result.setText(Integer.toString(BasketActivity.getResult() + 200));

    }

    public void OnOformitClick(View view) {
        Intent Oformit = new Intent("com.study.pizzaapp.MainActivity");
        startActivity(Oformit);
    }
}