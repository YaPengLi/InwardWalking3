package com.silent.fiveghost.guide.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.tools.GlideImageLoader;
import com.silent.fiveghost.guide.tools.SpacesItemDecoration;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.views.CustomDatePicker;
import com.zhy.autolayout.AutoLinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyReleaseRouteActivity extends BaseActivity implements View.OnClickListener, GalleryAdapter.OnRecyclerViewItemClickListener {

    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private static final int IMAGE_PICKER = 100;
    private RecyclerView mRecyclerView;
    private List<ImageItem> mList = new ArrayList();
    private GalleryAdapter mAdapter;
    private ImagePicker imagePicker;
    public static final String tag = "rootView";
    private String type;
    private String title;
    private TextView mFabuOrWanCheng;
    private CustomDatePicker customDatePicker1;
    private TextView currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrelease_route);
        type = getIntent().getStringExtra("type");
        title = getIntent().getStringExtra("title");
        initView();
        initPicker();
        initDatePicker();
        currentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDatePicker1.show(currentDate.getText().toString());
            }
        });
    }

    private void initView() {

        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText(title);
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mAdapter = new GalleryAdapter(this, mList);
        mAdapter.setOnItemClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(30));
        mRecyclerView.setAdapter(mAdapter);
        mFabuOrWanCheng = (TextView) findViewById(R.id.mFabuOrWanCheng);
        mFabuOrWanCheng.setText(type);
        mFabuOrWanCheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("发布".equals(mFabuOrWanCheng.getText())) {
                    Toast.makeText(MyReleaseRouteActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyReleaseRouteActivity.this, "编辑成功", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
        currentDate = (TextView) findViewById(R.id.currentDate);
        currentDate.setOnClickListener(this);
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
        switch (view.getId()) {
            case R.id.mImageView_Jian:
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.mImageView:
                if (mAdapter.getItemCount() <= 9 && position == mAdapter.getItemCount() - 1) {
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

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        currentDate.setText(now.split(" ")[0]);
//        currentTime.setText(now);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                currentDate.setText(time.split(" ")[0]);
            }
        }, "2010-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

/*        customDatePicker2 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                currentTime.setText(time);
            }
        }, "2010-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 显示时和分
        customDatePicker2.setIsLoop(true); // 允许循环滚动*/
    }

}
