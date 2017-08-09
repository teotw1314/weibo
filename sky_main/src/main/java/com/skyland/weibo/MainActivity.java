package com.skyland.weibo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;

import com.skyland.lib_webview.core.WebViewBaseActivity;
import com.skyland.sky_common.router.Router;
import com.skyland.sky_common.utils.WeiboTextUtils;
import com.skyland.sky_session.AccountUtils;
import com.skyland.weibo.router.SkyRouter;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    // TODO: 2017/7/12 test activity

    private static final String WEIBO_APP_KEY = "2121829066";
    private static final String WEIBO_APP_SECRET = "a1a642a333e1ebf455c0c45a91511bc7";
    private static final String WEIBO_CALLBACK_URL = "https://api.weibo.com/oauth2/default.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        stringTest();

        entry();


    }

    private void entry() {
        if (AccountUtils.getDefault().getCurrentAccount(this) == null) {
            startAccountManagerActivity();
        } else {
            Router.getDefault().pushHomeActivity(this, null);
        }
    }

    private void test() {
        String testUrl = "https://www.google.co.jp/webhp?ei=wTVkWdKULouq0gTotLXoBA&ved=0EKkuCAYoAQ";
        String bingUrl = "http://cn.bing.com/";
        SkyRouter.getDefault().pushWebViewSubActivity(this, null, bingUrl, false);
    }

    private void pushOauthActivity() {
        String oauthUrl = "https://open.weibo.cn/oauth2/authorize"
                + "?client_id=" + WEIBO_APP_KEY
                + "&redirect_uri=" + WEIBO_CALLBACK_URL
                + "&response_type=code"
                + "&display=mobile/";
        SkyRouter.getDefault().pushWebViewSubActivity(this, null, oauthUrl, true);
    }

    private void startAccountManagerActivity() {
        SkyRouter.getDefault().pushAccountManagerActivity(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == WebViewBaseActivity.REQUEST_CODE) {
                String code = data.getStringExtra(WebViewBaseActivity.RESULT_CODE_KEY);
                Log.e("ssss", "onActivityResult: code:" + code);
            }
        }
    }


    private void stringTest() {
        TextView textView = (TextView) findViewById(R.id.main_tv);

        String testString = "测试文本@skyland:";

        /*
        SpannableStringBuilder spannableString = new SpannableStringBuilder(testString);
        SpannableString spannableString_temp = new SpannableString(testString);

        String schemeUser = "user";
        Linkify.addLinks(spannableString_temp, Pattern.compile("@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}"), schemeUser);

        URLSpan[] spans = spannableString_temp.getSpans(0, spannableString_temp.length(), URLSpan.class);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));


        for(URLSpan span : spans){
            int start = spannableString_temp.getSpanStart(span);
            int end = spannableString_temp.getSpanEnd(span);
            spannableString.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        */


        textView.setText(WeiboTextUtils.getSpanContent(this, testString, Color.parseColor("#009ad6")));
    }


}
