package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;

public class ZakazActivity extends AppCompatActivity {

    String[] dostavka = {"доставка", "самовывоз"}; // массив для доставки
    String[] oplata = {"карта", "наличные"}; // массив для оплаты
     // массив для купонов
    public TextView result; // объявила переменную с результатом

    Spinner spinner3;
    //////////////////////////
    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz);

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

        Authorization user = Authorization.Load(getApplicationContext());
        address = (EditText) findViewById(R.id.address);
        if (user.haveAddress()) {
            address.setText(user.getAddress());
        }
        ArrayAdapter<String> DostavkaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dostavka); // адаптер, в котором хранится массив доставки
        DostavkaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1); // объявляем список
        spinner1.setAdapter(DostavkaAdapter); // присваиваем списку адаптер
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (spinner1.getSelectedItem().toString().equals("доставка")) {
                    result.setText(Integer.toString(BasketActivity.getResult() + 200));
                }
                else {
                    result.setText(Integer.toString(BasketActivity.getResult()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                if (spinner1.getSelectedItem().toString().equals("доставка")) {
                    result.setText(Integer.toString(BasketActivity.getResult() + 200));
                }
            }

        });

        ArrayAdapter<String> OplataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, oplata); // адаптер, в котором хранится массив оплаты
        OplataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2); // объявляем список
        spinner2.setAdapter(OplataAdapter); // присваиваем списку адаптер

        ArrayList<String> cupon=mDBHelper.getCupons();
        final String[] discount = {""};

        ArrayAdapter<String> CuponAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cupon); // адаптер, в котором хранится массив купонов
        CuponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3 = (Spinner) findViewById(R.id.spinner3); // объявляем список
        spinner3.setAdapter(CuponAdapter); // присваиваем списку адаптер
        spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (spinner3.getSelectedItem().toString().equals("Скидка 15%")) {
                    String res=result.getText().toString();
                    int a=Integer.valueOf(res);
                    a= (int) (a*(0.15));
                    result.setText(Integer.toString(BasketActivity.getResult()-a));

                }else if(spinner3.getSelectedItem().toString().equals("Скидка 20%")){
                    String res=result.getText().toString();
                    int a=Integer.valueOf(res);
                    a= (int) (a*(0.20));
                    result.setText(Integer.toString(BasketActivity.getResult()-a));

                }else if(spinner3.getSelectedItem().toString().equals("Скидка 100%")){
                    String res=result.getText().toString();
                    int a=Integer.valueOf(res);
                    result.setText("0");

                }else if(spinner3.getSelectedItem().toString().equals("Скидка 5%")) {
                    String res = result.getText().toString();
                    int a = Integer.valueOf(res);
                    a = (int) (a * (0.05));
                    result.setText(Integer.toString(BasketActivity.getResult() - a));

                }else if(spinner3.getSelectedItem().toString().equals("Скидка 10%")) {
                    String res = result.getText().toString();
                    int a = Integer.valueOf(res);
                    a = (int) (a * (0.10));
                    result.setText(Integer.toString(BasketActivity.getResult() - a));

                }else if (spinner3.getSelectedItem().toString().equals("Без купона")){
                    String res = result.getText().toString();
                    result.setText(Integer.toString(BasketActivity.getResult()));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });


        result = (TextView)findViewById(R.id.result);
        result.setText(Integer.toString(BasketActivity.getResult() + 200));


    }

    public void OnOformitClick(View view) {
        EditText time = (EditText) findViewById(R.id.time);
        if (time.getText().toString().length() !=0 &
                address.getText().toString().length() !=0) {
            Authorization user = Authorization.Load(getApplicationContext());
            if (!address.getText().toString().equals(user.getAddress())) {
                user.setAddress(address.getText().toString());
            }
            Intent Oformit = new Intent("com.study.pizzaapp.Orders");
            startActivity(Oformit);


            mDBHelper.insertOrder(result.getText().toString());
            mDBHelper.deleteCupons(spinner3.getSelectedItem().toString());
        }

    }



}