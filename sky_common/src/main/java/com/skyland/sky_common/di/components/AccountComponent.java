package com.skyland.sky_common.di.components;

import android.app.Activity;

import com.skyland.sky_common.di.modules.AccountModule;
import com.skyland.sky_common.di.scopes.PerActivity;

import dagger.Component;

/**
 * Created by skyland on 2017/8/1
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {AccountModule.class})
public interface AccountComponent {

    void inject(Activity activity);

}
