package com.study.pizzaapp;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cupons#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cupons extends Fragment {

    private String[]name={"ghdjghfd","fgffdgd","vsdvv"}; // массив с купонами, код в криэйтвью

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cupons() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cupons.
     */
    // TODO: Rename and change types and number of parameters
    public static cupons newInstance(String param1, String param2) {
        cupons fragment = new cupons();
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

    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    ArrayAdapter<String> adapter;
    ListView orderList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDBHelper = new DBHelper(getContext().getApplicationContext());

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


        View rootView = inflater.inflate(R.layout.fragment_cupons, container, false); // это чтобы отображалось

        orderList = (ListView) rootView.findViewById(R.id.listView); // объявляем поле для списка


       //  new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,name); // в этом адаптере хранится массив


       // lvMain.setAdapter(adapter); // присваиваем списку массив

        // Inflate the layout for this fragment

        ArrayList<String> prices=mDBHelper.getCupons();

//        if(adapter==null){
//            adapter = new ArrayAdapter<>(getContext(),
//                    android.R.layout.simple_list_item_1, R.id.listView, prices);
//            orderList.setAdapter(adapter);
//        }else{
//            adapter.clear();
//            adapter.addAll(prices);
//            adapter.notifyDataSetChanged();
//        }
       // updateAdapter();

        return rootView;
    }
    public void updateAdapter(){



    }
}