package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.SendEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.tools.Tools;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.HashMap;
import java.util.Map;

public class FindPwdActivity extends BaseActivity implements View.OnClickListener {

    private EditText user_phone;
    private TextView user_getyzm;
    private EditText user_Yzm;
    private EditText user_newpwd;
    private Button user_submit;
    private SendEntity s;
    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private AutoLinearLayout mleft_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
        initView();

    }

    private void initView() {
        user_phone = (EditText) findViewById(R.id.findpwd_user_phones);
        user_getyzm = (TextView) findViewById(R.id.findpwd_user_getyzm);
        user_Yzm = (EditText) findViewById(R.id.findpwd_user_Yzms);
        user_newpwd = (EditText) findViewById(R.id.findpwd_user_newpwd);
        user_submit = (Button) findViewById(R.id.findpwd_user_submit);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        user_submit.setOnClickListener(this);
        user_getyzm.setOnClickListener(this);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitle.setText("找回密码");
        mMessage = (ImageView) findViewById(R.id.mMessage);
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        xiaoxitv_num.setVisibility(View.GONE);
    }

    //auth/reset-password
    private void submit() {
      /*  if(s==null){
            Toast.makeText(this, "请先获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }*/
        Presenters p = new Presenters(FindPwdActivity.this, new Iview<String>() {
            @Override
            public void success(String s) {
//                Toast.makeText(FindPwdActivity.this, s.getErrcode()+"--"+s.getData()+"--"+s.getErrmsg(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(FindPwdActivity.this, s.getErrcode()+"--"+s.getData()+"--"+s.getErrmsg(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", s);
            }


            @Override
            public void failure(Throwable e) {
                Toast.makeText(FindPwdActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Map<String, String> mParams = new HashMap();
        String phone = user_phone.getText().toString().trim();
        if (!Tools.isPhone(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        mParams.put("tel", phone);
        mParams.put("password", user_newpwd.getText().toString());
        mParams.put("code", user_Yzm.getText().toString());
        p.requestNews(Concat.AUTH_RESET_PASSWORD, mParams);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.findpwd_user_submit:
                submit();
                break;
            case R.id.findpwd_user_getyzm:
                getyzm();
                break;
        }
    }

    private void getyzm() {
        Presenters p = new Presenters(FindPwdActivity.this, new Iview<SendEntity>() {
            @Override
            public void success(SendEntity s) {
                FindPwdActivity.this.s = s;
            }

            @Override
            public void failure(Throwable e) {
                Toast.makeText(FindPwdActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Map<String, String> mParams = new HashMap();
        String phone = user_phone.getText().toString().trim();
        if (!Tools.isPhone(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        mParams.put("mobile", phone);
        mParams.put("module", "1");
        mParams.put("imei", Tools.getPhoneIMEI(this));
        p.requestNews(Concat.GERYZM_URL, mParams);
    }
}
