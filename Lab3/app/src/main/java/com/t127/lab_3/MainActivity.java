package com.t127.lab_3;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    // < -------------------  declaration of button variables  ----------------------------->
    TextView tv;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonDot,
            buttonPlus, buttonDiv, buttonMinus,buttonMult,buttonEqual,buttonC;

    float valueOne, valueTwo;

    // function to calculate the two numbers
    private float calculate(){
        switch (op){
            case plus: return valueOne + valueTwo;
            case minus:return valueOne - valueTwo;
            case mult:return valueOne * valueTwo;
            case div:if(valueTwo!=0){return valueOne/valueTwo;}else{return Float.NaN;}
            default: return Float.NaN;
        }
    }



    // function to know which operation i am intent to do, i need to kwno what is the action!
    enum Opperation{none,plus,minus,mult,div}
    //variable to remenber what action was selected by the user
    Opperation op = Opperation.none;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // < -------------------  assign the variable to the buttons created  ----------------------------->

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

        // < -------------------  onclick method to add the numbers on the view of the calculator app  ----------------------------->

        View.OnClickListener numListener = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Button b  = (Button)v;
                String digit = b.getText().toString();
                if (tv.getText().toString().equals("0"))
                {   //replace
                    tv.setText(digit);
                }else{
                    //concatenate
                    tv.setText(tv.getText().toString()+digit);
                }

            }
        };

        // < -------------------  here we set that when the user click in a numerical number it will call the function above  ----------------------------->


        button0.setOnClickListener(numListener);
        button1.setOnClickListener(numListener);
        button2.setOnClickListener(numListener);
        button3.setOnClickListener(numListener);
        button4.setOnClickListener(numListener);
        button5.setOnClickListener(numListener);
        button6.setOnClickListener(numListener);
        button7.setOnClickListener(numListener);
        button8.setOnClickListener(numListener);
        button9.setOnClickListener(numListener);

        // < -------------------  now set up the action for button dot  ----------------------------->
        buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( tv.getText().toString().contains("."))
                {
                    return;
                }else{
                    tv.setText(tv.getText().toString() + "." );
                }

            }
        });

        // < -------------------  now set up the action for button clear ----------------------------->
        buttonC = findViewById(R.id.buttomC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = Opperation.none;
                tv.setText("0");
            }
        });

        // < -------------------  now set up the action for buttons + - / * ----------------------------->
        buttonPlus = findViewById(R.id.buttonplus);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMinus = findViewById(R.id.buttonminous);
        buttonMult = findViewById(R.id.buttonMult);

         View.OnClickListener opListener = new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(op == Opperation.none)
                 {
                     valueOne =Float.parseFloat(tv.getText().toString());
                     tv.setText("0");
                 }else{
                     valueTwo =Float.parseFloat(tv.getText().toString());  // value two will be the first number entered
                     valueOne =calculate();                                //value one will calculate
                     tv.setText("0");                                       // then set the screen to zero again to put the second number

                     }
                 switch (v.getId()){
                     case R.id.buttonplus: op =Opperation.plus;
                         break;
                     case R.id.buttonminous: op =Opperation.minus;
                         break;
                     case R.id.buttonMult: op =Opperation.mult;
                         break;
                     case R.id.buttonDiv: op =Opperation.div;
                         break;
                 }

             }
         };

        // < -------------------  here we set that when the user click in a op button it will call the function above  ----------------------------->

        buttonPlus.setOnClickListener(opListener);
        buttonMinus.setOnClickListener(opListener);
        buttonMult.setOnClickListener(opListener);
        buttonDiv.setOnClickListener(opListener);

         // < -------------------  now set up the action for button equal----------------------------->
        buttonEqual = findViewById(R.id.buttonEqual);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op!= Opperation.none){

                    valueTwo =Float.parseFloat(tv.getText().toString());  // value two will be the first number entered
                    valueOne =calculate();                                //value one will calculate
                    tv.setText(valueOne+"");



                }
                op=Opperation.none;
            }

        });



    }
}
