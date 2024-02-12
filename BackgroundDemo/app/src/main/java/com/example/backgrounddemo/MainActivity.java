package com.example.backgrounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BGTask bg = new BGTask();
        bg.execute("https://facebook.com");
    }

//    public void getData(View view){
//        BGTask bg = new BGTask();
//        bg.e
//    }
}