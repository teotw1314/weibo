package com.skyland.sky_common.di.components;

import android.content.Context;

import com.skyland.sky_common.di.modules.AppModule;
import com.skyland.sky_common.utils.SkySharedPreferencesUtils;
import com.skyland.sky_common.utils.ToastUtils;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by skyland on 2017/7/31
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getContext();

    ToastUtils getToastUtils();

    SkySharedPreferencesUtils getSkySharedPreferencesUtils();

}
