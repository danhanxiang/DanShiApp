package com.danshi.danhanxiang.app;

import android.app.Application;

/**
 * Created by 20939 on 2016/11/24.
 */
public class App extends Application {

    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }


}
