package com.example.octo_sdu.cookpartyv3.back;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorInstance {
    public static Executor executor =  Executors.newSingleThreadExecutor();
    public static Executor mainExecutor = new Executor() {
        @Override
        public void execute(@NonNull Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    };
}
