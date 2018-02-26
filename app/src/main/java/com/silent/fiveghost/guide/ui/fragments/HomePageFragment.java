package com.silent.fiveghost.guide.ui.fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.HomeCenterAdapter;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;


public class HomePageFragment extends Fragment implements View.OnClickListener {

    private CardView vp_banner;
    private TextView tv_passenger;
    private TextView tv_travel;
    private AutoLinearLayout linearLayout;
    private TextView tv_liner;
    private ViewPager vp_center;
    private ArrayList<Fragment> list;
    private HomeCenterAdapter adapter;
    private FlyBanner mHomepage_flybanner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        initView(view);
        initDate();
        return view;
    }



    private void initDate() {
        list = new ArrayList<>();
        list.add(new HomePagerPassengerFragment());
        list.add(new HomePagerTravelAgencyFragment());
        adapter = new HomeCenterAdapter(getActivity().getSupportFragmentManager(), list, getContext());
        vp_center.setAdapter(adapter);
        vp_center.setCurrentItem(0);
        vp_center.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        vp_center.setCurrentItem(0);
                        initPassenger();
                        break;
                    case 1:
                        initTravel();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView(View view) {

        vp_banner = (CardView) view.findViewById(R.id.vp_banner);
        mHomepage_flybanner = (FlyBanner) view.findViewById(R.id.mHomepage_flybanner);
        tv_passenger = (TextView) view.findViewById(R.id.tv_passenger);
        tv_travel = (TextView) view.findViewById(R.id.tv_travel);
        linearLayout = (AutoLinearLayout) view.findViewById(R.id.linearLayout);
        tv_liner = (TextView) view.findViewById(R.id.tv_liner);
        vp_center = (ViewPager) view.findViewById(R.id.vp_center);
        tv_passenger.setOnClickListener(this);
        tv_travel.setOnClickListener(this);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("http://img2.imgtn.bdimg.com/it/u=450661653,1173553667&fm=27&gp=0.jpg");
        strings.add("http://img0.imgtn.bdimg.com/it/u=2921208321,2605531147&fm=27&gp=0.jpg");
        strings.add("http://img3.imgtn.bdimg.com/it/u=3877126187,4056127982&fm=27&gp=0.jpg");
        strings.add("http://img4.imgtn.bdimg.com/it/u=3877126187,4056127982&fm=27&gp=0.jpg");
        strings.add("http://img5.imgtn.bdimg.com/it/u=3877126187,4056127982&fm=27&gp=0.jpg");
        mHomepage_flybanner.setImagesUrl(strings);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_passenger:
                vp_center.setCurrentItem(0);
                initPassenger();
                break;
            case R.id.tv_travel:
                initTravel();
                break;
        }
    }

    private void initTravel() {
        vp_center.setCurrentItem(1);
        tv_travel.setTextColor(Color.parseColor("#00cd96"));
        tv_travel.setBackgroundColor(Color.parseColor("#232730"));
        tv_passenger.setTextColor(Color.BLACK);
        tv_passenger.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void initPassenger() {
        tv_passenger.setTextColor(Color.parseColor("#00cd96"));
        tv_passenger.setBackgroundColor(Color.parseColor("#232730"));
        tv_travel.setTextColor(Color.BLACK);
        tv_travel.setBackgroundColor(Color.parseColor("#ffffff"));
    }
}
