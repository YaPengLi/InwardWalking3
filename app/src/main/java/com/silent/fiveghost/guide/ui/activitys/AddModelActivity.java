package com.silent.fiveghost.guide.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.GalleryAdapter;
import com.silent.fiveghost.guide.tools.GlideImageLoader;
import com.silent.fiveghost.guide.tools.SpacesItemDecoration;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AddModelActivity extends BaseActivity implements View.OnClickListener, GalleryAdapter.OnRecyclerViewItemClickListener {

    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private EditText et_luxianmingcheng;
    private Spinner et_youwantianshu;
    private EditText et_luxianmiaoshu;
    private EditText et_baomingxuzhi;
    private EditText et_wenxintishi;
    private EditText et_zhyishixiang;
    private static final int IMAGE_PICKER = 100;
    private RecyclerView mRecyclerView;
    private List<ImageItem> mList = new ArrayList();
    private GalleryAdapter mAdapter;
    private ImagePicker imagePicker;
    public static final String tag = "rootView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        initView();
        initPicker();
    }

    private void initView() {
        et_luxianmingcheng = (EditText) findViewById(R.id.et_luxianmingcheng);
        et_youwantianshu = (Spinner) findViewById(R.id.et_youwantianshu);
        et_luxianmiaoshu = (EditText) findViewById(R.id.et_luxianmiaoshu);
        et_baomingxuzhi = (EditText) findViewById(R.id.et_baomingxuzhi);
        et_wenxintishi = (EditText) findViewById(R.id.et_wenxintishi);
        et_zhyishixiang = (EditText) findViewById(R.id.et_zhyishixiang);
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mleft_return.setOnClickListener(this);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("添加模版");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mAdapter = new GalleryAdapter(this,mList);
        mAdapter.setOnItemClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(30));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mleft_return:
                finish();
                break;

        }
    }
    private void initPicker() {
        imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }
    @Override
    public void onItemClick(View view, int position) {
        switch (view.getId()){
            case R.id.mImageView_Jian:
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.mImageView:
                if (mAdapter.getItemCount()<= 9 && position == mAdapter.getItemCount() - 1){
                    Intent intent = new Intent(this, ImageGridActivity.class);
                    startActivityForResult(intent, IMAGE_PICKER);
                }
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                mList.addAll(images);
                mAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
