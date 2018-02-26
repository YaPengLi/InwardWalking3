package com.silent.fiveghost.guide.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.RouteAdapter;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.RouteEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.ui.activitys.RouteDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 84682 on 2018/1/27.
 */

public class RouteFragment extends Fragment implements Iview<RouteEntity>{
    private RecyclerView mRecyclerView;
    private Presenters p;
    private List<RouteEntity.DataBean.ItemsBean> mData  =new ArrayList<>();
    private RouteAdapter routeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        p = new Presenters(getActivity(),this);
        initView(view);
        p.requestNews(Concat.GUIDE_LINE_LIST_INTERFACE);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mHomeListView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        routeAdapter = new RouteAdapter(getActivity(),mData);
        mRecyclerView.setAdapter(routeAdapter);
        routeAdapter.setOnClickListener(new RouteAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), RouteDetailsActivity.class);
                intent.putExtra("rid",mData.get(position-1).getRid());
                startActivity(intent);
            }
        });
    }

    @Override
    public void success(RouteEntity routeEntity) {
        mData.addAll(routeEntity.getData().getItems());
        routeAdapter.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {

    }
}
