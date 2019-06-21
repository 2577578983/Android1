package com.example.myapplication.apps;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {


    public static MyApplication app;

    public static MyApplication getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static MyApplication getInstance() {
        return app;
    }
}
