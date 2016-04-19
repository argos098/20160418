package com.example.a.t07_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    ProgressBar progressBar;
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            if(msg.what == Thread_Count){
                btnStart.setText("bount"+msg.arg1);
                progressBar.setProgress(msg.arg1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btn01);
        progressBar = (ProgressBar) findViewById(R.id.myProgressBar);
    }

    int Thread_Count = 1;
    public void btnClick(View v){
        final Button btn = (Button)v;
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i ++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("Thread Test", "count : " + i);
                    //btn.setText("Count : " + i);
                    Message msg = new Message();
                    msg.what = Thread_Count;
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                }
            }
        });
        th.start();
    }
}
