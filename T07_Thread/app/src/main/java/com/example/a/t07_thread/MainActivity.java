package com.example.a.t07_thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
                    btn.setText("Count : " + i);
                }
            }
        });
        th.start();
    }
}
