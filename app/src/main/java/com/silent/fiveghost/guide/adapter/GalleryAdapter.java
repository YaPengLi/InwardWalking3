package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lzy.imagepicker.bean.ImageItem;
import com.silent.fiveghost.guide.R;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5 0005.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    public static final int IMAGE_ITEM_ADD = -1;
    private Context mContext;
    private List<ImageItem> mList;
    private OnRecyclerViewItemClickListener listener;

    public GalleryAdapter(Context mContext, List<ImageItem> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_bitmap, null);
        ViewHolder vh = new ViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (((getItemCount() <= 9 ||getItemCount()==9)&& position == getItemCount() - 1)) {
                Glide.with(mContext).load(R.mipmap.addiamge).into(holder.mImageView);
                holder.mImageView_Jian.setVisibility(View.GONE);
        } else {
            Glide.with(mContext).load(mList.get(position).path).into(holder.mImageView);
            holder.mImageView_Jian.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 1 : mList.size() < 9 ? mList.size() + 1 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public View rootView;
        public ImageView mImageView,mImageView_Jian;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mImageView = (ImageView) rootView.findViewById(R.id.mImageView);
            this.mImageView_Jian = (ImageView) rootView.findViewById(R.id.mImageView_Jian);
            rootView.setTag("rootView");
            rootView.setOnClickListener(this);
            mImageView_Jian.setOnClickListener(this);
            mImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(view, getAdapterPosition());
            }
        }
    }


    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }
}
