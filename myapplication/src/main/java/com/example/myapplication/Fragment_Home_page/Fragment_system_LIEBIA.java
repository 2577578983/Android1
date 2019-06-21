package com.example.myapplication.Fragment_Home_page;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Propert.Propert_TiXiLieBiao;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adaper_TiXi_liebiao;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.System_liebiao;
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


@SuppressLint("ValidFragment")
public class Fragment_system_LIEBIA extends BaseFragment<System_liebiao.View, System_liebiao.Proeprt_Tixi_liebiao> implements System_liebiao.View {

    @BindView(R.id.rx_tixi_liebiao)
    RecyclerView rxTixiLiebiao;
    Unbinder unbinder;
    private int a;
    private ArrayList<Bean_tixi_liebiao.DataBean.DatasBean> datasBeans;
    private Adaper_TiXi_liebiao adaper_tiXi_liebiao;

    public Fragment_system_LIEBIA(Integer s) {
        a = s;
    }


    @Override
    protected System_liebiao.Proeprt_Tixi_liebiao Propert_sss() {
        return new Propert_TiXiLieBiao();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_system__liebi;
    }

    @Override
    protected void initView() {
        datasBeans = new ArrayList<>();
        adaper_tiXi_liebiao = new Adaper_TiXi_liebiao(datasBeans, getActivity());
        rxTixiLiebiao.setAdapter(adaper_tiXi_liebiao);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rxTixiLiebiao.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initdata() {
        persenter.getda_Tixi_liebiao("article/list/0/json?cid="+a);
    }

    @Override
    public void getIBseView_Tixi_liebiao(Bean_tixi_liebiao bean_tixi_liebiao) {
        if (bean_tixi_liebiao!=null){
            List<Bean_tixi_liebiao.DataBean.DatasBean> datas = bean_tixi_liebiao.getData().getDatas();
            datasBeans.addAll(datas);
        }
        adaper_tiXi_liebiao.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();

        }
    }
}
