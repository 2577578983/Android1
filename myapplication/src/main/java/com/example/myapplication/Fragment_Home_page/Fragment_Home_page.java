package com.example.myapplication.Fragment_Home_page;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Dbhdler.Dbhdler;
import com.example.myapplication.Propert.Propert;
import com.example.myapplication.Propert.Propert_shouye;
import com.example.myapplication.Propert.Ui_acivity.Acivity_homeWbeView;
import com.example.myapplication.Propert.Ui_acivity.Acivity_xiangmuWebView;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adapert_shouye;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.Shouye;
import com.example.myapplication.model.http.bean.Bean_Lei;
import com.example.myapplication.model.http.bean.Bean_banner;
import com.example.myapplication.model.http.bean.Bean_collect;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_shouye;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Fragment_Home_page extends BaseFragment<Shouye.View, Shouye.Propert_shouye>
        implements Shouye.View {


    @BindView(R.id.rl)
    RecyclerView rl;
    Unbinder unbinder;
    private int e;
    private ArrayList<Bean_shouye.DataBean.DatasBean> datasBeans;
    private ArrayList<Bean_banner.DataBean> dataBeans;
    private Adapert_shouye adapert_shouye;
    private Bean_Lei bean_lei;
    private TextView tv;
    @SuppressLint("ValidFragment")
    public Fragment_Home_page(TextView viewById) {
        tv = viewById;
    }

    @Override
    protected void initView() {
        super.initView();

        datasBeans = new ArrayList<>();
        dataBeans = new ArrayList<>();
        adapert_shouye = new Adapert_shouye(datasBeans, dataBeans, getActivity());
        rl.setAdapter(adapert_shouye);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(linearLayoutManager);
        adapert_shouye.setSetOnclick(new Adapert_shouye.SetOnclick() {
            @Override
            public void SetOnclick(int p) {

                Intent intent = new Intent(getActivity(), Acivity_homeWbeView.class);
                String link = datasBeans.get(p).getLink();
                intent.putExtra("data", link);
                startActivity(intent);
            }
        });
        adapert_shouye.setSeto(new Adapert_shouye.Seto() {
            @Override
            public void Seto(int p) {
                Intent intent = new Intent(getActivity(), Acivity_xiangmuWebView.class);
                String url = datasBeans.get(p).getEnvelopePic();
                intent.putExtra("ban", url);
                startActivity(intent);
            }
        });
        adapert_shouye.setChbaox(new Adapert_shouye.Chbaox() {
            @Override
            public void Chbaox(int p, boolean cb) {
                if (cb) {
                    e = p;
                    int id = datasBeans.get(e - 1).getId();
                    persenter.getda_collect(id);
                } else {
                    int id = datasBeans.get(e - 1).getId();
                    persenter.getda_quxiao(id);
                }
            }
        });


    }

    @Override
    protected void initdata() {
        persenter.getdata_shouye();
        persenter.getdata_banners();


    }

    @Override
    protected Shouye.Propert_shouye Propert_sss() {
        return new Propert_shouye();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_blank_fragment__home_page;
    }

    @Override
    public void getIBseView_shouye(Bean_shouye bean_shouye) {

        List<Bean_shouye.DataBean.DatasBean> datas = bean_shouye.getData().getDatas();
        if (datas != null) {
            datasBeans.addAll(datas);
        }
        for (int i = 0; i < datas.size(); i++) {
            bean_lei = new Bean_Lei();
            bean_lei.setName(datas.get(i).getTitle());
            bean_lei.setTitle(datas.get(i).getAuthor());
            bean_lei.setGongong(datas.get(i).getChapterName());
            bean_lei.setShijian(datas.get(i).getNiceDate());
            Dbhdler.getDbhdler().insert(bean_lei);
        }
        adapert_shouye.notifyDataSetChanged();
    }

    @Override
    public void getBnaner(Bean_banner bean_banner) {
        List<Bean_banner.DataBean> data = bean_banner.getData();
        if (data != null) {
            dataBeans.addAll(data);
        }
        adapert_shouye.notifyDataSetChanged();
    }

    @Override
    public void getIBseView_collect(Bean_collect bean_collect) {
        if (bean_collect != null && bean_collect.getErrorCode() == 0) {
            Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "请先登陆", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getIBseView_quxiao(Bean_quxiao bean_quxiao) {
        if (bean_quxiao.getData() == null) {
            Toast.makeText(getActivity(), "取消收藏", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
