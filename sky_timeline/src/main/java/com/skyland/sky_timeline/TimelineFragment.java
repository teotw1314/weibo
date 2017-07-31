package com.skyland.sky_timeline;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.skyland.sky_common.ui.LazyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyland on 2017/7/20
 */

public class TimelineFragment extends LazyFragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    private List<String> listData = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.lib_timeline_fragment;
    }

    @Override
    protected void initView(View rootView) {
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipelayout_lib_timeline);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_lib_timeline);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        TimelineListAdapter adapter = new TimelineListAdapter(listData);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < 60; i++) {
            listData.add("skyland " + i);
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void initLogic() {


    }

}
