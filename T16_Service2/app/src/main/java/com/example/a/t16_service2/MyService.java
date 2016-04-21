package com.example.a.t16_service2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    MyBinder binder = new MyBinder();
    class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    private Random random = new Random();
    public int getRandomNumber(){
        return random.nextInt(100);
    }
}
