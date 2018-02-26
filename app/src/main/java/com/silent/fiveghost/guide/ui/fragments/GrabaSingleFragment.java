package com.silent.fiveghost.guide.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.grabaSingleAdapter.GrabaViewPagerAdapter;
import com.silent.fiveghost.guide.ui.fragments.grabSingleFrameLayouts.RobbedFragment;
import com.silent.fiveghost.guide.ui.fragments.grabSingleFrameLayouts.TouristFragment;
import com.silent.fiveghost.guide.ui.fragments.grabSingleFrameLayouts.TravelFragment;

import java.util.ArrayList;


/**
 * Created by 84682 on 2018/1/27.
 *  抢单
 */

public class GrabaSingleFragment extends Fragment implements View.OnClickListener {
    private TravelFragment travelFragment;
    private RobbedFragment robbedFragment;
    private TouristFragment touristFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton mBtnTourist;
    private RadioButton mBtnTravel;
    private RadioButton mBtnRobbed;
    private ViewPager mGrabaViewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private GrabaViewPagerAdapter grabaViewPagerAdapter;
    private RadioButton mGrabaBtnTourist;
    private RadioButton mGrabaBtnTravel;
    private RadioButton mGrabBtnRobbed;
    private RadioGroup mGrabaGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_a_single, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        fragments.add(new TouristFragment());
        fragments.add(new TravelFragment());
        fragments.add(new RobbedFragment());
        grabaViewPagerAdapter = new GrabaViewPagerAdapter(getChildFragmentManager(), fragments);
        mGrabaViewPager.setAdapter(grabaViewPagerAdapter);
        mGrabaViewPager.setOffscreenPageLimit(3);


    }


    private void initView(View view) {
        mGrabaViewPager = view.findViewById(R.id.mGrabaViewPager);
        mBtnTourist = view.findViewById(R.id.mGrabaBtnTourist);
        mBtnTourist.setOnClickListener(this);
        mBtnTravel = view.findViewById(R.id.mGrabaBtnTravel);
        mBtnTravel.setOnClickListener(this);
        mBtnRobbed = view.findViewById(R.id.mGrabBtnRobbed);
        mBtnRobbed.setOnClickListener(this);
        mGrabaViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton)(mGrabaGroup.getChildAt(position))).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mGrabaBtnTourist = (RadioButton) view.findViewById(R.id.mGrabaBtnTourist);
        mGrabaBtnTourist.setOnClickListener(this);
        mGrabaBtnTravel = (RadioButton) view.findViewById(R.id.mGrabaBtnTravel);
        mGrabaBtnTravel.setOnClickListener(this);
        mGrabBtnRobbed = (RadioButton) view.findViewById(R.id.mGrabBtnRobbed);
        mGrabBtnRobbed.setOnClickListener(this);
        mGrabaGroup = (RadioGroup) view.findViewById(R.id.mGrabaGroup);
        mGrabaGroup.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //旅行社
            case R.id.mGrabaBtnTourist:
                mGrabaViewPager.setCurrentItem(0);

                break;
            //游客
            case R.id.mGrabaBtnTravel:
                mGrabaViewPager.setCurrentItem(1);
                break;
            //已抢
            case R.id.mGrabBtnRobbed:
                mGrabaViewPager.setCurrentItem(2);
                break;
        }

    }

}
