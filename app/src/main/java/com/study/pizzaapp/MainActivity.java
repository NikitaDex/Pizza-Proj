package com.study.pizzaapp;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pizzaapp.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private boolean hasBeenClicked1 = false; // для отслеживания событий
    private boolean hasBeenClicked2 = false;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        TextView user_name = (TextView)findViewById(R.id.user_name);
        TextView user_phone = (TextView)findViewById(R.id.user_phone);
        Authorization user = Authorization.Load(getApplicationContext());
        if (user.haveName()) {
            user_name.setText(user.getName());
        } else {
            user_name.setText("ФИО");
        }
        if (user.havePhoneNumber()) {
            user_phone.setText(user.getPhoneNumber());
        } else {
            user_phone.setText("Номер телефона");
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void TelClick(View view) {
        Intent Telegram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/pizzayummy1"));
        startActivity(Telegram);
    }

    public void VkClick(View view) {
        Intent VK = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/public205502480"));
        startActivity(VK);
    }

    public void WebClick(View view) {
        Intent WEB = new Intent("com.study.pizzaapp.Enter_activity");
        startActivity(WEB); //  https://mail.ru/
    }



    public void carb_btn(View view) {
        Intent info = new Intent("com.study.pizzaapp.Carbonara");
        startActivity(info);

        // mDBHelper.insertUser("msdfokljsdf","12345678","Валерий Назаргулов","29.09.01");
        mDBHelper.getTitle();
        System.out.println(mDBHelper.getPrices());
    }

    public void chees_btn(View view) {
        Intent info = new Intent("com.study.pizzaapp.Chees_pizza");
        startActivity(info);
    }


    public void four_season_btn(View view) {
        Intent info = new Intent("com.study.pizzaapp.Four_season");
        startActivity(info);
    }

    public void fresh_btn(View view) {
        Intent info = new Intent("com.study.pizzaapp.Fresh_pizza");
        startActivity(info);
    }

    public void mash_btn(View view) {
        Intent info = new Intent("com.study.pizzaapp.Mashroom_pizza");
        startActivity(info);
    }

    public void basket_btn_bar(MenuItem item) {
        Intent Basket = new Intent("com.study.pizzaapp.BasketActivity");
        startActivity(Basket);
    }

    public void OnClickPromo1(View view){ // кнопка для появления текста акции 1
        TextView promo1 = findViewById(R.id.promo1_text1);
        ImageButton promo2_btn = findViewById(R.id.promo2_btn);
        ImageButton promo1_btn = findViewById(R.id.promo1_btn);


        if (!hasBeenClicked1){
            promo1.setVisibility(View.VISIBLE);
            hasBeenClicked1 =true;
            RelativeLayout.LayoutParams params =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, promo1.getId() );
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, promo1.getId() );
            promo2_btn.setLayoutParams(params);
        }
        else if (hasBeenClicked1){
            promo1.setVisibility(View.INVISIBLE);
            hasBeenClicked1 =false;
            RelativeLayout.LayoutParams params =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, promo1_btn.getId());
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, promo1_btn.getId() );
            promo2_btn.setLayoutParams(params);
        }
    }
    public void OnClickPromo2(View view){ // кнопка для появления текста акции 2
        TextView promo2 = findViewById(R.id.promo2_text1);
        if (!hasBeenClicked2){
            promo2.setVisibility(View.VISIBLE);
            hasBeenClicked2 =true;
        }
        else if (hasBeenClicked2){
            promo2.setVisibility(View.INVISIBLE);
            hasBeenClicked2 =false;
        }
    }



}