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

public class GrabaSingleRobbedRecyclerViewAdapter extends RecyclerView.Adapter<GrabaSingleRobbedRecyclerViewAdapter.ViewHoler> {
    private  List<GrabaSingleBean.DataBean.ItemsBean> itemList;
    private Context context;

    public GrabaSingleRobbedRecyclerViewAdapter(Context context, List<GrabaSingleBean.DataBean.ItemsBean> itemList) {
        this.context=context;
        this.itemList = itemList;
    }

    public interface OnItemClickListener {
        void onItemClick();
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
        View view = LayoutInflater.from(context).inflate(R.layout.robbed_recyclerview_item, parent, false);
        ViewHoler viewHoler= new ViewHoler(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        Glide.with(context).load(itemList.get(position).getImg()).into(holder.mRobbedImageView);
        holder.mRobbedTextCityName.setText("城市："+itemList.get(position).getCity());
        holder.mRobbedTextTime.setText("时间："+itemList.get(position).getStart_time());
        holder.mRobbedTextNum.setText("人数："+itemList.get(position).getNumber()+"人");
        holder.mRobbedTextOrderType.setText("订单类型："+itemList.get(position).getOrder_type());
        holder.mRobbedTextTouist.setText("旅游偏好："+itemList.get(position).getTravel_preference());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        private AutoRelativeLayout mGrabaView;
       private AutoRelativeLayout mRobbedRelative;
        private final ImageView mRoute_images;
        private final ImageView mRobbedImageView;
        private final TextView mRobbedTextCityName;
        private final TextView mRobbedTextTime;
        private final TextView mRobbedTextNum;
        private final TextView mRobbedTextTouist;
        private final TextView mRobbedTextOrderType;

        public ViewHoler(View itemView) {
            super(itemView);
            mRobbedImageView = itemView.findViewById(R.id.mRobbedImageView);
            mRobbedTextCityName = itemView.findViewById(R.id.mRobbedTextCityName);
            mRobbedTextTime = itemView.findViewById(R.id.mRobbedTextTime);
            mRobbedTextNum = itemView.findViewById(R.id.mRobbedTextNum);
            mRobbedTextTouist = itemView.findViewById(R.id.mRobbedTextTouist);
            mRobbedTextOrderType = itemView.findViewById(R.id.mRobbedTextOrderType);
            mRoute_images = itemView.findViewById(R.id.mRobbed_Images);
            mGrabaView = itemView.findViewById(R.id.mGrabaView);
            mRobbedRelative = itemView.findViewById(R.id.mRobbedRelative);
            mRobbedRelative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick();
                    }
                }
            });
        }
    }
}
