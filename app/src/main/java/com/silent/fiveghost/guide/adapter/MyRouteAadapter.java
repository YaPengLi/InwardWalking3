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
import com.silent.fiveghost.guide.views.ImageViewPlus;


/**
 * Created by 84682 on 2018/1/28.
 */

public class MyRouteAadapter extends RecyclerView.Adapter<MyRouteAadapter.ViewHolder> {
    private Context mContext;
    private OnClickListener onClickListener;
    private ImageViewPlus mYsecuritysetting_iamge;


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public MyRouteAadapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.securitysetting_recylaout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load("http://img4.imgtn.bdimg.com/it/u=2505349299,2633949665&fm=27&gp=0.jpg").into(holder.mYsecuritysetting_iamge);
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mYsecuritysetting_iamge;

        public ViewHolder(View itemView) {
            super(itemView);
            mYsecuritysetting_iamge = itemView.findViewById(R.id.mYsecuritysetting_iamge);
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
