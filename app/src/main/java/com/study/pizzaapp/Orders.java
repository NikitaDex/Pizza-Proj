package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;


public class Orders extends AppCompatActivity {

    ListView orderList;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

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

        orderList=(ListView)findViewById(R.id.order_list);

        updateAdapter();
    }


    ArrayAdapter<String> adapter;
    public void updateAdapter(){
        ArrayList<String> prices=mDBHelper.getPrices();

        if(adapter==null){
            adapter = new ArrayAdapter<>(this,
                    R.layout.row, R.id.txt_price, prices);
            orderList.setAdapter(adapter);
        }else{
            adapter.clear();
            adapter.addAll(prices);
            adapter.notifyDataSetChanged();
        }

    }

    public void deleteTask(View view){
        TextView txt_id=(TextView)findViewById(R.id.txt_price);
        String price=String.valueOf(txt_id.getText());
        mDBHelper.deleteOrder(price);

        updateAdapter();

    }

}