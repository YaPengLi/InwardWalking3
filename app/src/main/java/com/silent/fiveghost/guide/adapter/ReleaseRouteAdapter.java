package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.views.ImageViewPlus;


/**
 * Created by 84682 on 2018/1/28.
 */

public class ReleaseRouteAdapter extends RecyclerView.Adapter<ReleaseRouteAdapter.ViewHolder> {
    private Context mContext;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public ReleaseRouteAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rotedetails_recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Glide.with(mContext).load("http://www.boliqiao.vip/s7/pcimages/3.jpeg").into(holder.mRoute_Image);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onClickListener!=null)
                    onClickListener.onClick(getLayoutPosition());
                }
            });
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
