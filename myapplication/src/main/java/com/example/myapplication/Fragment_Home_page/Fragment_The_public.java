package com.example.myapplication.Fragment_Home_page;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Propert.Propert_public;
import com.example.myapplication.R;
import com.example.myapplication.Viewper.Viewper1;
import com.example.myapplication.Viewper.Viewper2;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.Publi;
import com.example.myapplication.model.http.bean.Bean_public;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_The_public extends BaseFragment<Publi.View, Publi.Presenter> implements Publi.View {
    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;

    @Override
    protected Publi.Presenter Propert_sss() {
        return new Propert_public();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment__the_public;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initdata() {
        persenter.getIndex();
    }

    @Override
    public void getIndexReturn(Bean_public bean_public) {
        if (bean_public!=null){
            List<Bean_public.DataBean> data = bean_public.getData();
            fragments = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                String name = data.get(i).getName();
                tl.addTab(tl.newTab().setText(name));
                fragments.add(new Fragment_public_list(data.get(i).getId()+""));
            }
            Viewper2 viewper2 = new Viewper2(getFragmentManager(), fragments, data);
            vp.setAdapter(viewper2);
            tl.setupWithViewPager(vp);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
