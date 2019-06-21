package com.example.myapplication.Fragment_Home_page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Propert.Propert_liebiao;
import com.example.myapplication.Propert.Ui_acivity.Acivity_xiangmuWebView;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adapert_liebiao;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.Tableau;
import com.example.myapplication.model.http.bean.Bean_liebiao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class Fragment_nei extends BaseFragment<Tableau.View, Tableau.Proeprt_liebiao> implements Tableau.View {

    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private int a;
    int c=1;
    private ArrayList<Bean_liebiao.DataBean.DatasBean> datasBeans;
    private Adapert_liebiao adapert_liebiao;

    @SuppressLint("ValidFragment")
    public Fragment_nei(String s) {
         a= Integer.parseInt(s);
    }


    @Override
    protected Tableau.Proeprt_liebiao Propert_sss() {
        return new Propert_liebiao();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_nei;
    }

    @Override
    protected void initView() {
        datasBeans = new ArrayList<>();
        adapert_liebiao = new Adapert_liebiao(datasBeans, getActivity());
        rv.setAdapter(adapert_liebiao);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, 1);
        rv.setLayoutManager(layoutManager);
        adapert_liebiao.setSetoncli(new Adapert_liebiao.Setoncli() {
            @Override
            public void Setoncli(int p) {
                Intent intent = new Intent(getActivity(),Acivity_xiangmuWebView.class);
                intent.putExtra("da",datasBeans.get(p).getLink());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initdata() {

        persenter.getda_liebiao("project/list/"+c+"/json?cid="+a);
    }

    @Override
    public void getIBseView_lieiao(Bean_liebiao bean_liebiao) {
        List<Bean_liebiao.DataBean.DatasBean> datas = bean_liebiao.getData().getDatas();
        if (datas!=null){
            datasBeans.addAll(datas);
        }
        adapert_liebiao.notifyDataSetChanged();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){

            unbinder.unbind();
        }
    }
}
