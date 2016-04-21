package com.example.a.t15_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by a on 2016-04-21.
 */
public class MyService extends Service{
    public MyService(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implement");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("service", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "onStartCommand");
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("service", "onDestroy");
        super.onDestroy();
    }
}
