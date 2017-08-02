package com.skyland.sky_common.app;

import android.app.Application;

import com.skyland.sky_common.di.components.AppComponent;
import com.skyland.sky_common.di.components.DaggerAppComponent;
import com.skyland.sky_common.di.modules.AppModule;

/**
 * Created by skyland on 2017/8/1
 */

public class App extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
