package com.silent.fiveghost.guide.ui.activitys;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.FPAdapter;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.ui.fragments.GrabaSingleFragment;
import com.silent.fiveghost.guide.ui.fragments.HomePageFragment;
import com.silent.fiveghost.guide.ui.fragments.OrderFragment;
import com.silent.fiveghost.guide.ui.fragments.PersonalFragment;
import com.silent.fiveghost.guide.ui.fragments.RouteFragment;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

public class InwardWalkingActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private ArrayList<Fragment> mData = new ArrayList<>();
    private FPAdapter adapter;
    private RadioButton mRadio_home;
    private RadioButton mRadio_route;
    private RadioButton mRadio_GrabaSingle;
    private RadioButton mRadio_order;
    private RadioButton mRadio_persional;
    private RadioGroup mRadioGroup;
    private TextView mTitle;
    private AutoRelativeLayout autorelativelayout;
    private ImageView mMessage;
    private ImageView center_iamge;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView xiaoxitv_num;
    public View mRouteTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inward_walking);
        initView();
        initData();
    }

    private void initData() {
        mData.add(new HomePageFragment());
        mData.add(new RouteFragment());
        mData.add(new GrabaSingleFragment());
        mData.add(new OrderFragment());
        mData.add(new PersonalFragment());
        adapter.notifyDataSetChanged();
        mTitle.setText("首页");

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        adapter = new FPAdapter(getSupportFragmentManager(), mData);
        mViewPager.setAdapter(adapter);
        mRadio_home = (RadioButton) findViewById(R.id.mRadio_home);
        mRadio_home.setOnClickListener(this);
        mRadio_route = (RadioButton) findViewById(R.id.mRadio_route);
        mRadio_route.setOnClickListener(this);
        mRadio_GrabaSingle = (RadioButton) findViewById(R.id.mRadio_GrabaSingle);
        mRadio_GrabaSingle.setOnClickListener(this);
        mRadio_order = (RadioButton) findViewById(R.id.mRadio_order);
        mRadio_order.setOnClickListener(this);
        mRadio_persional = (RadioButton) findViewById(R.id.mRadio_persional);
        mRadio_persional.setOnClickListener(this);
        autorelativelayout = (AutoRelativeLayout) findViewById(R.id.mRouteTitle);
        mRouteTitle = findViewById(R.id.mRouteTitle);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRouteTitle.setVisibility(View.VISIBLE);
                        mRouteTitle.setAlpha(1);
                        mRadio_home.setChecked(true);
                        mTitle.setText("首页");
                        break;
                    case 1:
                        mRouteTitle.setVisibility(View.VISIBLE);
                        mRadio_route.setChecked(true);
                        mTitle.setText("路线");
                        break;
                    case 2:
                        mRouteTitle.setVisibility(View.VISIBLE);
                        mRadio_GrabaSingle.setChecked(true);
                        mTitle.setText("抢单");
                        break;
                    case 3:
                        mRouteTitle.setVisibility(View.GONE);
                        mRadio_order.setChecked(true);
                        mTitle.setText("订单");
                        break;
                    case 4:
                        mRouteTitle.setVisibility(View.GONE);
                        mRadio_persional.setChecked(true);
                        mTitle.setText("我的");
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTitle = (TextView) findViewById(R.id.mTitle);
        mTitle.setOnClickListener(this);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        mMessage.setOnClickListener(this);
        center_iamge = (ImageView) findViewById(R.id.center_iamge);
        center_iamge.setOnClickListener(this);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        left_icon.setOnClickListener(this);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mleft_return.setOnClickListener(this);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        xiaoxitv_num.setOnClickListener(this);
        center_iamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });
        changeRadioImageSize(mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup));
    }
    private void changeRadioImageSize(RadioGroup rg){
        int childCount = rg.getChildCount();
        for(int i = 0 ; i < childCount;i++){
            RadioButton childAt = (RadioButton) rg.getChildAt(i);
            Drawable[] drs = childAt.getCompoundDrawables();
            //防止元素为空
            if(drs[1]==null)
                continue;
            //获取drawables
            Rect r = new Rect(0, 0, drs[1].getMinimumWidth()*3/4, drs[1].getMinimumHeight()*3/4);
            //定义一个Rect边界
            drs[1].setBounds(r);
            //给drawable设置边界
            childAt.setCompoundDrawables(null,drs[1],null,null);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mRadio_home:
                mViewPager.setCurrentItem(0);
                mTitle.setText("首页");

                break;
            case R.id.mRadio_route:
                mViewPager.setCurrentItem(1);
                mTitle.setText("路线");

                break;
            case R.id.mRadio_GrabaSingle:
                mViewPager.setCurrentItem(2);
                mTitle.setText("抢单");

                break;
            case R.id.mRadio_order:
                mViewPager.setCurrentItem(3);
                mTitle.setText("订单");
                break;
            case R.id.mRadio_persional:
                mViewPager.setCurrentItem(4);
                mTitle.setText("我的");
                break;
            case R.id.mMessage:
                startActivity(MessageActivity.class);
                break;
        }
    }


}
