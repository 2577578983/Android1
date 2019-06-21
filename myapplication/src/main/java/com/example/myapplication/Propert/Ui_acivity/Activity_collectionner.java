package com.example.myapplication.Propert.Ui_acivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Propert.Propert_collect_liebiao;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adaper_collect;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.interfaces.news.Collect_liiebiao;
import com.example.myapplication.model.http.bean.Bean_collect_liebiao;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_quxiaos;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_collectionner extends BaseActivity<Collect_liiebiao.View, Collect_liiebiao.Proeprt_collect_liebiao> implements Collect_liiebiao.View {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.rx)
    RecyclerView rx;
    private ArrayList<Bean_collect_liebiao.DataBean.DatasBean> datasBeans;
    private Adaper_collect adaper_collect;


    @Override
    protected int getLayout() {
        return R.layout.activity_collectionner;
    }

    @Override
    protected void initView() {
        datasBeans = new ArrayList<>();
        adaper_collect = new Adaper_collect(datasBeans, Activity_collectionner.this);
        rx.setAdapter(adaper_collect);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Activity_collectionner.this);
        rx.setLayoutManager(linearLayoutManager);

        adaper_collect.setSetOn(new Adaper_collect.SetOn() {
            @Override
            public void SetOn(int p, boolean checkBox) {
                if (checkBox){

                }else {
                    int id = datasBeans.get(p).getId();
                    int originId = datasBeans.get(p).getOriginId();
                    persenter.getda_quxiaos(id,originId);
                    datasBeans.remove(p);
                    adaper_collect.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    protected void initData() {
        persenter.getda_collect_liebiao();
    }

    @Override
    protected Collect_liiebiao.Proeprt_collect_liebiao createPersenter() {
        return new Propert_collect_liebiao();
    }

    @Override
    public void getIBseView_collect_liebiao(Bean_collect_liebiao bean_collect_liebiao) {
        List<Bean_collect_liebiao.DataBean.DatasBean> datas = bean_collect_liebiao.getData().getDatas();
        if (datas!=null){
            datasBeans.addAll(datas);
        }
        adaper_collect.notifyDataSetChanged();
    }

    @Override
    public void getIBseView_quxiaos(Bean_quxiaos bean_quxiaos) {
        if (bean_quxiaos!=null){
            Toast.makeText(context, "取消收藏", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}