package com.example.a.t05_mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View v){
        String path = Environment.getExternalStorageDirectory()+"/Download/abc.mp3";
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }

    public void onStopClick(View v){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
