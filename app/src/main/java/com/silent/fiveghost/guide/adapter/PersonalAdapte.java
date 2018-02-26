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

public class PersonalAdapte extends RecyclerView.Adapter<PersonalAdapte.ViewHolder>{
        private Context mContext;
        private PersonalAdapte.OnClickListener onClickListener;
        public void setOnClickListener(PersonalAdapte.OnClickListener onClickListener){
                this.onClickListener=onClickListener;
                }
        public PersonalAdapte(Context context){
                this.mContext=context;
                }

@Override
public PersonalAdapte.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_item,parent,false);
        return new PersonalAdapte.ViewHolder(v);
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
                onClickListener.onClick(getLayoutPosition());
            }
        });
    }
}

public interface OnClickListener {
    void onClick(int position);
}
}