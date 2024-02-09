package com.example.indianplayers;

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
    List<String> players;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        players = new ArrayList<>();
        listView = findViewById(R.id.listView);

//        Adding elements to the arrayList
        players.add("Rohit Sharma (C)");
        players.add("Yashaswi Jaiswal");
        players.add("Shubhman Gill ");
        players.add("Virat Kohli");
        players.add("Ravindra Jadeja");
        players.add("Rishabh Pant (WK)");
        players.add("Ravichandran Ashwin");
        players.add("Jasprit Bumrah");
        players.add("Umesh Yadav");
        players.add("Bhvneshwar Kumar");
        players.add("Yuzi Chahal");
        players.add("Kuldeep Yadav");
        players.add("Ajinkya Rahane");
        players.add("Mayank Agarwal");
        players.add("Karun Nair");

//        ArrayAdpater is created which is nothing but the handler of the data that has been provided to the array
//        it is handler of the array or arraylist in java
//        It requires the context, type of view that we want which can be inbuilt and also can be created manually
//        and then there is third argument which is array or the arraylist
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);

//        listView has been set to the adapter that we have created
        listView.setAdapter(adapter);


//        OnItemClick will be used to touch every element which is present there
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Name of the player is " + players.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}