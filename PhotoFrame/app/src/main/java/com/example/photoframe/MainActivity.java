package com.example.photoframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button prev;
    Button nxt;
    int index = 0;
    int [] imgArray = {
       R.drawable.cric1, R.drawable.cric2, R.drawable.cric3, R.drawable.cric4, R.drawable.cric5,
            R.drawable.cric6, R.drawable.cric7, R.drawable.cric8, R.drawable.cric9, R.drawable.cric10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prev = findViewById(R.id.prevButton);
        nxt = findViewById(R.id.nextButton);
        img = findViewById(R.id.imageView);

        img.setImageResource(imgArray[index]);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = (index + 1) % imgArray.length;
                img.setImageResource(imgArray[index]);
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = (index - 1 + imgArray.length) % imgArray.length;
                img.setImageResource(imgArray[index]);
            }
        });
    }
}