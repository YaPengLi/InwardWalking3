package com.silent.fiveghost.guide.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 84682 on 2018/1/27.
 */

public class FPAdapter extends FragmentPagerAdapter {

    private  List<Fragment> mData;

    public FPAdapter(FragmentManager fm, List<Fragment> mData) {
        super(fm);
        this.mData = mData;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }


    @Override
    public int getCount() {
        return mData.size();
    }
}
