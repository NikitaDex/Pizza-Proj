package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BasketActivity extends AppCompatActivity {

    private int num1=0;
    private int num2=0;
    private int num3=0;
    private int num4=0;
    private int num5=0;
    private static int sum;

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;

    private static TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        result = (TextView)findViewById(R.id.result); // здесь объявляем поле результата

        editText1 = (EditText)findViewById(R.id.editText1); // здесь обавляем поле с кол-вом
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
                public void afterTextChanged(Editable s) {

                try {
                    num1 = Integer.parseInt(editText1.getText().toString());
                }catch (Exception e){
                    num1=0;
                    editText1.setText(Integer.toString(num1));
                }
                sum = (num1 * 480) + (num2 * 580) + (num3 * 520) + (num4 * 545) + (num5 * 520);
                result = (TextView)findViewById(R.id.result);
                result.setText(Integer.toString(sum));
                }
        });
        editText2 = (EditText)findViewById(R.id.editText2); // здесь обавляем поле с кол-вом
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    num2 = Integer.parseInt(editText2.getText().toString());
                }catch (Exception e){
                    num2=0;
                    editText2.setText(Integer.toString(num2));
                }
                sum = (num1 * 480) + (num2 * 580) + (num3 * 520) + (num4 * 545) + (num5 * 520);
                result = (TextView)findViewById(R.id.result);
                result.setText(Integer.toString(sum));
            }
        });
        editText3 = (EditText)findViewById(R.id.editText3); // здесь обавляем поле с кол-вом
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    num3 = Integer.parseInt(editText3.getText().toString());
                }catch (Exception e){
                    num3=0;
                    editText3.setText(Integer.toString(num3));
                }
                sum = (num1 * 480) + (num2 * 580) + (num3 * 520) + (num4 * 545) + (num5 * 520);
                result = (TextView)findViewById(R.id.result);
                result.setText(Integer.toString(sum));
            }
        });
        editText4 = (EditText)findViewById(R.id.editText4); // здесь обавляем поле с кол-вом
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    num4 = Integer.parseInt(editText4.getText().toString());
                }catch (Exception e){
                    num4=0;
                    editText4.setText(Integer.toString(num4));
                }
                sum = (num1 * 480) + (num2 * 580) + (num3 * 520) + (num4 * 545) + (num5 * 520);
                result = (TextView)findViewById(R.id.result);
                result.setText(Integer.toString(sum));
            }
        });
        editText5 = (EditText)findViewById(R.id.editText5); // здесь обавляем поле с кол-вом
        editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    num5 = Integer.parseInt(editText5.getText().toString());
                }catch (Exception e){
                    num5=0;
                    editText5.setText(Integer.toString(num5));
                }
                sum = (num1 * 480) + (num2 * 580) + (num3 * 520) + (num4 * 545) + (num5 * 520);
                result = (TextView)findViewById(R.id.result);
                result.setText(Integer.toString(sum));
            }
        });
    }
    public static int getResult() {
        return sum;
    }

    public void OnBthClick1(View view){
        num1 = Integer.parseInt(editText1.getText().toString()); // получаем значение кол-ва
        num1-=1; // если нажмут на кнопку, то вычтется значение
        if (num1==-1){ // чтобы в минус не ушли
            num1=0;
        }
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520); // считаем сумму
        editText1.setText(Integer.toString(num1)); // выводим кол-во
        result.setText(Integer.toString(sum)); // выводим сумму

    }
    public void OnBthClick2(View view){
        num1 = Integer.parseInt(editText1.getText().toString());
        num1+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText1.setText(Integer.toString(num1));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick3(View view){
        num2 = Integer.parseInt(editText2.getText().toString());
        num2-=1;
        if (num2==-1){
            num2=0;
        }
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText2.setText(Integer.toString(num2));
        result.setText(Integer.toString(sum));

    }
    public void OnBthClick4(View view){
        num2 = Integer.parseInt(editText2.getText().toString());
        num2+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText2.setText(Integer.toString(num2));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick5(View view){
        num3 = Integer.parseInt(editText3.getText().toString());
        num3-=1;
        if (num3==-1){
            num3=0;
        }
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText3.setText(Integer.toString(num3));
        result.setText(Integer.toString(sum));

    }
    public void OnBthClick6(View view){
        num3 = Integer.parseInt(editText3.getText().toString());
        num3+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText3.setText(Integer.toString(num3));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick7(View view){
        num4 = Integer.parseInt(editText4.getText().toString());
        num4-=1;
        if (num4==-1){
            num4=0;
        }
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText4.setText(Integer.toString(num4));
        result.setText(Integer.toString(sum));

    }
    public void OnBthClick8(View view){
        num4 = Integer.parseInt(editText4.getText().toString());
        num4+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText4.setText(Integer.toString(num4));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick9(View view){
        num5 = Integer.parseInt(editText5.getText().toString());
        num5-=1;
        if (num5==-1){
            num5=0;
        }
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText5.setText(Integer.toString(num5));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick10(View view){
        num5 = Integer.parseInt(editText5.getText().toString());
        num5+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText5.setText(Integer.toString(num5));
        result.setText(Integer.toString(sum));
    }

    public void OnOformitClick(View view) {
        Intent Oformit = new Intent("com.study.pizzaapp.ZakazActivity");
        startActivity(Oformit);
    }
}