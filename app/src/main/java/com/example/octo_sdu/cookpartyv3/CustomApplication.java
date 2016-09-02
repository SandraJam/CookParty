package com.example.octo_sdu.cookpartyv3;

import android.app.Application;

import com.example.octo_sdu.cookpartyv3.back.Dependencies;
import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.cookpartyv3.back.FirstTime;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.setDefaultConfiguration(
                new RealmConfiguration
                        .Builder(CustomApplication.this)
                        .build());

        Dependencies.init();

        ExecutorInstance.executor.execute(new Runnable() {
            @Override
            public void run() {
                FirstTime firstTime = new FirstTime();
                firstTime.checkFirstTime(CustomApplication.this.getApplicationContext());
            }
        });
    }
}
