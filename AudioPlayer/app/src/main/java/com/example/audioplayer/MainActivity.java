package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.chandaniyaa);
//        here we have imported the media file into the system where we can play that track

        Button play = findViewById(R.id.playButton);
        Button pause = findViewById(R.id.pauseButton);
        Button stop = findViewById(R.id.stopButton);

        SeekBar volBar = findViewById(R.id.volSeek);
        SeekBar progBar = findViewById(R.id.progressSeek);

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        getSystemServices is the method which will give us the results of all the services which are provided by the system
//        Context has many other services like blutooth and other as well

        int maxValue = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currValue = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volBar.setMax(maxValue);
        volBar.setProgress(currValue);

        volBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        progBar.setMax(player.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                progBar.setProgress(player.getCurrentPosition());
            }
        }, 0, 5000);
        progBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                player.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.seekTo(0);
                progBar.setProgress(0);
                player.pause();
            }
        });
    }
}