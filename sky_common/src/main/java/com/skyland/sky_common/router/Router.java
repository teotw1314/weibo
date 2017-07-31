package com.skyland.sky_common.router;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by skyland on 2017/7/8
 */
@SuppressWarnings("unused")
public class Router {
    // TODO: 2017/7/8 router

    public static Router instance;

    public static Router getDefault() {
        if (instance == null) {
            instance = new Router();
        }
        return instance;
    }

    public static void setRouter(Router setRouter) {
        instance = setRouter;
    }

    public void showFailed(Context setContext) {
        if (setContext != null) {
            Toast.makeText(setContext, "start activity failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void pushWebViewSubActivity(Activity setActivity, String setTitle, String setUrl, boolean setIsAutho) {
        showFailed(setActivity);
    }

    public void pushWebViewPopActivity(Activity setActivity, String setTitle, String setUrl, boolean setIsAutho) {
        showFailed(setActivity);
    }

    public void pushAccountManagerActivity(Context setContext){
        showFailed(setContext);
    }

    public void pushHomeActivity(Context setContext){
        showFailed(setContext);
    }





}
