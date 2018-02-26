package com.silent.fiveghost.guide.ui.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.HomeCenterAdapter;
import com.silent.fiveghost.guide.adapter.MyReleaseRouteActivity;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.ui.fragments.ReservationOrderFragment;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;

public class ReservationOrderActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_order_passenger2;
    private TextView tv_order_travel2;
    private AutoLinearLayout order_linearLayout2;
    private TextView tv_order_passenger3;
    private TextView tv_order_travel3;
    private TextView tv_order_refuse3;
    private AutoLinearLayout order_linearLayout3;
    private ViewPager vp_order_center;
    private ArrayList<Fragment> fragments;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_order);
        initView();
        fragments = new ArrayList<>();
        fragments.add(new ReservationOrderFragment());
        fragments.add(new ReservationOrderFragment());
        fragments.add(new ReservationOrderFragment());
        HomeCenterAdapter adapter = new HomeCenterAdapter(getSupportFragmentManager(), fragments, this);

        vp_order_center.setAdapter(adapter);
        vp_order_center.setCurrentItem(0);


        Intent intent = getIntent();
        String passenger = intent.getStringExtra("passenger");
        if(passenger!=null) {
            if (passenger.equals("passenger")) {
                initPassenger();
            } else if (passenger.equals("travel")) {
                initTravel();
            }
        }

    }

    private void initTravel() {
        order_linearLayout3.setVisibility(View.VISIBLE);
        order_linearLayout2.setVisibility(View.GONE);
        mTitle.setText("旅行社预约订单");

        vp_order_center.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        initPassenger3();
                        break;
                    case 1:
                        initTravel3();
                        break;
                    case 2:
                        initrefuse3();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initPassenger() {

        order_linearLayout2.setVisibility(View.VISIBLE);
        order_linearLayout3.setVisibility(View.GONE);
        mTitle.setText("游客预约订单");


        vp_order_center.setCurrentItem(0);
        vp_order_center.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        initPassenger2();
                        break;
                    case 1:
                        initTravel2();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        tv_order_passenger2 = (TextView) findViewById(R.id.tv_order_passenger2);
        tv_order_travel2 = (TextView) findViewById(R.id.tv_order_travel2);
        order_linearLayout2 = (AutoLinearLayout) findViewById(R.id.order_linearLayout2);
        tv_order_passenger3 = (TextView) findViewById(R.id.tv_order_passenger3);
        tv_order_travel3 = (TextView) findViewById(R.id.tv_order_travel3);
        tv_order_refuse3 = (TextView) findViewById(R.id.tv_order_refuse3);
        order_linearLayout3 = (AutoLinearLayout) findViewById(R.id.order_linearLayout3);
        vp_order_center = (ViewPager) findViewById(R.id.vp_order_center);
        tv_order_passenger2.setOnClickListener(this);
        tv_order_travel2.setOnClickListener(this);
        tv_order_passenger3.setOnClickListener(this);
        tv_order_refuse3.setOnClickListener(this);
        tv_order_travel3.setOnClickListener(this);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        left_icon.setOnClickListener(this);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mTitle.setOnClickListener(this);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("路线详情");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReservationOrderActivity.this.finish();;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_order_passenger2://游客预约我的订单
                initPassenger2();
                break;
            case R.id.tv_order_travel2://游客已同意订单
                initTravel2();
                break;
            case R.id.tv_order_passenger3://旅行社预约我的订单
                initPassenger3();
                break;
            case R.id.tv_order_refuse3://旅行社已拒绝订单
                initrefuse3();
                break;
            case R.id.tv_order_travel3://旅行社已同意订单
                initTravel3();
                break;
        }
    }

    private void initTravel3() {
        vp_order_center.setCurrentItem(1);

        tv_order_travel3.setTextColor(Color.parseColor("#00cd96"));
        tv_order_travel3.setTextSize(18);
        tv_order_passenger3.setTextColor(Color.parseColor("#cccccc"));
        tv_order_passenger3.setTextSize(16);
        tv_order_refuse3.setTextColor(Color.parseColor("#cccccc"));
        tv_order_refuse3.setTextSize(16);
    }

    private void initrefuse3() {
        vp_order_center.setCurrentItem(2);
        tv_order_refuse3.setTextColor(Color.parseColor("#00cd96"));
        tv_order_refuse3.setTextSize(18);
        tv_order_travel3.setTextColor(Color.parseColor("#cccccc"));
        tv_order_travel3.setTextSize(16);
        tv_order_passenger3.setTextColor(Color.parseColor("#cccccc"));
        tv_order_passenger3.setTextSize(16);
    }

    private void initPassenger3() {
        vp_order_center.setCurrentItem(0);
        tv_order_passenger3.setTextColor(Color.parseColor("#00cd96"));
        tv_order_passenger3.setTextSize(18);
        tv_order_travel3.setTextColor(Color.parseColor("#cccccc"));
        tv_order_travel3.setTextSize(16);
        tv_order_refuse3.setTextColor(Color.parseColor("#cccccc"));
        tv_order_refuse3.setTextSize(16);
    }

    private void initTravel2() {
        vp_order_center.setCurrentItem(1);
        tv_order_travel2.setTextColor(Color.parseColor("#00cd96"));
        tv_order_travel2.setTextSize(18);
        tv_order_passenger2.setTextColor(Color.parseColor("#cccccc"));
        tv_order_passenger2.setTextSize(16);
    }

    private void initPassenger2() {
        vp_order_center.setCurrentItem(0);
        tv_order_passenger2.setTextColor(Color.parseColor("#00cd96"));
        tv_order_passenger2.setTextSize(18);
        tv_order_travel2.setTextColor(Color.parseColor("#cccccc"));
        tv_order_travel2.setTextSize(16);
    }
}
