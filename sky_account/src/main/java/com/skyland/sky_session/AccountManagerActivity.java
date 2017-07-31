package com.skyland.sky_session;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.skyland.lib_webview.core.WebViewBaseActivity;
import com.skyland.sky_common.router.Router;
import com.skyland.sky_common.ui.BaseSubActivity;

import com.skyland.sky_data.base.NetworkListener;
import com.skyland.sky_data.bean.AccessTokenInfo;
import com.skyland.sky_data.bean.UserInfo;
import com.skyland.sky_data.network.SkyNetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyland on 2017/7/12
 */

public class AccountManagerActivity extends BaseSubActivity {
    private static final String TAG = "Account";


    private RecyclerView recyclerView;
    private Button btnAddAccount;
    private Button btnShowDialog;
    private ProgressDialog progressDialog;

    private BaseQuickAdapter adapter;
    private LinearLayoutManager layoutManager;

    private List<UserInfo> userInfoList = new ArrayList<>();

    public static void startActivity(Context setContext) {
        Intent intent = new Intent(setContext, AccountManagerActivity.class);
        setContext.startActivity(intent);
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.lib_session_activity_account_manager);
    }

    @Override
    protected void initToolbar() {
        toolbar.setNavigationIcon(R.mipmap.lib_common_ic_navigation_back);
        toolbar.setTitle("账号管理");
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_account_manager);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new AccountListAdapter(userInfoList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnAddAccount = (Button) findViewById(R.id.btn_add_account);
        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushOauthActivity();
            }
        });

        btnShowDialog = (Button) findViewById(R.id.btn_account_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    @Override
    protected void initLogic() {

    }

    private void pushOauthActivity() {
        String oauthUrl = "https://api.weibo.com/oauth2/authorize"
                + "?client_id=" + SkyNetwork.getDefault().getAppKey()
                + "&redirect_uri=" + SkyNetwork.getDefault().getCallbackUrl()
                + "&response_type=code"
                + "&display=mobile/";
        Router.getDefault().pushWebViewSubActivity(this, null, oauthUrl, true);
    }

    /**
     * 获取access token
     *
     * @param setCode
     */
    private void getAccessToken(String setCode) {
        showDialog();
        SkyNetwork.getDefault().getAccessToken(setCode, new NetworkListener<AccessTokenInfo>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(AccessTokenInfo accessTokenInfo) {
                Log.e(TAG, "onSuccess: " + accessTokenInfo.uid);
                getUserInfo(accessTokenInfo.access_token, accessTokenInfo.uid);
            }
        });
    }

    /**
     * 获取用户信息
     *
     * @param setAccessToken
     * @param setUid
     */
    private void getUserInfo(String setAccessToken, String setUid) {
        SkyNetwork.getDefault().getUserInfo(setAccessToken, setUid, new NetworkListener<UserInfo>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(UserInfo userInfo) {
                userInfoList.add(userInfo);
                adapter.notifyDataSetChanged();
                hideProgress();
                Log.e(TAG, "onSuccess: " + userInfo.name);
            }
        });
    }

    /**
     *  显示loading动画
     */
    private void showDialog() {
        if (progressDialog == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("正在加载 .......");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
        }
        progressDialog.show();
    }

    /**
     *  隐藏loading动画
     */
    private void hideProgress(){
        if(progressDialog != null){
            progressDialog.dismiss();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == WebViewBaseActivity.REQUEST_CODE) {
                String code = data.getStringExtra(WebViewBaseActivity.RESULT_CODE_KEY);
                Log.e(TAG, "onActivityResult: code:" + code);
                getAccessToken(code);
            }
        }
    }
}
