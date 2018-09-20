package com.t127.lab_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonDot,
            buttonPlus, buttonDiv, buttonMinus,buttonPorc,buttonEqual,buttonC;

    float valueOne, valueTwo;

    enum Opperatiion{
        none,plus,minus,mult,div
    }
    Opperatiion op = Opperatiion.none;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =findViewById(R.id.textView);
        button0 = findViewById(R.id.buttonZero);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPlus = findViewById(R.id.buttonplus);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMinus = findViewById(R.id.buttonminous);
        buttonPorc = findViewById(R.id.buttonPorce);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonC = findViewById(R.id.buttomC);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPorc.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonC.setOnClickListener(this);


        buttonC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv.setText("0");
                op =Opperatiion.none;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op!=Opperatiion.none){
                    valueTwo =Float.parseFloat(tv.getText().toString());
                    valueOne = calculate();
                    tv.setText(valueOne + " ");
                }

            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op!=Opperatiion.none){
                    valueTwo =Float.parseFloat(tv.getText().toString());
                    valueOne = calculate();
                }else{
                    valueOne =Float.parseFloat(tv.getText().toString());
                }
                op = Opperatiion.plus;
                tv.setText("0");
            }
        });

    }

    private float calculate(){
        switch (op){
            case plus: return valueOne+valueTwo;
            case minus: return valueOne-valueTwo;
            case mult:return valueOne* valueTwo;
            case div: if (valueTwo!=0){
                return valueOne/valueTwo;
            }else{
                return Float.NaN;
            }
        }
    }
    @Override
    public void onClick(View v) {
        Button b =(Button)v;

        if(tv.getText().toString().equals("o") && b.getId() != R.id.buttonDot)
        {
            tv.setText(b.getText());
        }else{
            if(b.getId() == R.id.buttonDot && tv.getText().toString().contains(".") ){
                return;
            }
            tv.setText(tv.getText().toString()+ b.getText().toString());
        }
    }
}
