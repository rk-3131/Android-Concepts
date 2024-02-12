package com.example.taskhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int countInf = 1;
    int countFin = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button finite = findViewById(R.id.buttonFinite);
        Button infinite = findViewById(R.id.buttonInfinity);

        Handler handler = new Handler();

        infinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Toast Number " + countInf, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        
        finite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 1000){
                    @Override
                    public void onTick(long l) {
                        Toast.makeText(MainActivity.this, "Toast Number " + countFin, Toast.LENGTH_SHORT).show();
                        countFin++;
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Finite Toast has been finished", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}