package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silent.fiveghost.guide.R;


/**
 * Created by 农民伯伯 on 2018/1/29.
 */

public class FiinanciaAdapte extends RecyclerView.Adapter<FiinanciaAdapte.ViewHolder>{
        private Context mContext;
        private FiinanciaAdapte.OnClickListener onClickListener;
        public void setOnClickListener(FiinanciaAdapte.OnClickListener onClickListener){
                this.onClickListener=onClickListener;
                }
        public FiinanciaAdapte(Context context){
                this.mContext=context;
                }

@Override
public FiinanciaAdapte.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.finacial_flow_item,parent,false);
        return new FiinanciaAdapte.ViewHolder(v);
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
public int getItemCount(){
        return 10;
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener!=null)
                onClickListener.onClick(getLayoutPosition());
            }
        });
    }
}

public interface OnClickListener {
    void onClick(int position);
}
}