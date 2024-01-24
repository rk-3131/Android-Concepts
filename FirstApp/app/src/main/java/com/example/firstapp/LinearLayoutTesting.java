package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LinearLayoutTesting extends AppCompatActivity {

    Button submit;
    Button clear;
    Button back;
    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_testing);
        submit = findViewById(R.id.submitButton);
        clear = findViewById(R.id.clearButton);
        back = findViewById(R.id.backButton);
        email = findViewById(R.id.getEmail);
        pass = findViewById(R.id.getPassword);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LinearLayoutTesting.this,"Data will be submitted", Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setText("");
                pass.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LinearLayoutTesting.this, MainActivity.class));
            }
        });
    }
}