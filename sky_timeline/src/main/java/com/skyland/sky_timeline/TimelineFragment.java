package com.skyland.sky_timeline;

import android.net.Network;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.skyland.sky_common.app.App;
import com.skyland.sky_common.ui.LazyFragment;
import com.skyland.sky_data.base.NetworkListener;
import com.skyland.sky_data.bean.StatusInfo;
import com.skyland.sky_data.network.SkyNetwork;
import com.skyland.sky_data.result.StatusResult;
import com.skyland.sky_session.AccountInfo;
import com.skyland.sky_session.AccountUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyland on 2017/7/20
 */

public class TimelineFragment extends LazyFragment {

    private static final String TAG = "timeline";

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;


    private LinearLayoutManager layoutManager;
    private TimelineListAdapter timelineAdapter;
    private List<StatusInfo> statusInfoList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.lib_timeline_fragment;
    }

    @Override
    protected void initView(View rootView) {
//        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipelayout_lib_timeline);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_lib_timeline);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        timelineAdapter = new TimelineListAdapter(statusInfoList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(timelineAdapter);
    }

    @Override
    protected void initLogic() {
        refreshTimeline();
    }

    private void refreshTimeline() {
        AccountInfo accountInfo = AccountUtils.getDefault().getCurrentAccount(App.getInstance());

        SkyNetwork.getDefault().getTimeline(accountInfo.refresh_token, "0", "0", 20, 1, new NetworkListener<StatusResult>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(StatusResult statusResult) {
                refreshTimelineSuccess(statusResult.statuses);
            }
        });
    }

    private void refreshTimelineSuccess(List<StatusInfo> statusInfos) {
        Log.e(TAG, "refreshTimelineSuccess: " + statusInfos.size());
        for (int i = 0; i < statusInfos.size(); i++) {
            Log.e(TAG, "refreshTimelineSuccess: " + statusInfos.get(i).text);
        }
        statusInfoList.clear();
        statusInfoList.addAll(statusInfos);
        timelineAdapter.notifyDataSetChanged();
    }

}
