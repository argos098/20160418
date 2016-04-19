package com.example.a.test01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

public class ViewActivity extends AppCompatActivity {

    private static final int SEEKBAR_VALUE = 1;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SEEKBAR_VALUE) {
                seekBar.setProgress(msg.arg1);
            }
        }
    };

    MediaPlayer mp = null;
    SeekBar seekBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser==true){
                    if(mp != null){
                        mp.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    public void onStartClick(View v){
        String path = Environment.getExternalStorageDirectory()+"/Download/"+getIntent().getStringExtra("fName");
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
        seekBar.setMax(mp.getDuration());

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while(mp != null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(mp != null) {
                        Message msg = new Message();
                        msg.what = SEEKBAR_VALUE;
                        msg.arg1 = mp.getCurrentPosition();
                        handler.sendMessage(msg);
                    }
                }
            }
        });
        th.start();
    }

    public void onStopClick(View v){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void onCloseClick(View v){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }

        finish();
    }
}
