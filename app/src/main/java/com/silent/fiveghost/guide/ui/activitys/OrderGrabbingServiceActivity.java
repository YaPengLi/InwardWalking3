package com.silent.fiveghost.guide.ui.activitys;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.OGSPageAdapter;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.ui.fragments.order.ogsfragment.CompletedFragment;
import com.silent.fiveghost.guide.ui.fragments.order.ogsfragment.InProgressFragment;
import com.silent.fiveghost.guide.ui.fragments.order.ogsfragment.NotStartedFragment;

import java.util.ArrayList;

public class OrderGrabbingServiceActivity extends BaseActivity {

    private ImageView iv_back;
    private RelativeLayout rl;
    private TabLayout tb;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_grabbing_service);
        initView();
        OGSPageAdapter ogsPageAdapter = new OGSPageAdapter(getSupportFragmentManager());
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NotStartedFragment());
        fragments.add(new InProgressFragment());
        fragments.add(new CompletedFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("未开始");
        strings.add("进行中");
        strings.add("已完成");
        ogsPageAdapter.setData(fragments);
        ogsPageAdapter.setTitles(strings);
        vp.setAdapter(ogsPageAdapter);
        tb.setupWithViewPager(vp);

    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rl = (RelativeLayout) findViewById(R.id.rl);
        tb = (TabLayout) findViewById(R.id.tb);
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
