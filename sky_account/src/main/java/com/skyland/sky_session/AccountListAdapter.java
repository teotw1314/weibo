package com.skyland.sky_session;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.skyland.sky_data.bean.UserInfo;

import java.util.List;

/**
 * Created by skyland on 2017/7/15
 */

public class AccountListAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {

    public AccountListAdapter(List<UserInfo> data) {
        super(R.layout.lib_session_item_account, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserInfo item) {
        helper.setText(R.id.text_item_account_name, item.name);
        ImageView imageView = helper.getView(R.id.img_circle_item_account);
        Glide.with(mContext)
                .load(item.profile_image_url)
                .into(imageView);


    }
}
