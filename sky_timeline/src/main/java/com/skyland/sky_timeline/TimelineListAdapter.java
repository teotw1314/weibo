package com.skyland.sky_timeline;

import android.media.Image;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.skyland.sky_base.utils.DateUtils;
import com.skyland.sky_common.app.App;
import com.skyland.sky_common.utils.AppUtils;
import com.skyland.sky_data.bean.StatusInfo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by skyland on 2017/7/20
 */

public class TimelineListAdapter extends BaseQuickAdapter<StatusInfo, BaseViewHolder> {

    public TimelineListAdapter(List<StatusInfo> data) {
        super(R.layout.lib_timeline_item_weibo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StatusInfo item) {

        ImageView avatar = helper.getView(R.id.item_weibo_imgv_avatar);
        Glide.with(App.getInstance()).load(item.user.avatar_hd).into(avatar);

        helper.setText(R.id.item_weibo_tv_name, item.user.name);
        helper.setText(R.id.item_weibo_tv_time, AppUtils.getDefault().getWeiboTime(item.created_at));
        helper.setText(R.id.item_weibo_tv_from, AppUtils.getDefault().getWeiboSource(item.source));

        helper.setText(R.id.item_weibo_tv_repost_count, String.valueOf(item.reposts_count));
        helper.setText(R.id.item_weibo_tv_comment_count, String.valueOf(item.comments_count));
        helper.setText(R.id.item_weibo_tv_like_count, String.valueOf(item.attitudes_count));

        helper.setText(R.id.item_weibo_tv_content, item.text);


    }
}
