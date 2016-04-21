package com.example.a.t15_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by a on 2016-04-21.
 */
public class MyService extends Service{
    public MyService(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
