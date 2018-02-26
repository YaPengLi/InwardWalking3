package com.silent.fiveghost.guide.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.HomePagerListAdapter;
import com.silent.fiveghost.guide.entity.HomeItemBean;
import com.silent.fiveghost.guide.ui.activitys.ReservationOrderActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePagerPassengerFragment extends Fragment implements AdapterView.OnItemClickListener {


    private ListView lv_home;
    private ArrayList<HomeItemBean> beanslist;
    public HomePagerPassengerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_pager_below, container, false);
        initView(view);
        initDate();
        return view;
    }
    private void initDate() {
        beanslist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            beanslist.add(new HomeItemBean("城市：丽江",
                    "时间：2018.01.20至2018.02.24",
                    "人数：4人","旅游偏好：自然风景","订单类型：一站式"));
        }
        HomePagerListAdapter adapter = new HomePagerListAdapter(getContext(), beanslist);
        lv_home.setAdapter(adapter);
        lv_home.setOnItemClickListener(this);

    }
    private void initView(View view) {
        lv_home = (ListView) view.findViewById(R.id.lv_home);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(), ReservationOrderActivity.class);
        intent.putExtra("passenger","passenger");
        startActivity(intent);
    }
}
