package com.skyland.sky_common.app;

import android.app.Application;

import com.skyland.sky_common.di.components.AppComponent;
import com.skyland.sky_common.di.components.DaggerAppComponent;
import com.skyland.sky_common.di.modules.AppModule;

/**
 * Created by skyland on 2017/8/1
 */

public class App extends Application {

//    AppComponent appComponent;

    private static App instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }

    public static App getInstance(){
        return instance;
    }

//    public AppComponent getAppComponent(){
//        return appComponent;
//    }
}
