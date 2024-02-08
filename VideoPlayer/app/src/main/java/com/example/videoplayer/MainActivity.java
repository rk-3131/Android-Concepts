package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vid;
    SeekBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vid = findViewById(R.id.videoView);
        bar = findViewById(R.id.seekBar);
        MediaController controller = new MediaController(this);

        vid.setMediaController(controller);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + '/' + R.raw.videofile);

        vid.setVideoURI(uri);
        vid.start();
    }
}