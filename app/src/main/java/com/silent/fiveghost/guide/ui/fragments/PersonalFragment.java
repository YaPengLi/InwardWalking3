package com.silent.fiveghost.guide.ui.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.PersonalAdapte;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.interfaces.AlphaChangeListener;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.ui.activitys.FinancialFlowActivity;
import com.silent.fiveghost.guide.ui.activitys.HelpCenterActivity;
import com.silent.fiveghost.guide.ui.activitys.MyRouteActivity;
import com.silent.fiveghost.guide.ui.activitys.RouteTemplateActivity;
import com.silent.fiveghost.guide.ui.activitys.SecuritySettingActivity;
import com.silent.fiveghost.guide.views.CircularImageView;
import com.silent.fiveghost.guide.views.XScrollView;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 84682 on 2018/1/27.
 */

public class PersonalFragment extends Fragment implements View.OnClickListener, AlphaChangeListener {

    private RecyclerView mPersion_recyc;
    private AutoRelativeLayout anquanshezhi;
    private AutoRelativeLayout wodeluxian;
    private XScrollView mPersonalScroll;
    private AutoRelativeLayout mPersion_toolbar;
    private int mTouchSlop;//系统认为的最小滑动距离

    private float mFirstY;//用户首次触摸的Y坐标
    private float mLastY;//用户滑动结束时Y坐标
    private CircularImageView user_icon;
    private AutoRelativeLayout caiwuliushui;
    private AutoRelativeLayout bangzhuzhongxin;
    private AutoRelativeLayout tuichu;
    private TextView mTitle;


    private Bitmap mBitmap;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    protected static Uri tempUri;
    private static final int CROP_SMALL_PICTURE = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.persion_al, container, false);

        Presenters p = new Presenters(getActivity(), new Iview<String>() {
            @Override
            public void success(String s) {
                Log.e("TAG", s);
            }

            @Override
            public void failure(Throwable e) {

            }
        });
        //_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-
        Map<String, String> mParams = new HashMap<>();
        SharedPreferences preferences = getActivity().getSharedPreferences(Concat.FILE_NAME, Context.MODE_PRIVATE);
        mParams.put("access_token", preferences.getString("access_token", null));
        p.requestNews(Concat.USERINFO, mParams);
        initView(view);
        Glide.with(this).load("http://img4.imgtn.bdimg.com/it/u=4162269701,19586045&fm=27&gp=0.jpg").into(user_icon);
        return view;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    private void initView(View view) {
        mPersion_recyc = (RecyclerView) view.findViewById(R.id.mPersion_recyc);
        mPersion_recyc.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        PersonalAdapte adapter = new PersonalAdapte(getActivity());
        mPersion_recyc.setAdapter(adapter);
        adapter.setOnClickListener(new PersonalAdapte.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        anquanshezhi = (AutoRelativeLayout) view.findViewById(R.id.anquanshezhi);
        wodeluxian = (AutoRelativeLayout) view.findViewById(R.id.wodeluxian);
        mPersonalScroll = (XScrollView) view.findViewById(R.id.mPersonalScroll);
        mPersion_toolbar = (AutoRelativeLayout) view.findViewById(R.id.mPersion_toolbar);
        wodeluxian.setOnClickListener(this);
        anquanshezhi.setOnClickListener(this);
        mPersonalScroll.setAlphaChangeListener(this);
        user_icon = (CircularImageView) view.findViewById(R.id.user_icon);
        user_icon.setOnClickListener(this);
        caiwuliushui = (AutoRelativeLayout) view.findViewById(R.id.caiwuliushui);
        caiwuliushui.setOnClickListener(this);
        bangzhuzhongxin = (AutoRelativeLayout) view.findViewById(R.id.bangzhuzhongxin);
        bangzhuzhongxin.setOnClickListener(this);
        tuichu = (AutoRelativeLayout) view.findViewById(R.id.tuichu);
        tuichu.setOnClickListener(this);
        mTitle = (TextView) view.findViewById(R.id.mTitle);
        mTitle.setText("个人中心");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anquanshezhi:
                startActivity(new Intent(getActivity(), SecuritySettingActivity.class));
                break;
            case R.id.wodeluxian:
                startActivity(new Intent(getActivity(), RouteTemplateActivity.class));
                break;
            case R.id.caiwuliushui:
                startActivity(new Intent(getActivity(), FinancialFlowActivity.class));
                break;
            case R.id.bangzhuzhongxin:
                startActivity(new Intent(getActivity(), HelpCenterActivity.class));
                break;
            case R.id.tuichu:
                getActivity().finish();
                break;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void alphaChanging(float alpha) {
        mPersion_toolbar.setVisibility(View.VISIBLE);
        float s = (1 - alpha) * 6;
        if (s > 1) {
            s = 1;
        }
        Log.e("TAG", "" + (s));
        mPersion_toolbar.setAlpha(s);
    }


}
