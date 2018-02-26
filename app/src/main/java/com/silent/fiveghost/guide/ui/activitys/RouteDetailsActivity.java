package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.RouteAdapter;
import com.silent.fiveghost.guide.adapter.RouteDetailsAadapter;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.RouteDetailsEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.ui.fragments.order.parallaxheader.HeadZoomScrollView;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * 路线详情
 */
public class RouteDetailsActivity extends BaseActivity implements Iview<RouteDetailsEntity>{

    private RecyclerView mRoute_details_recyclerview;
    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private ImageView mheader_iamge;
    private ImageView mRotedetails_iamge;
    private RouteDetailsAadapter aadapter;
    private String rid;
    private Presenters p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        rid = getIntent().getStringExtra("rid");
        initView();
        p = new Presenters(this,this);
        p.requestNews(Concat.DETAILS_OF_THE_ROUTE+rid);
    }

    private void initView() {
        mRoute_details_recyclerview = (RecyclerView) findViewById(R.id.mRoute_details_recyclerview);
        HeadZoomScrollView mRoute_scrollview = (HeadZoomScrollView) findViewById(R.id.mRoute_scrollview);
        mRoute_details_recyclerview.setNestedScrollingEnabled(false);
        View view = LayoutInflater.from(this).inflate(R.layout.rotedetails_recyclerheader, null);
        mRoute_details_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        aadapter = new RouteDetailsAadapter(this);
        mRoute_details_recyclerview.setAdapter(aadapter);
        aadapter.setOnClickListener(new RouteAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                showToast(position + "");
            }
        });
        left_icon = (ImageView) findViewById(R.id.left_icon);
        AutoLinearLayout mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("路线详情");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteDetailsActivity.this.finish();
                ;
            }
        });
        mRotedetails_iamge = (ImageView) findViewById(R.id.mRotedetails_iamge);
        mRoute_scrollview.smoothScrollTo(0,0);
    }

    @Override
    public void success(RouteDetailsEntity routeDetailsEntity) {
        Log.e("TAG",routeDetailsEntity.getData().toString());
    }

    @Override
    public void failure(Throwable e) {

    }
}
