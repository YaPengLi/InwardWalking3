package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.entity.HomeItemBean;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2018/1/27.
 */

public class HomePagerListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HomeItemBean> list;
    private ViewHolder holder;
    public static TextView tv_accept;

    public HomePagerListAdapter(Context context, ArrayList<HomeItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context, R.layout.home_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_cityname.setText(list.get(i).getCityname());
        holder.tv_time.setText(list.get(i).getTime());
        holder.tv_love.setText(list.get(i).getLove());
        holder.tv_number.setText(list.get(i).getNumber());
        holder.tv_order_type.setText(list.get(i).getTv_order_type());
        Glide.with(context).load("http://img0.imgtn.bdimg.com/it/u=1810238950,3184323486&fm=27&gp=0.jpg").into(holder.iv_image);
        tv_accept = holder.tv_accept;
        return view;
    }



    public static class ViewHolder {
        public View rootView;
        public ImageView iv_image;
        public TextView tv_cityname;
        public TextView tv_time;
        public TextView tv_number;
        public TextView tv_love;
        public TextView tv_order_type;
        public  TextView tv_accept;
        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_image = (ImageView) rootView.findViewById(R.id.home_item_image);
            this.tv_cityname = (TextView) rootView.findViewById(R.id.tv_cityname);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_number = (TextView) rootView.findViewById(R.id.tv_number);
            this.tv_love = (TextView) rootView.findViewById(R.id.tv_love);
            this.tv_accept = (TextView) rootView.findViewById(R.id.tv_accept);
            this.tv_order_type = (TextView) rootView.findViewById(R.id.tv_order_type);
        }

    }

}
