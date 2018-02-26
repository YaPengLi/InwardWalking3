package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.entity.RouteTemolateEntity;
import com.silent.fiveghost.guide.views.ImageViewPlus;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 84682 on 2018/1/28.
 */

public class RouteTemplateAadapter extends RecyclerView.Adapter<RouteTemplateAadapter.ViewHolder> {
    private Context mContext;
    private OnClickListener onClickListener;
    private List<RouteTemolateEntity.DataBean.ItemsBean> mData ;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RouteTemplateAadapter(Context context,List<RouteTemolateEntity.DataBean.ItemsBean> mData) {
        this.mContext = context;
        this.mData=mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.securitysetting_recylaout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).into(holder.mYsecuritysetting_iamge);
        holder.route_template_name.setText(mData.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mYsecuritysetting_iamge;
        private  TextView route_template_name;

        public ViewHolder(View itemView) {
            super(itemView);
            mYsecuritysetting_iamge = itemView.findViewById(R.id.mYsecuritysetting_iamge);
            route_template_name = itemView.findViewById(R.id.route_template_name);
            mYsecuritysetting_iamge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClick(getLayoutPosition(),1);
                }
            });
        }
    }

    public interface OnClickListener {
        void onClick(int position, int type);
    }
}
