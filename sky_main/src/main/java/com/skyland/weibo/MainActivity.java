package com.skyland.weibo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.skyland.lib_webview.core.WebViewBaseActivity;
import com.skyland.weibo.router.SkyRouter;

public class MainActivity extends AppCompatActivity {
    // TODO: 2017/7/12 test activity

    private static final String WEIBO_APP_KEY = "2121829066";
    private static final String WEIBO_APP_SECRET = "a1a642a333e1ebf455c0c45a91511bc7";
    private static final String WEIBO_CALLBACK_URL = "https://api.weibo.com/oauth2/default.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        test();
//        pushOauthActivity();
//        startAccountManagerActivity();
        SkyRouter.getDefault().pushHomeActivity(this);
    }

    private void test() {
        String testUrl = "https://www.google.co.jp/webhp?ei=wTVkWdKULouq0gTotLXoBA&ved=0EKkuCAYoAQ";
        String bingUrl = "http://cn.bing.com/";
        SkyRouter.getDefault().pushWebViewSubActivity(this, null, bingUrl,false);
    }

    private void pushOauthActivity() {
        String oauthUrl = "https://open.weibo.cn/oauth2/authorize"
                + "?client_id=" + WEIBO_APP_KEY
                + "&redirect_uri=" + WEIBO_CALLBACK_URL
                + "&response_type=code"
                + "&display=mobile/";
        SkyRouter.getDefault().pushWebViewSubActivity(this, null, oauthUrl,true);
    }

    private void startAccountManagerActivity(){
        SkyRouter.getDefault().pushAccountManagerActivity(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == WebViewBaseActivity.REQUEST_CODE){
                String code = data.getStringExtra(WebViewBaseActivity.RESULT_CODE_KEY);
                Log.e("ssss", "onActivityResult: code:" + code );
            }
        }
    }
}
