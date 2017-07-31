package com.skyland.weibo.application;

import android.app.Application;

import com.skyland.sky_common.router.Router;
import com.skyland.weibo.router.SkyRouter;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by skyland on 2017/7/9
 */

public class SkyApplication extends Application {

    private static SkyApplication instance;

    public static SkyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        Router.setRouter(new SkyRouter());      //初始化路由


    }


}
