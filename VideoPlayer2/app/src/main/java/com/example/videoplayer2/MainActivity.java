package com.example.videoplayer2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView = findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);

        videoView.setMediaController(controller);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.manojjarangevid);
        videoView.setVideoURI(uri);

        videoView.start();
    }
}