package com.silent.fiveghost.guide.adapter.grabaSingleAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 农民伯伯 on 2018/1/31.
 */

public class GrabaViewPagerAdapter extends FragmentPagerAdapter {

    private  ArrayList<Fragment> fragments;

    public GrabaViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
