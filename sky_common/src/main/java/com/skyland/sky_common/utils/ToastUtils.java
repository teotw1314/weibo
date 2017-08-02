package com.skyland.sky_common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by skyland on 2017/7/31
 */


public class ToastUtils {

    Context context;

    public ToastUtils(Context setContext){
        this.context = setContext;
    }

    public void showToast(String setMessage){
        Toast.makeText(context, setMessage, Toast.LENGTH_SHORT).show();
    }


}
