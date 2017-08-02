package com.skyland.sky_common.di.modules;

import android.content.Context;

import com.skyland.sky_common.utils.SkySharedPreferencesUtils;
import com.skyland.sky_common.utils.ToastUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by skyland on 2017/7/31
 */

@Module
public class AppModule {

    Context context;

    public AppModule(Context setContext){
        this.context = setContext;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public ToastUtils provideToastUtils(){
        return new ToastUtils(context);
    }

    @Provides
    @Singleton
    public SkySharedPreferencesUtils provideSkySharedPreferencesUtils(){
        return new SkySharedPreferencesUtils();
    }



}
