package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.MyReleaseRouteActivity;
import com.silent.fiveghost.guide.adapter.ReleaseRouteAdapter;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * 我的路线详情
 */

public class ReleaseRouteActivity extends BaseActivity implements View.OnClickListener {

    private XRecyclerView mActivity_release_route_recyclerview;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private TextView fabu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_route);
        initView();
    }


    private void initView() {
        mActivity_release_route_recyclerview = (XRecyclerView) findViewById(R.id.mActivity_release_route_recyclerview);
        mActivity_release_route_recyclerview.setLoadingMoreEnabled(false);
        mActivity_release_route_recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mActivity_release_route_recyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mActivity_release_route_recyclerview.refreshComplete();
            }
        });
        left_icon = (ImageView) findViewById(R.id.left_icon);
        left_icon.setBackgroundResource(R.mipmap.a);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_release_route_headerview, null);


        mActivity_release_route_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        ReleaseRouteAdapter adapter = new ReleaseRouteAdapter(this);
        mActivity_release_route_recyclerview.setAdapter(adapter);
        mActivity_release_route_recyclerview.addHeaderView(view);

        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                ;
            }
        });
        mTitle = (TextView) findViewById(R.id.mTitle);
        mTitle.setText("路线详情");
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        fabu = (TextView) findViewById(R.id.fabu);
        fabu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabu:
                startActivity(MyReleaseRouteActivity.class);
                break;
        }
    }
}
