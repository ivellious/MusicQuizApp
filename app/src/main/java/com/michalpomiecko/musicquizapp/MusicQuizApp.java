package com.michalpomiecko.musicquizapp;

import android.app.Application;
import android.util.Log;

/**
 * Created by michal on 14.11.17.
 */

public class MusicQuizApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.e(MusicQuizApp.class.getSimpleName()," Something went wrong", paramThrowable);
            }
        });
    }
}
