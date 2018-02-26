package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.TabFragmentPagerAdapter;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.ui.fragments.LiaotianFragment;
import com.silent.fiveghost.guide.ui.fragments.TongzhiFragment;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton bt_tongzhi;
    private RadioButton bt_liaotian;
    private ViewPager vp;
    private List<Fragment> list;
    private TabFragmentPagerAdapter adapter;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private RadioGroup mMessage_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();
        list = new ArrayList<>();
        list.add(new TongzhiFragment());
        list.add(new LiaotianFragment());
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        vp.setCurrentItem(0);  //初始化显示第一个页面
    }

    private void initView() {
        bt_tongzhi = (RadioButton) findViewById(R.id.bt_tongzhi);
        bt_liaotian = (RadioButton) findViewById(R.id.bt_liaotian);
        bt_tongzhi.setOnClickListener(this);
        bt_liaotian.setOnClickListener(this);
        vp = (ViewPager) findViewById(R.id.vp);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("消息");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(this);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                RadioButton childAt = (RadioButton) mMessage_group.getChildAt(position);
                childAt.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mMessage_group = (RadioGroup) findViewById(R.id.mMessage_group);
        mMessage_group.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        v.setFocusable(true);
        v.requestFocus();
        v.requestFocusFromTouch();
        switch (v.getId()) {
            case R.id.bt_tongzhi:
                vp.setCurrentItem(0);
                break;
            case R.id.bt_liaotian:
                vp.setCurrentItem(1);
                break;
            case R.id.mleft_return:
                finish();
                break;
        }
    }
}
