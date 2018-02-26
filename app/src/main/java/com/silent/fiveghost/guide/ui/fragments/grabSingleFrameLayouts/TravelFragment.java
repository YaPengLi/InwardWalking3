package com.silent.fiveghost.guide.ui.fragments.grabSingleFrameLayouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
 * 游客订单
 */

public class TravelFragment extends Fragment implements Iview<GrabaSingleBean> {

    private RecyclerView mTravelRecyclertView;
    private List<GrabaSingleBean.DataBean.ItemsBean> items = new ArrayList<>();
    private GrabaSingleRecyclerViewAdapter grabaSingleRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_travel, container, false);
        mTravelRecyclertView = view.findViewById(R.id.mTravelRecyclertView);
        Presenters presenters = new Presenters(getContext(), this);
        presenters.requestNews(Concat.GRABA_SINGLE_LIST + "&type=2");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        grabaSingleRecyclerViewAdapter = new GrabaSingleRecyclerViewAdapter(getContext(), items);
        mTravelRecyclertView.setLayoutManager(linearLayoutManager);
        mTravelRecyclertView.setAdapter(grabaSingleRecyclerViewAdapter);
        grabaSingleRecyclerViewAdapter.setmOnItemClickListener(new GrabaSingleRecyclerViewAdapter.OnItemClickListener() {
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
                        items.remove(position);
                        grabaSingleRecyclerViewAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), errmsg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(Throwable e) {

                    }
                });
                presenters.requestNews("http://120.79.137.110:83/api/v1/order/grab-order?access_token=c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk", mParams);
//                http://120.79.137.110:83/api/v1/order/grab-order?access_token=c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk
            }


        });
        return view;
    }

    @Override
    public void success(GrabaSingleBean grabaSingleBean) {
        if(grabaSingleBean==null)
            return;
        items.addAll( grabaSingleBean.getData().getItems());
        grabaSingleRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {

    }
}