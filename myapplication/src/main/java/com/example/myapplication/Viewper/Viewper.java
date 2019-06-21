package com.example.myapplication.Viewper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myapplication.model.http.bean.Bean_tiaomu;

import java.util.ArrayList;
import java.util.List;

public class Viewper extends FragmentStatePagerAdapter {
    private List<Fragment> fs;
    private List<Bean_tiaomu.DataBean> m;
    public Viewper(FragmentManager fm,List<Fragment> fs, List<Bean_tiaomu.DataBean> m) {
        super(fm);
        this.fs=fs;
        this.m=m;
    }

    @Override
    public Fragment getItem(int position) {
        return fs.get(position);
    }

    @Override
    public int getCount() {
        return fs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return m.get(position).getName();
    }
}
