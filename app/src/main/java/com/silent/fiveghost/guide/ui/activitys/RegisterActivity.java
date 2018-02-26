package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.SendEntity;
import com.silent.fiveghost.guide.entity.SignupEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.tools.Tools;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText mInsert_name;
    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private EditText mYqm;
    private TextView getYzm;
    private Button mRegister_btn;
    private SendEntity s;
    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private AutoLinearLayout mleft_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        mInsert_name = (EditText) findViewById(R.id.register_mInsert_name);
        mInsert_phone = (EditText) findViewById(R.id.regiser_user_phone);
        mInsert_yzm = (EditText) findViewById(R.id.regiser_user_Yzm);
        mInsert_pwd = (EditText) findViewById(R.id.regisertuser_pwd);
        mYqm = (EditText) findViewById(R.id.regiser_mYqm);
        getYzm = (TextView) findViewById(R.id.regiser_getYzm);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        getYzm.setOnClickListener(this);
        mRegister_btn = (Button) findViewById(R.id.mRegister_btn);
        mRegister_btn.setOnClickListener(this);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        left_icon.setBackgroundResource(R.mipmap.a);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitle.setText("注册");
        mMessage = (ImageView) findViewById(R.id.mMessage);
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        xiaoxitv_num.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regiser_getYzm:
                getyzm();
                break;
            case R.id.mRegister_btn:
                register();
                break;
        }
    }

    private void register() {
       /* if(s==null){
            Toast.makeText(this, "请获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }*/
//        boolean data = s.getData();
        Presenters p = new Presenters(this, new Iview<SignupEntity>() {

            @Override
            public void success(SignupEntity signupentity) {
                if (signupentity.getErrcode() == 1) {
                    startActivity(LoginActivity.class);
                    Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    showToast(signupentity.getErrmsg());
                }
            }

            @Override
            public void failure(Throwable e) {
                showToast(e.toString());
            }
        });
        String phone = mInsert_phone.getText().toString();
        Map<String, String> mParams = new HashMap<>();
        if (!Tools.isPhone(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        mParams.put("tel", phone);
        mParams.put("password", mInsert_pwd.getText().toString());
        mParams.put("category", "1");
        mParams.put("code", mInsert_yzm.getText().toString());
        p.requestNews(Concat.SIGNUP, mParams);
//        17718341391   8898

    }

    private void getyzm() {
        Presenters p = new Presenters(RegisterActivity.this, new Iview<SendEntity>() {
            @Override
            public void success(SendEntity s) {
                RegisterActivity.this.s = s;
                Toast.makeText(RegisterActivity.this, "验证码发送成功！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(Throwable e) {
                Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Map<String, String> mParams = new HashMap();
        String phone = mInsert_phone.getText().toString().trim();
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
