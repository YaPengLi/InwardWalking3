package com.silent.fiveghost.guide.ui.fragments.order.ogsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.entity.NotStartedBean;
import com.silent.fiveghost.guide.ui.fragments.order.Lv_Item_NotStartedAdapter;

import java.util.ArrayList;

/**
 * 认真的人到最后都是难过 2018/1/28.
 */

public class NotStartedFragment extends Fragment {
    private ListView lv_lvxingshedingdan;
    private ListView lv_youkedingdan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.notstartedfragment, container, false);

        initView(inflate);
        ArrayList<NotStartedBean> notStartedBeans = new ArrayList<>();
        notStartedBeans.add(new NotStartedBean("嗯","时间","4","fengjing","yizhanshi","http://img0.imgtn.bdimg.com/it/u=2723687026,1914356634&fm=27&gp=0.jpg"));
        Lv_Item_NotStartedAdapter lv_item_notStartedAdapter = new Lv_Item_NotStartedAdapter(notStartedBeans,getActivity());
        lv_lvxingshedingdan.setAdapter(lv_item_notStartedAdapter);
        lv_youkedingdan.setAdapter(lv_item_notStartedAdapter);
        return inflate;
    }

    private void initView(View inflate) {
        lv_lvxingshedingdan = (ListView) inflate.findViewById(R.id.lv_lvxingshedingdan);
        lv_youkedingdan = (ListView) inflate.findViewById(R.id.lv_youkedingdan);
    }
}
