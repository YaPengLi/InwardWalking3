package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.FiinanciaAdapte;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

public class FinancialFlowActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView finacial_flow_recycler;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_flow);
        initView();
    }

    private void initView() {
        finacial_flow_recycler = (RecyclerView) findViewById(R.id.finacial_flow_recycler);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("财务流水");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(this);

        finacial_flow_recycler.setLayoutManager(new LinearLayoutManager(this));
        FiinanciaAdapte adapte = new FiinanciaAdapte(this);
        finacial_flow_recycler.setAdapter(adapte);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mleft_return:
                finish();
                break;

        }
    }
}
