package com.skyland.sky_timeline;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by skyland on 2017/7/20
 */

public class TimelineListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public TimelineListAdapter(List<String> data){
        super(R.layout.lib_timeline_item_normal, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text_lib_timeline_item_name, item);
    }
}
