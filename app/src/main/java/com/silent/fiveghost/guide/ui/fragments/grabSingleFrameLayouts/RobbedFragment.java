package com.silent.fiveghost.guide.ui.fragments.grabSingleFrameLayouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.grabaSingleAdapter.GrabaSingleRobbedRecyclerViewAdapter;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.GrabaSingleBean;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;

import java.util.ArrayList;
import java.util.List;


/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/1/28.
 * 已抢订单
 */

public class RobbedFragment extends Fragment implements Iview<GrabaSingleBean> {

    private RecyclerView mRobbedRecyclerView;
    private GrabaSingleRobbedRecyclerViewAdapter grabaSingleRobbedRecyclerViewAdapter;
    private  List<GrabaSingleBean.DataBean.ItemsBean> items = new ArrayList<>();
    private int number = 0 ;
    private Presenters p;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("TAG","第"+number+"进入");

        if(isVisibleToUser==true){
            if(number>0){
                p.requestNews(Concat.GRABA_SINGLE_LIST + "&type=1");
            }
            number++;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_robbed, container, false);
        mRobbedRecyclerView = view.findViewById(R.id.mRobbedRecyclerView);
        p = new Presenters(getContext(), this);
        p.requestNews(Concat.GRABA_SINGLE_LIST+"&type=3");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRobbedRecyclerView.setLayoutManager(linearLayoutManager);
        grabaSingleRobbedRecyclerViewAdapter = new GrabaSingleRobbedRecyclerViewAdapter(getContext(),items);
        mRobbedRecyclerView.setAdapter(grabaSingleRobbedRecyclerViewAdapter);
        grabaSingleRobbedRecyclerViewAdapter.setmOnItemClickListener(new GrabaSingleRobbedRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Toast.makeText(getContext(), "已抢".toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void success(GrabaSingleBean grabaSingleBean) {
        Log.e("TAG","grabaSingleBean:"+grabaSingleBean.toString());
        Log.e("TAG","grabaSingleBean集合："+items.toString());

        if(grabaSingleBean==null)
            return;
        items.addAll( grabaSingleBean.getData().getItems());
        grabaSingleRobbedRecyclerViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void failure(Throwable e) {

    }
}
