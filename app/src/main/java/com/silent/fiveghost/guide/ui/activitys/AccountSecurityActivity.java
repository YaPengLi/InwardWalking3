package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener {

    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private AutoLinearLayout shoujihao;
    private AutoLinearLayout xiugaimima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);
        initView();
    }

    private void initView() {
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        shoujihao = (AutoLinearLayout) findViewById(R.id.shoujihao);
        xiugaimima = (AutoLinearLayout) findViewById(R.id.xiugaimima);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("帐号安全");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(this);
        shoujihao.setOnClickListener(this);
        xiugaimima.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mleft_return:
                finish();
                break;
            case R.id.shoujihao:
                startActivity(CellPhoneNumberActivity.class);
                break;
            case R.id.xiugaimima:
                startActivity(UpdatePwdActivity.class);
                break;
        }
    }
}
