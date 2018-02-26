package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.entity.RouteEntity;
import com.silent.fiveghost.guide.views.ImageViewPlus;

import java.util.List;


/**
 * Created by 84682 on 2018/1/28.
 */

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ViewHolder> {
    private Context mContext;
    private OnClickListener onClickListener;
    private List<RouteEntity.DataBean.ItemsBean> mData;
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RouteAdapter(Context context,List<RouteEntity.DataBean.ItemsBean> mData) {
        this.mContext = context;
        this.mData=mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.route_recylaout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).into(holder.mRoute_Image);
        holder.route_name.setText(mData.get(position).getName());
        holder.route_price.setText(mData.get(position).getPrice());
        holder.mSignup_num.setText(mData.get(position).getSignup_num()+"");

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageViewPlus mRoute_Image;
        private final TextView route_price;
        private final TextView route_name;
        private final TextView mSignup_num;

        public ViewHolder(View itemView) {
            super(itemView);
            mRoute_Image= itemView.findViewById(R.id.mRoute_Image);
            route_price = itemView.findViewById(R.id.route_price);
            route_name = itemView.findViewById(R.id.route_name);
            mSignup_num = itemView.findViewById(R.id.mSignup_num);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClick(getLayoutPosition());
                }
            });
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
