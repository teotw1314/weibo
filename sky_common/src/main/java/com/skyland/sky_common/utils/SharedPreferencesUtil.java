package com.skyland.sky_common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedOutputStream;
import java.net.PortUnreachableException;
import java.security.PublicKey;

/**
 * Created by skyland on 2017/7/9
 */
@SuppressWarnings("unused")
public class SharedPreferencesUtil {
    private static final String SHARED_PREFERENCES_NAME = "Sky";
    private static final String SHARED_PREFERENCES_KEY = "kjkjkj";

    public static void setSharedPreference(Context setContext, String setKey, Object setValue) {
        SharedPreferences sharedPreferences = setContext.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (setValue instanceof String) {
            editor.putString(setKey, (String) setValue);
        } else if (setValue instanceof Integer) {
            editor.putInt(setKey, (Integer) setValue);
        } else if (setValue instanceof Boolean) {
            editor.putBoolean(setKey, (Boolean) setValue);
        }
        editor.apply();
    }

    public static Object getSharedPreferences(Context setContext, String setKey, Object defVal) {
        Object value = null;
        SharedPreferences sharedPreferences = setContext.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        if (defVal instanceof String) {
            value = sharedPreferences.getString(setKey, (String) defVal);
        } else if (defVal instanceof Integer) {
            value = sharedPreferences.getInt(setKey, (Integer) defVal);
        } else if (defVal instanceof Boolean) {
            value = sharedPreferences.getBoolean(setKey, (Boolean) defVal);
        }
        return value;
    }

    public static void removeKey(Context setContext, String setKey){
        SharedPreferences sharedPreferences = setContext.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(setKey);
        editor.apply();
    }

}
