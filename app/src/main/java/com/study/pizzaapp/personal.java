package com.study.pizzaapp;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.ContextWrapper;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link personal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class personal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public personal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment personal.
     */
    // TODO: Rename and change types and number of parameters
    public static personal newInstance(String param1, String param2) {
        personal fragment = new personal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView personalName, pesonalBirthday;
    EditText address, email, number, card;
    Button saveChange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_personal, container, false); // это чтобы отображалось

        personalName = (TextView) rootView.findViewById(R.id.personalName); // объявляем поле для списка
        pesonalBirthday = (TextView) rootView.findViewById(R.id.pesonalBirthday);
        address=(EditText)rootView.findViewById(R.id.address);
        email=(EditText)rootView.findViewById(R.id.EmailAddress);
        number=(EditText)rootView.findViewById(R.id.Number);
        card=(EditText)rootView.findViewById(R.id.card);
        saveChange = (Button)rootView.findViewById(R.id.save_changes);
        Authorization user = Authorization.Load(getContext().getApplicationContext());
        personalName.setText(user.getName());
        pesonalBirthday.setText(user.getBirthday());
        if (user.haveAddress()) {
            address.setText(user.getAddress());
        }
        email.setText(user.getMail());
        if (user.havePhoneNumber()) {
            number.setText(user.getPhoneNumber());
        }
        if (user.haveCardNumber()) {
            card.setText(user.getCardNumber());
        }
        saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Authorization user = Authorization.Load(getContext().getApplicationContext());
                if (address.getText().toString().length() != 0) {
                    user.setAddress(address.getText().toString());
                }
                if (email.getText().toString().length() != 0) {
                    user.setMail(email.getText().toString());
                }
                if (number.getText().toString().length() != 0) {
                    user.setPhoneNumber(number.getText().toString());
                }
                if (card.getText().toString().length() != 0) {
                    user.setCardNumber(card.getText().toString());
                }
            }
        });
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,name); // в этом адаптере хранится массив

        //lvMain.setAdapter(adapter); // присваиваем списку массив

        // Inflate the layout for this fragment
        return rootView;
    }
    /*
    public void onSaveChangesClick(View view) {
        Authorization user = Authorization.Load(getContext().getApplicationContext());
        if (address.getText().toString().length() != 0) {
            user.setAddress(address.getText().toString());
        }
        if (email.getText().toString().length() != 0) {
            user.setMail(email.getText().toString());
        }
        if (number.getText().toString().length() != 0) {
            user.setPhoneNumber(number.getText().toString());
        }
        if (card.getText().toString().length() != 0) {
            user.setCardNumber(card.getText().toString());
        }
        Intent Oformit = new Intent("com.study.pizzaapp.MainActivity");
        startActivity(Oformit);
    }*/
}