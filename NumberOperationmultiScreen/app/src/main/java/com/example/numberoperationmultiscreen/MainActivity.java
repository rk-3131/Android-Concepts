package com.example.numberoperationmultiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final public String firstNumber = "com.example.numberoperationmultiscreen.number_1";
    static final public String secondNumber = "com.example.numberoperationmultiscreen.number_2";
    static final public String result = "com.example.numberoperationmultiscreen.result_val";
    EditText n1;
    EditText n2;
    RadioButton add;
    RadioButton sub;
    RadioButton mul;
    RadioButton div;
    Button submit;
    double solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);

        add = findViewById(R.id.rAdd);
        sub = findViewById(R.id.rSub);
        mul = findViewById(R.id.rMul);
        div = findViewById(R.id.rDiv);

        submit = findViewById(R.id.resButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(n1.getText().toString());
                int number2 = Integer.parseInt(n2.getText().toString());

                if (add.isChecked()){
                    solution = number1 + number2;
                }else if (sub.isChecked()){
                    solution = number1 - number2;
                }else if (mul.isChecked()){
                    solution = number1 * number2;
                }else{
                    solution = number1 / number2;
                }

                double answer = solution;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(firstNumber, number1);
                intent.putExtra(secondNumber, number2);
                intent.putExtra(result, answer);

                startActivity(intent);
            }
        });
    }
}