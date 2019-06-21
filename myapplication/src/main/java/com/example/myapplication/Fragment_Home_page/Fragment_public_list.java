package com.example.myapplication.Fragment_Home_page;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.Propert.Propert_public_liebiao;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adaper_public_liebiao;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.Public_liebiao;
import com.example.myapplication.model.http.bean.Bean_public_liebiao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Fragment_public_list extends BaseFragment<Public_liebiao.View, Public_liebiao.Presenter> implements Public_liebiao.View {


    @BindView(R.id.et_s)
    EditText etS;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.rx)
    RecyclerView rx;
    Unbinder unbinder;
    private int a;
    private String s;
    private ArrayList<Bean_public_liebiao.DataBean.DatasBean> datasBeans;
    private Adaper_public_liebiao adaper_public_liebiao;

    @SuppressLint("ValidFragment")
    public Fragment_public_list(String s) {
        a= Integer.parseInt(s);
    }

    @Override
    protected Public_liebiao.Presenter Propert_sss() {
        return new Propert_public_liebiao();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_public_list;
    }

    @Override
    protected void initView() {
        datasBeans = new ArrayList<>();
        adaper_public_liebiao = new Adaper_public_liebiao(datasBeans, getActivity());
        rx.setAdapter(adaper_public_liebiao);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rx.setLayoutManager(linearLayoutManager);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = etS.getText().toString();
                initdata();
            }
        });

    }
    @Override
    protected void initdata() {
        persenter.getIndex_public_liebiao("wxarticle/list/"+a+"/1/json?k="+s);
    }

    @Override
    public void getIndexReturn_public_liebiao(Bean_public_liebiao bean_public_liebiao) {
        if (bean_public_liebiao!=null){
            List<Bean_public_liebiao.DataBean.DatasBean> datas = bean_public_liebiao.getData().getDatas();
            datasBeans.addAll(datas);
        }
        adaper_public_liebiao.notifyDataSetChanged();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
}
