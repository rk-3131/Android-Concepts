package com.example.onetontable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Range;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button prev;
    Button next;
    ListView listView;
    List<String> list;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prev = findViewById(R.id.prevButton);
        next = findViewById(R.id.nextButton);
        listView = findViewById(R.id.listV);
        
        list = new ArrayList<>();

        int number = index + 1;
        list.clear();
        for (int i = 1; i <= 10; i++){
            list.add(number + " X " + i + " = " + number * i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);
        
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index -= 1;
                if (index == -1){
                    Toast.makeText(MainActivity.this, "You are at the first table can't go back more!", Toast.LENGTH_SHORT).show();
                    index = 0;
                    return;
                }
                int number = index + 1;
                list.clear();
                for (int i = 1; i <= 10; i++){
                    list.add(number + " X " + i + " = " + number * i);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);

                listView.setAdapter(adapter);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index += 1;
                if (index == 20){
                    Toast.makeText(MainActivity.this, "You are at the last table can't go further more!", Toast.LENGTH_SHORT).show();
                    index = 19;
                    return;
                }
                int number = index + 1;

                list.clear();
                for (int i = 1; i <= 10; i++){
                    list.add(number + " X " + i + " = " + number * i);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);

                listView.setAdapter(adapter);
            }
        });
    }
}