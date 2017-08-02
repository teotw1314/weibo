package com.skyland.weibo.router;

import android.app.Activity;
import android.content.Context;

import com.skyland.lib_webview.activity.WebViewPopActivity;
import com.skyland.lib_webview.activity.WebViewSubActivity;
import com.skyland.sky_common.router.Router;
import com.skyland.sky_home.HomeActivity;
import com.skyland.sky_session.AccountManagerActivity;

/**
 * Created by skyland on 2017/7/8
 */
@SuppressWarnings("unused")
public class SkyRouter extends Router {
    // TODO: 2017/7/8 sky router


    @Override
    public void pushWebViewSubActivity(Activity setActivity, String setTitle, String setUrl, boolean setIsAutho) {
        WebViewSubActivity.startActivity(setActivity, setTitle, setUrl, setIsAutho);
    }

    @Override
    public void pushWebViewPopActivity(Activity setActivity, String setTitle, String setUrl, boolean setIsAutho) {
        WebViewPopActivity.startActivity(setActivity, setTitle, setUrl, setIsAutho);
    }

    @Override
    public void pushAccountManagerActivity(Context setContext) {
        AccountManagerActivity.startActivity(setContext);
    }

    @Override
    public void pushHomeActivity(Context setContext, String setUid) {
        HomeActivity.startActivity(setContext, setUid);
    }
}
