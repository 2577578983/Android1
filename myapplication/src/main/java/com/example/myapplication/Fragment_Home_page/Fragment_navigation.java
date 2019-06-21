package com.example.myapplication.Fragment_Home_page;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Propert.Propert_navigation;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adaper_navigation;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.news.Navigation;
import com.example.myapplication.model.http.bean.Bean_Navigation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_navigation extends BaseFragment<Navigation.View, Navigation.Presenter> implements Navigation.View {


    Unbinder unbinder;
    @BindView(R.id.tablayout2)
    VerticalTabLayout tablayout2;

    Unbinder unbinder1;
    @BindView(R.id.rx)
    RecyclerView rx;
    private List<Bean_Navigation.DataBean> data;
    private String name;
    private ArrayList<String> list;
    private ArrayList<Bean_Navigation.DataBean> articlesBeans;
    private Adaper_navigation adaper_navigation;
    private LinearLayoutManager manager;


    @Override
    protected Navigation.Presenter Propert_sss() {
        return new Propert_navigation();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_navigation;
    }

    @Override
    protected void initView() {
        articlesBeans = new ArrayList<>();
        adaper_navigation = new Adaper_navigation(articlesBeans, getActivity());
        rx.setAdapter(adaper_navigation);
        manager = new LinearLayoutManager(getActivity());
        rx.setLayoutManager(manager);
        adaper_navigation.setSetos(new Adaper_navigation.Setos() {
            @Override
            public void Setos(int p) {
                tablayout2.getTabAt(p).setSelected(true);
            }
        });
        rx.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                tablayout2.setTabSelected(manager.findFirstVisibleItemPosition());
            }
        });



        tablayout2.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                manager.scrollToPositionWithOffset(position, 0);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }

    @Override
    protected void initdata() {
        persenter.getIndex_navigation();
    }

    @Override
    public void getIndexReturn_navigation(Bean_Navigation bean_navigation) {
        if (bean_navigation != null) {
            List<Bean_Navigation.DataBean> data = bean_navigation.getData();
                articlesBeans.addAll(data);
        }
        adaper_navigation.notifyDataSetChanged();
        data = bean_navigation.getData();
        list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            name = data.get(i).getName();
            list.add(name);
        }
        tablayout2.setTabAdapter(new TabAdapter() {

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new ITabView.TabTitle.Builder()
                        .setContent(list.get(position))
                        .setTextColor(Color.BLUE, Color.BLACK)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
