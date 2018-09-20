package com.t127.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(this); // on click call
    }

    @Override
    public void onClick(View view) {
        //onClick action

        TextView tw = findViewById(R.id.textView); // text view Object

        EditText et = findViewById(R.id.editText); // edti Text Object


        String input = et.getText().toString();
        int pin = 0;
        if(!input.equals(""))
        {
            pin = Integer.parseInt(input);

        }
        if(pin == 2001)
        {
            tw.setText("It is Alive!");
            tw.setBackgroundColor(Color.GREEN);
        }else
        {
            tw.setText("Not this Time!");
            tw.setBackgroundColor(Color.RED);
        }




    }
}
