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

public class ZakazActivity extends AppCompatActivity {

    String[] dostavka = {"доставка", "самовывоз"}; // массив для доставки
    String[] oplata = {"карта", "наличные"}; // массив для оплаты
    String[] cupon = {"здесь подключат базу данных"}; // массив для купонов
    public TextView result; // объявила переменную с результатом

    //////////////////////////
    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz);

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
                // your code here
            }

        });

        ArrayAdapter<String> OplataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, oplata); // адаптер, в котором хранится массив оплаты
        OplataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2); // объявляем список
        spinner2.setAdapter(OplataAdapter); // присваиваем списку адаптер

        ArrayAdapter<String> CuponAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cupon); // адаптер, в котором хранится массив купонов
        CuponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3); // объявляем список
        spinner3.setAdapter(CuponAdapter); // присваиваем списку адаптер
        result = (TextView)findViewById(R.id.result);
        result.setText(Integer.toString(BasketActivity.getResult() + 200));


//        order_btn=findViewById(R.id.btn_oformit);
//        order_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


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
        }

    }



}