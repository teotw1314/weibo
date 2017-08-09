package com.skyland.sky_common.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Created by skyland on 2017/8/2
 */

public class WeiboTextUtils {

    public interface OnClickString {
        void onClick(String s);
    }

    public static SpannableStringBuilder getSpanContent(Context setContext, String setContent, int setSpanColor){
        if(TextUtils.isEmpty(setContent)){
            return null;
        }

        SpannableStringBuilder spannableString = new SpannableStringBuilder(setContent);
        SpannableString spannableString_temp = new SpannableString(setContent);

        ////////////////////////////////////////////////开始匹配
        //用户
        String schemeUser = "user";
        Linkify.addLinks(spannableString_temp, Pattern.compile("@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}"), schemeUser);

        //网页链接1
        String schemeUrl1 = "http://";
        Linkify.addLinks(spannableString_temp, Pattern.compile("http://[a-zA-Z0-9+&@#/%?=~_\\-|!:,\\.;]*[a-zA-Z0-9+&@#/%=~_|]"), schemeUrl1);

        // 网页链接2
        String scheme2 = "https://";
        Linkify.addLinks(spannableString_temp, Pattern.compile("https://[a-zA-Z0-9+&@#/%?=~_\\-|!:,\\.;]*[a-zA-Z0-9+&@#/%=~_|]"), scheme2);

        // 手机号码 (13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\d{8}
        String schemePhone = "phone";
        Linkify.addLinks(spannableString_temp, Pattern.compile("(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\\\d{8}"), schemePhone);

        //话题
        String schemeSubject = "subject";
        Linkify.addLinks(spannableString_temp, Pattern.compile("#[^#]+#"), schemeSubject);
        ////////////////////////////////////////////////结束匹配

        URLSpan[] spans = spannableString_temp.getSpans(0, spannableString_temp.length(), URLSpan.class);


        for(URLSpan span : spans){
            int start = spannableString_temp.getSpanStart(span);
            int end = spannableString_temp.getSpanEnd(span);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(setSpanColor);
            spannableString.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }

        return spannableString;
    }

}
