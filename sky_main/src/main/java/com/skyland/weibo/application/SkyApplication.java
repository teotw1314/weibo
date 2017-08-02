package com.skyland.weibo.application;

import android.app.Application;

import com.skyland.sky_common.app.App;
import com.skyland.sky_common.di.components.AppComponent;
import com.skyland.sky_common.di.components.DaggerAppComponent;
import com.skyland.sky_common.di.modules.AppModule;
import com.skyland.sky_common.router.Router;
import com.skyland.weibo.router.SkyRouter;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by skyland on 2017/7/9
 */

public class SkyApplication extends App {


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        Router.setRouter(new SkyRouter());      //初始化路由
    }




}
