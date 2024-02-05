package com.example.multiscreen2;

import static com.example.multiscreen2.MainActivity.name1;
import static com.example.multiscreen2.MainActivity.name2;
import static com.example.multiscreen2.MainActivity.name3;
import static com.example.multiscreen2.MainActivity.name4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView naam1;
    TextView naam2;
    TextView naam3;
    TextView naam4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        naam1 = findViewById(R.id.name1);
        naam2 = findViewById(R.id.name2);
        naam3 = findViewById(R.id.name3);
        naam4 = findViewById(R.id.name4);

        Intent intent = getIntent();
        String n1 = intent.getStringExtra(name1);
        String n2 = intent.getStringExtra(name2);
        String n3 = intent.getStringExtra(name3);
        String n4 = intent.getStringExtra(name4);

        naam1.setText(n1);
        naam2.setText(n2);
        naam3.setText(n3);
        naam4.setText(n4);
    }
}