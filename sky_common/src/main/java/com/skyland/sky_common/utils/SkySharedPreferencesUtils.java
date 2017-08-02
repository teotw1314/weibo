package com.skyland.sky_common.utils;

import com.skyland.sky_base.utils.SharedPreferencesUtils;

import javax.inject.Inject;

/**
 * Created by skyland on 2017/8/1
 */

public class SkySharedPreferencesUtils extends SharedPreferencesUtils {


    private static SkySharedPreferencesUtils instance;

    public static SkySharedPreferencesUtils getDefault(){
        if(instance == null){
            instance = new SkySharedPreferencesUtils();
        }
        return instance;
    }


    @Override
    public String getSharedPreferencesName() {
        return "sky_weibo_kkskskskj!-_-";
    }

    @Override
    public String getSharedPreferencesKey() {
        return "sky_weibo_kkkkkkkk;:_-_";
    }
}
