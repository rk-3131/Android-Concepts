package com.example.multiscreen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String name1 = "com.example.multiscreen2.n1";
    public static final String name2 = "com.example.multiscreen2.n2";
    public static final String name3 = "com.example.multiscreen2.n3";
    public static final String name4 = "com.example.multiscreen2.n4";
    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    Button subButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.f1);
        text2 = findViewById(R.id.f2);
        text3 = findViewById(R.id.f3);
        text4 = findViewById(R.id.f4);
        subButton = findViewById(R.id.submitButton);

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(name1, text1.getText().toString());
                intent.putExtra(name2, text2.getText().toString());
                intent.putExtra(name3, text3.getText().toString());
                intent.putExtra(name4, text4.getText().toString());
                startActivity(intent);
            }
        });

    }
}