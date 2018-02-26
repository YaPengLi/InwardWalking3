package com.silent.fiveghost.guide.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.MyReleaseRouteActivity;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的路线详情
 */
public class DetailsOfMyRouteActivity extends BaseActivity implements View.OnClickListener {

    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private TextView details_of_my_route_bianji;
    private FlyBanner details_of_mu_route_banner;
    private TextView details_of_mu_route_fabu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_my_route);
        initView();
    }

    private void initView() {
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        details_of_mu_route_fabu = (TextView) findViewById(R.id.details_of_mu_route_fabu);
        details_of_my_route_bianji = (TextView) findViewById(R.id.details_of_my_route_bianji);
        details_of_mu_route_fabu.setOnClickListener(this);
        details_of_my_route_bianji.setOnClickListener(this);

        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("路线详情");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(this);
        details_of_mu_route_banner = (FlyBanner) findViewById(R.id.details_of_mu_route_banner);
        details_of_mu_route_banner.setOnClickListener(this);
        List<String> mBanners = new ArrayList<>();
        mBanners.add("http://img0.imgtn.bdimg.com/it/u=3081742004,4063800044&fm=27&gp=0.jpg");
        mBanners.add("http://img0.imgtn.bdimg.com/it/u=3421096080,3115622062&fm=200&gp=0.jpg");
        mBanners.add("http://img3.imgtn.bdimg.com/it/u=203442512,2909156359&fm=27&gp=0.jpg");
        mBanners.add("http://img4.imgtn.bdimg.com/it/u=1720578917,10130279&fm=27&gp=0.jpg");


        details_of_mu_route_banner.setImagesUrl(mBanners);
        details_of_mu_route_fabu = (TextView) findViewById(R.id.details_of_mu_route_fabu);
        details_of_mu_route_fabu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mleft_return:
                this.finish();
                break;
            case R.id.details_of_mu_route_fabu:
                Intent intent = new Intent(this, MyReleaseRouteActivity.class);
                intent.putExtra("type","发布");
                intent.putExtra("title","发布路线");
                startActivity(intent);
                break;
            case R.id.details_of_my_route_bianji:
                Intent intent2 = new Intent(this, MyReleaseRouteActivity.class);
                intent2.putExtra("type","完成");
                intent2.putExtra("title","修改模版");
                startActivity(intent2);
                break;
        }
    }
}
