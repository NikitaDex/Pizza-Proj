package com.study.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BasketActivity extends AppCompatActivity {

   private int num1=0;
    private int num2=0;
    private int num3=0;
    private int num4=0;
    private int num5=0;
   private int sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

    }

    public void OnBthClick1(View view){
        EditText editText1 = (EditText)findViewById(R.id.editText1); // здесь обавляем поле с кол-вом
        TextView result = (TextView)findViewById(R.id.result); // здесь объявляем поле результата
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
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        TextView result = (TextView)findViewById(R.id.result);
        num1 = Integer.parseInt(editText1.getText().toString());
        num1+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText1.setText(Integer.toString(num1));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick3(View view){
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        TextView result = (TextView)findViewById(R.id.result);
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
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        TextView result = (TextView)findViewById(R.id.result);
        num2 = Integer.parseInt(editText2.getText().toString());
        num2+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText2.setText(Integer.toString(num2));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick5(View view){
        EditText editText3 = (EditText)findViewById(R.id.editText3);
        TextView result = (TextView)findViewById(R.id.result);
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
        EditText editText3 = (EditText)findViewById(R.id.editText3);
        TextView result = (TextView)findViewById(R.id.result);
        num3 = Integer.parseInt(editText3.getText().toString());
        num3+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText3.setText(Integer.toString(num3));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick7(View view){
        EditText editText4 = (EditText)findViewById(R.id.editText4);
        TextView result = (TextView)findViewById(R.id.result);
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
        EditText editText4 = (EditText)findViewById(R.id.editText4);
        TextView result = (TextView)findViewById(R.id.result);
        num4 = Integer.parseInt(editText4.getText().toString());
        num4+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText4.setText(Integer.toString(num4));
        result.setText(Integer.toString(sum));
    }
    public void OnBthClick9(View view){
        EditText editText5 = (EditText)findViewById(R.id.editText5);
        TextView result = (TextView)findViewById(R.id.result);
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
        EditText editText5 = (EditText)findViewById(R.id.editText5);
        TextView result = (TextView)findViewById(R.id.result);
        num5 = Integer.parseInt(editText5.getText().toString());
        num5+=1;
        sum=(num1*480)+(num2*580)+(num3*520)+(num4*545)+(num5*520);
        editText5.setText(Integer.toString(num5));
        result.setText(Integer.toString(sum));
    }
}