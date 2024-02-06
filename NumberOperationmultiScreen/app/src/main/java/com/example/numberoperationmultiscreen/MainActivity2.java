package com.example.numberoperationmultiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView num1;
    TextView num2;
    TextView num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        num1 = findViewById(R.id.recieved1);
        num2 = findViewById(R.id.recieved2);
        num3 = findViewById(R.id.recieved3);

        Intent intent = getIntent();

        int number1 = intent.getIntExtra(MainActivity.firstNumber, 0);
        int number2 = intent.getIntExtra(MainActivity.secondNumber, 0);
        double result = intent.getIntExtra(MainActivity.result, 0);

        num1.setText(Integer.toString(number1));
        num2.setText(Integer.toString(number2));
        num3.setText(Double.toString(result));
    }
}