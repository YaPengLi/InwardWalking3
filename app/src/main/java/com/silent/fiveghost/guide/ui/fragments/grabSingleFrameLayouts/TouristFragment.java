package com.silent.fiveghost.guide.ui.fragments.grabSingleFrameLayouts;

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
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.grabaSingleAdapter.GrabaSingleRecyclerViewAdapter;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.GrabaSingleBean;
import com.silent.fiveghost.guide.entity.QiangBean;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.ui.activitys.DetailsOfRobbingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/1/28.
 * 旅行社订单
 */

public class TouristFragment extends Fragment implements Iview<GrabaSingleBean> {

    private RecyclerView mTouristRecyclerView;
    private List<GrabaSingleBean.DataBean.ItemsBean> items = new ArrayList<>();
    private GrabaSingleRecyclerViewAdapter grabaSingleListViewAdapter;

    private Presenters p;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_tourist, container, false);
        mTouristRecyclerView = view.findViewById(R.id.mTouristRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mTouristRecyclerView.setLayoutManager(linearLayoutManager);
        grabaSingleListViewAdapter = new GrabaSingleRecyclerViewAdapter(getContext(), items);
        mTouristRecyclerView.setAdapter(grabaSingleListViewAdapter);
        grabaSingleListViewAdapter.setmOnItemClickListener(new GrabaSingleRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(getActivity(), DetailsOfRobbingActivity.class));

            }

            @Override
            public void onClickQiang(final int position) {
                HashMap<String, String> mParams = new HashMap<>();
//                mParams.put("access_token",Concat.ACCESS_TOKEN);
                mParams.put("order_id", items.get(position).getOrder_id());
                mParams.put("tid", items.get(position).getTid());
                Presenters presenters = new Presenters(getContext(), new Iview<QiangBean>() {
                    @Override
                    public void success(QiangBean qiangBean) {
                        String errmsg = qiangBean.getErrmsg();
                        Toast.makeText(getContext(), errmsg, Toast.LENGTH_SHORT).show();
                        items.remove(position);
                        grabaSingleListViewAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable e) {

                    }
                });
                presenters.requestNews("http://120.79.137.110:83/api/v1/order/grab-order?access_token=c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk", mParams);
//                http://120.79.137.110:83/api/v1/order/grab-order?access_token=c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk
            }


        });

        p = new Presenters(getContext(), this);
        p.requestNews(Concat.GRABA_SINGLE_LIST + "&type=1");
        return view;
    }


    @Override
    public void success(GrabaSingleBean grabaSingleBean) {
        if(grabaSingleBean==null)
            return;
        items.addAll(grabaSingleBean.getData().getItems());
        grabaSingleListViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void failure(Throwable e) {
        Log.e("GrabaSingle", e.toString());
    }
}
