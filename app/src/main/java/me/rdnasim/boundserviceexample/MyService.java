package me.rdnasim.boundserviceexample;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import java.util.Date;
import java.util.Locale;

public class MyService extends Service {
    private final IBinder myBinder = new MyLocalBinder();

    public MyService() {
    }
    class MyLocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    public String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (simpleDateFormat.format(new Date()));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
}
