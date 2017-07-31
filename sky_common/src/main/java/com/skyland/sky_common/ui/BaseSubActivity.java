package com.skyland.sky_common.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.skyland.sky_common.R;

/**
 * Created by skyland on 2017/7/12
 */

public abstract class BaseSubActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.lib_common_slide_in_right, R.anim.lib_common_slide_out_left);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.lib_common_slide_in_left, R.anim.lib_common_slide_out_right);
    }
}
