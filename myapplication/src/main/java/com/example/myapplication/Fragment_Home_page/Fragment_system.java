package com.example.myapplication.Fragment_Home_page;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Propert.Propert_Tixi;
import com.example.myapplication.Propert.Ui_acivity.Acivity_tixi_xinagqing;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adapert_Tixi;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.System;
import com.example.myapplication.model.http.bean.Bean_tixi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_system extends BaseFragment<System.View, System.Proeprt_Tixi> implements System.View {


    @BindView(R.id.rx)
    RecyclerView rx;
    Unbinder unbinder;
    private ArrayList<Bean_tixi.DataBean> dataBeans;
    private Adapert_Tixi adapert_tixi;


    @Override
    protected System.Proeprt_Tixi Propert_sss() {
        return new Propert_Tixi();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_system;
    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        adapert_tixi = new Adapert_Tixi(dataBeans,getActivity());
        rx.setAdapter(adapert_tixi);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rx.setLayoutManager(linearLayoutManager);
       adapert_tixi.setSetos(new Adapert_Tixi.Setos() {
           @Override
           public void Setos(int p, String s) {
               List<Bean_tixi.DataBean.ChildrenBean> children = dataBeans.get(p).getChildren();
               ArrayList<String> list = new ArrayList<>();
               ArrayList<Integer> listid = new ArrayList<>();
               for (int i = 0; i < children.size(); i++) {
                   String name = dataBeans.get(i).getName();
                   int id = dataBeans.get(p).getChildren().get(i).getId();
                   list.add(name);
                   listid.add(id);
               }
               Intent intent = new Intent(getActivity(), Acivity_tixi_xinagqing.class);
               intent.putIntegerArrayListExtra("listid",listid);
               intent.putStringArrayListExtra("list",list);
               startActivity(intent);
           }
       });
    }
    @Override
    protected void initdata() {
        persenter.getda_Tixi();
    }

    @Override
    public void getIBseView_Tixi(Bean_tixi bean_tixi) {
        if (bean_tixi != null) {
            List<Bean_tixi.DataBean> data = bean_tixi.getData();
            dataBeans.addAll(data);
        }
        adapert_tixi.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
