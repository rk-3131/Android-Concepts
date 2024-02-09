package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> names;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = new ArrayList<>();
        list = findViewById(R.id.listView);
        names.add("Radhakrushna");
        names.add("Avi");
        names.add("Saurabh");
        names.add("Piyush");
        names.add("Sushant");
        names.add("Nachiket");
        names.add("Abhishek");
        names.add("Atharva");
        names.add("Prashant");
        names.add("Jagdish");
        names.add("Sameer");
        names.add("Vaibhav");
        names.add("Ritesh");
        names.add("Sanket");
        names.add("Shubham");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i;
                Toast.makeText(MainActivity.this, "This is " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}