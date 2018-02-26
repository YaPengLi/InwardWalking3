package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

public class TouristOrderDetailsActivity extends BaseActivity implements View.OnClickListener {

    private FlyBanner fb;
    private TextView tv_dingdanbianhao;
    private TextView tv_luxianmingcheng;
    private TextView tv_youkexingming;
    private TextView tv_youkenianlingduan;
    private TextView tv_chuxingshijian;
    private TextView tv_num;
    private TextView tv_chanpindingwei;
    private TextView tv_jiudiantisheng;
    private TextView tv_jingdianshengji;
    private ImageView iv_iamge_difangjieshao;
    private ImageView iv_iamge_difangluxian;
    private AutoLinearLayout bt_qiangdan;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private AutoRelativeLayout tourist_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_order_details);
        initView();
        ArrayList<String> datas = new ArrayList<>();
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1727626821,1930627673&fm=27&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3190678245,91613417&fm=27&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3609169027,3978886159&fm=27&gp=0.jpg");
        fb.setImagesUrl(datas);
    }


    private void initView() {
        fb = (FlyBanner) findViewById(R.id.fb);
        tv_dingdanbianhao = (TextView) findViewById(R.id.tv_dingdanbianhao);
        tv_luxianmingcheng = (TextView) findViewById(R.id.tv_luxianmingcheng);
        tv_youkexingming = (TextView) findViewById(R.id.tv_youkexingming);
        tv_youkenianlingduan = (TextView) findViewById(R.id.tv_youkenianlingduan);
        tv_chuxingshijian = (TextView) findViewById(R.id.tv_chuxingshijian);
        tv_num = (TextView) findViewById(R.id.tv_num);
        tv_chanpindingwei = (TextView) findViewById(R.id.tv_chanpindingwei);
        tv_jiudiantisheng = (TextView) findViewById(R.id.tv_jiudiantisheng);
        tv_jingdianshengji = (TextView) findViewById(R.id.tv_jingdianshengji);
        iv_iamge_difangjieshao = (ImageView) findViewById(R.id.iv_iamge_difangjieshao);
        iv_iamge_difangluxian = (ImageView) findViewById(R.id.iv_iamge_difangluxian);
        bt_qiangdan = (AutoLinearLayout) findViewById(R.id.bt_autolinear);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("详情");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.mleft_return:
                finish();
                break;
        }
    }
}
