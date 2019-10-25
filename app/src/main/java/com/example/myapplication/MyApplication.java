package com.example.myapplication;

import android.app.Application;

import io.realm.Realm;

/**
 * @anthor Liszt
 * @data 2019/10/22
 * Description
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
