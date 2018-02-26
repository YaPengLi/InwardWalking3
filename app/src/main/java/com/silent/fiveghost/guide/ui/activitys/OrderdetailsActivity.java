package com.silent.fiveghost.guide.ui.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.silent.fiveghost.guide.ui.fragments.order.DateBeans;
import com.silent.fiveghost.guide.ui.fragments.order.DateRecAdapter;
import com.silent.fiveghost.guide.ui.fragments.order.Lv_Item_TouristEvaluation_Adapter;
import com.silent.fiveghost.guide.ui.fragments.order.SystemBarTintManager;
import com.silent.fiveghost.guide.ui.fragments.order.TouristEvaluationBean;
import com.zhy.autolayout.AutoLinearLayout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 订单详情
 */
public class OrderdetailsActivity extends BaseActivity {

    private ListView lv_pingjia_youke;
    private ImageView iv_back;
    private RelativeLayout rl;
    private ImageView iv_iamge_big;
    private TextView tv_content;
    private TextView tv_renminbi_chengren;
    private TextView tv_renminbi_ertong;
    private TextView tv_one_miaoshu;
    private TextView tv_two_mianshu;
    private TextView tv_three_mianshu;
    private TextView tv_four_mianshu;
    private TextView tv_five_mianshu;
    private TextView tv_tuanduichaoguoshiren;
    private TextView tv_lijianyiqianyuan;
    private ImageView iv_gengguoyouhui;
    private RecyclerView rv_riqi;
    private TextView tv_gengduoriqi;
    private RelativeLayout rl_gengduoriqi;
    private MapView mv_ditu;
    private ImageView iv_touxiang_one;
    private ImageView iv_touxiang_two;
    private ImageView iv_touxiang_three;
    private ImageView iv_touxiang_four;
    private TextView tv_ren_num;
    private LinearLayout ll_baoming;
    private TextView tv_pingfen_num;


