package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list;
    ListView listView;
    Button tableButton;
    EditText editText;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        listView = findViewById(R.id.lView);
        tableButton = findViewById(R.id.getButton);
        editText = findViewById(R.id.getNumber);

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter some number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                number = Integer.parseInt(editText.getText().toString());

                list.clear();
                for (int i = 1; i <= 10; i++){
                    list.add(number + " X " + i + " = " + number * i);
                }

                ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);

                listView.setAdapter(adapter);
            }
        });
        list.clear();
    }
}