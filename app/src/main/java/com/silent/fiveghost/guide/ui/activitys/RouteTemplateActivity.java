package com.silent.fiveghost.guide.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.MyReleaseRouteActivity;
import com.silent.fiveghost.guide.adapter.RouteTemplateAadapter;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.RouteTemolateEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Route;

public class RouteTemplateActivity extends BaseActivity implements Iview<RouteTemolateEntity>{

    private RecyclerView route_template;
    private ImageView route_add;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private List<RouteTemolateEntity.DataBean.ItemsBean> mData = new ArrayList<>();
    private Presenters p;
    private RouteTemplateAadapter aadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_template);
        p = new Presenters(this,this);
        initView();
        p.requestNews(Concat.LINE_TEMPLATE_LIST_INTERFACE);
    }

    private void initView() {
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        route_add = (ImageView) findViewById(R.id.route_add);
        route_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 添加模版
                startActivity(AddModelActivity.class);
            }
        });
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("路线模版");
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
                ;
            }
        });
        route_template = (RecyclerView) findViewById(R.id.route_template);
        route_template.setLayoutManager(new LinearLayoutManager(this));
        aadapter = new RouteTemplateAadapter(this,mData);
        route_template.setAdapter(aadapter);
        aadapter.setOnClickListener(new RouteTemplateAadapter.OnClickListener() {
            @Override
            public void onClick(int position, int type) {
                Intent intent = new Intent(RouteTemplateActivity.this, DetailsOfMyRouteActivity.class);
                intent.putExtra("rid",mData.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    public void success(RouteTemolateEntity routeTemolateEntity) {
        Log.e("TAG","成功："+routeTemolateEntity.toString());
        mData.addAll(routeTemolateEntity.getData().getItems());
        aadapter.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {
        Log.e("TAG","失败："+e.toString());
    }
}