    private MyLocationStyle myLocationStyle;
    private AMap aMap;
    //获取经度
    private double longitude;
    //获取纬度
    private double latitude;
    /**
     * 声明定位回调监听器
     */
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //定位成功回调信息，设置相关消息
                    amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    amapLocation.getLatitude();//获取纬度
                    amapLocation.getLongitude();//获取经度
                    amapLocation.getAccuracy();//获取精度信息
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(amapLocation.getTime());
                    df.format(date);//定位时间
                    amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    amapLocation.getCountry();//国家信息
                    amapLocation.getProvince();//省信息
                    amapLocation.getCity();//城市信息
                    amapLocation.getDistrict();//城区信息
                    amapLocation.getStreet();//街道信息
                    amapLocation.getStreetNum();//街道门牌号信息
                    amapLocation.getCityCode();//城市编码
                    amapLocation.getAdCode();//地区编码
                    amapLocation.getAoiName();//获取当前定位点的AOI信息
                    latitude = amapLocation.getLatitude();
                    longitude = amapLocation.getLongitude();
                    Log.v("pcw", "lat : " + latitude + " lon : " + longitude);

                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    };
    private ImageView iv_ditu;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        initView();
        Glide.with(this).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1889121316,2537834390&fm=27&gp=0.jpg").into(iv_iamge_big);
        mapview(savedInstanceState);
        yincang();
        ArrayList<TouristEvaluationBean> touristEvaluationBean = new ArrayList<>();
        touristEvaluationBean.add(new TouristEvaluationBean("http://img0.imgtn.bdimg.com/it/u=2723687026,1914356634&fm=27&gp=0.jpg", "薛之谦", "12", "sdfsdfsdfsdfsd"));
        Lv_Item_TouristEvaluation_Adapter lv_item_touristEvaluation_adapter = new Lv_Item_TouristEvaluation_Adapter(touristEvaluationBean, this);
        lv_pingjia_youke.setAdapter(lv_item_touristEvaluation_adapter);
        lv_pingjia_youke.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(OrderdetailsActivity.this, OrderGrabbingServiceActivity.class));
            }
        });


        ArrayList<DateBeans> dateBeans = new ArrayList<>();
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        DateRecAdapter dateRecAdapter = new DateRecAdapter(dateBeans);
        LinearLayoutManager manager = new LinearLayoutManager(OrderdetailsActivity.this);
        manager.setOrientation(OrientationHelper.HORIZONTAL);
        rv_riqi.setLayoutManager(manager);
        rv_riqi.setAdapter(dateRecAdapter);

    }

    private void mapview(Bundle savedInstanceState) {
        mv_ditu.onCreate(savedInstanceState);

        if (aMap == null) {
            aMap = mv_ditu.getMap();
            aMap.stopAnimation();
        }


        //初始化定位
        myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(2000);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);
        myLocationStyle.showMyLocation(true);

        //截图
        aMap.getMapScreenShot(new AMap.OnMapScreenShotListener() {
            @Override
            public void onMapScreenShot(Bitmap bitmap) {

            }

            @Override
            public void onMapScreenShot(Bitmap bitmap, int i) {
//                iv_iamge_big.setImageBitmap(bitmap);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                if (null == bitmap) {
                    return;
                }
                //保存截图
                try {
                    FileOutputStream fos = new FileOutputStream(
                            Environment.getExternalStorageDirectory() + "/test_"
                                    + sdf.format(new Date()) + ".png");
                    boolean b = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

                    try {
                        fos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    StringBuffer buffer = new StringBuffer();

                    if (b)
                        buffer.append("截屏成功 ");
                    else {
                        buffer.append("截屏失败 ");
                    }

                    if (i != 0)
                        buffer.append("地图渲染完成，截屏无网格");
                    else {
                        buffer.append("地图未渲染完成，截屏有网格");
                    }

                    Toast.makeText(OrderdetailsActivity.this, buffer.toString(), Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // 设置当前地图显示为当前位置
        longitude = 116.164023;
        latitude = 40.180514;
        LatLng latLng = new LatLng(116.164023, 40.180514);
        Marker marker = aMap.addMarker(new MarkerOptions()
                .draggable(false)//可拖拽
                .setFlat(false)//将Marker设置为贴地显示，可以双指下拉看效果
                .icon(BitmapDescriptorFactory
                        .fromResource(R.mipmap.weizhi2x))//Marker图标
                .title("marker标记")//标题
                .position(latLng));

        //显示InfoWindow
        if (!marker.isInfoWindowShown()) {
            marker.showInfoWindow();
        }
        //Marker点击事件
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {

                return false;
            }
        });

    }


    /**
     * 沉浸式导航栏
     */
    private void yincang() {
        //Android4.4及以上版本才能设置此效果
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Android5.0版本
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            } else {
                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                //创建状态栏的管理实例
                SystemBarTintManager tintManager = new SystemBarTintManager(this);
                //激活状态栏设置
                tintManager.setStatusBarTintEnabled(true);
                //设置状态栏颜色
//                tintManager.setTintResource(R.color.color);
                //激活导航栏设置
                tintManager.setNavigationBarTintEnabled(true);
                //设置导航栏颜色
//                tintManager.setNavigationBarTintResource(R.color.color);
            }
        }
    }

    private void initView() {
        lv_pingjia_youke = (ListView) findViewById(R.id.lv_pingjia_youke);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        rl = (RelativeLayout) findViewById(R.id.rl);
        iv_iamge_big = (ImageView) findViewById(R.id.iv_iamge_big);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_renminbi_chengren = (TextView) findViewById(R.id.tv_renminbi_chengren);
        tv_renminbi_ertong = (TextView) findViewById(R.id.tv_renminbi_ertong);
        tv_one_miaoshu = (TextView) findViewById(R.id.tv_one_miaoshu);
        tv_two_mianshu = (TextView) findViewById(R.id.tv_two_mianshu);
        tv_three_mianshu = (TextView) findViewById(R.id.tv_three_mianshu);
        tv_four_mianshu = (TextView) findViewById(R.id.tv_four_mianshu);
        tv_five_mianshu = (TextView) findViewById(R.id.tv_five_mianshu);
        tv_tuanduichaoguoshiren = (TextView) findViewById(R.id.tv_tuanduichaoguoshiren);
        tv_lijianyiqianyuan = (TextView) findViewById(R.id.tv_lijianyiqianyuan);
        iv_gengguoyouhui = (ImageView) findViewById(R.id.iv_gengguoyouhui);
        rv_riqi = (RecyclerView) findViewById(R.id.rv_riqi);
        tv_gengduoriqi = (TextView) findViewById(R.id.tv_gengduoriqi);
        rl_gengduoriqi = (RelativeLayout) findViewById(R.id.rl_gengduoriqi);
        mv_ditu = (MapView) findViewById(R.id.mv_ditu);
        iv_touxiang_one = (ImageView) findViewById(R.id.iv_touxiang_one);
        iv_touxiang_two = (ImageView) findViewById(R.id.iv_touxiang_two);
        iv_touxiang_three = (ImageView) findViewById(R.id.iv_touxiang_three);
        iv_touxiang_four = (ImageView) findViewById(R.id.iv_touxiang_four);
        tv_ren_num = (TextView) findViewById(R.id.tv_ren_num);
        ll_baoming = (LinearLayout) findViewById(R.id.ll_baoming);
        tv_pingfen_num = (TextView) findViewById(R.id.tv_pingfen_num);
        iv_ditu = (ImageView) findViewById(R.id.iv_ditu);

        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);

        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("订单详情");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        mleft_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderdetailsActivity.this.finish();
                ;
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mv_ditu.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mv_ditu.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mv_ditu.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mv_ditu.onSaveInstanceState(outState);
    }
}
