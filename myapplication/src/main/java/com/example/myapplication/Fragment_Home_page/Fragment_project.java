package com.example.myapplication.Fragment_Home_page;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Propert.Propert_tiao;
import com.example.myapplication.R;
import com.example.myapplication.Viewper.Viewper;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.Entry;
import com.example.myapplication.model.http.bean.Bean_tiaomu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_project extends BaseFragment<Entry.View, Entry.Proeprt_tiao> implements Entry.View {


    @BindView(R.id.tl)
    TabLayout tl;
    Unbinder unbinder;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder1;


    @Override
    protected Entry.Proeprt_tiao Propert_sss() {
        return new Propert_tiao();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_project;
    }



    @Override
    protected void initdata() {
        persenter.getda_tiao();
    }

    @Override
    public void getIBseView_Tiao(Bean_tiaomu bean_tiaomu) {
        List<Bean_tiaomu.DataBean> data = bean_tiaomu.getData();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            fragments.add(new Fragment_nei(data.get(i).getId() + ""));
            tl.addTab(tl.newTab().setText(data.get(i).getName()));
        }
        Viewper viewper = new Viewper(getChildFragmentManager(), fragments, data);
        vp.setAdapter(viewper);
        tl.setupWithViewPager(vp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
