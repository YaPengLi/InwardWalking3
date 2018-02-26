package com.silent.fiveghost.guide.adapter.grabaSingleAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.entity.GrabaSingleBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/1/28.
 */

public class GrabaSingleRecyclerViewAdapter extends RecyclerView.Adapter<GrabaSingleRecyclerViewAdapter.ViewHoler> {
    private  List<GrabaSingleBean.DataBean.ItemsBean> itemsList;
    private Context context;

    public GrabaSingleRecyclerViewAdapter(Context context, List<GrabaSingleBean.DataBean.ItemsBean> itemsList) {
        this.context=context;
        this.itemsList = itemsList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onClickQiang(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public OnItemClickListener getmOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grab_recyclerview_item, parent, false);
        ViewHoler viewHoler= new ViewHoler(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        Glide.with(context).load(itemsList.get(position).getImg()).into(holder.mGrabRecyclerImage);
        holder.mGrabCityName.setText("城市："+itemsList.get(position).getCity());
        holder.mGrabTextTime.setText("时间："+itemsList.get(position).getStart_time());
        holder.mGrabTextNum.setText("人数："+itemsList.get(position).getNumber()+"人");
        holder.mGrabTextOrderType.setText("订单类型："+itemsList.get(position).getOrder_type());
        holder.mGrabTouristHouse.setText("旅游偏好："+itemsList.get(position).getTravel_preference());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        private AutoRelativeLayout mGrabaView;
        private  ImageView mGrabRecyclerImage;
        private  TextView mGrabCityName;
        private  TextView mGrabTextTime;
        private  TextView mGrabTextNum;
        private  TextView mGrabTouristHouse;
        private  TextView mGrabTextOrderType;
        private  AutoRelativeLayout mGrabRelative;
        public ViewHoler(View itemView) {
            super(itemView);
            mGrabRecyclerImage = itemView.findViewById(R.id.mgrab_recycler_image);
            mGrabCityName = itemView.findViewById(R.id.mGrabCityName);
            mGrabTextTime = itemView.findViewById(R.id.mGrabTextTime);
            mGrabTextNum = itemView.findViewById(R.id.mGrabTextNum);
            mGrabTouristHouse = itemView.findViewById(R.id.mGrabTouristHouse);
            mGrabTextOrderType = itemView.findViewById(R.id.mGrabTextOrderType);
            mGrabaView = itemView.findViewById(R.id.mGrabaView);
            mGrabRelative = itemView.findViewById(R.id.mGrabRelative);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });
            mGrabRelative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onClickQiang(getLayoutPosition());
                    }
                }
            });

        }
    }
}
