package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.MyRouteAadapter;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

public class MyRouteActivity extends BaseActivity implements View.OnClickListener {

    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private RecyclerView mRecycler;
    private AutoLinearLayout mleft_return;
    private ImageView route_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_route);
        initView();
    }

    private void initView() {
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        route_add = (ImageView) findViewById(R.id.route_add);
        route_add.setOnClickListener(this);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("我的路线");
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyRouteActivity.this.finish();
                ;
            }
        });
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        MyRouteAadapter aadapter = new MyRouteAadapter(this);
        mRecycler.setAdapter(aadapter);

        aadapter.setOnClickListener(new MyRouteAadapter.OnClickListener() {
            @Override
            public void onClick(int position, int type) {
                /**
                 * 1 是跳转详情
                 * 2 是发布
                 */
                switch (type) {
                    case 1:
                        startActivity(ReleaseRouteActivity.class);
                        break;
                    case 2:
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.route_add:
//                startActivity(MyReleaseRouteActivity.class);
                //跳转到路线模版 Route template
                startActivity(RouteTemplateActivity.class);
                break;
        }
    }
}
