package com.silent.fiveghost.guide.ui.fragments.order;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.entity.NotStartedBean;

import java.util.ArrayList;

/**
 * 认真的人到最后都是难过 2018/1/28.
 */

public class Lv_Item_NotStartedAdapter extends BaseAdapter {
    private ArrayList<NotStartedBean> notStartedBeans;
    private Context context;

    public Lv_Item_NotStartedAdapter(ArrayList<NotStartedBean> notStartedBeans, FragmentActivity notStartedFragment) {
        this.notStartedBeans = notStartedBeans;
        this.context = notStartedFragment;
    }

    @Override
    public int getCount() {
        return notStartedBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_notstarted_item, null);
            holder.tv_city = (TextView) convertView.findViewById(R.id.tv_city);
            holder.tv_time = (TextView) convertView.findViewById(R.id.mGrabTextTime);
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.tv_like = (TextView) convertView.findViewById(R.id.tv_like);
            holder.tv_lexing = (TextView) convertView.findViewById(R.id.tv_lexing);
            holder.lv_fengjing = (ImageView) convertView.findViewById(R.id.lv_fengjing);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv_city.setText(notStartedBeans.get(position).getCity());
        holder.tv_lexing.setText(notStartedBeans.get(position).getLeixing());
        holder.tv_like.setText(notStartedBeans.get(position).getLike());
        holder.tv_num.setText(notStartedBeans.get(position).getNum());
        holder.tv_time.setText(notStartedBeans.get(position).getTime());
//        Glide.with(context).load(notStartedBeans.get(position).getLv_fengjing()).into(holder.lv_fengjing);
        Glide.with(context)
                .load(notStartedBeans.get(position).getLv_fengjing())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(holder.lv_fengjing) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(10); //设置圆角弧度
                        holder.lv_fengjing.setImageDrawable(circularBitmapDrawable);
                    }
                });
        return convertView;
    }


    class ViewHolder {

        public TextView tv_city;
        public TextView tv_time;
        public TextView tv_num;
        public TextView tv_like;
        public TextView tv_lexing;
        public ImageView lv_fengjing;


    }
}
