package com.example.myapplication.Viewper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myapplication.model.http.bean.Bean_public;

import java.util.ArrayList;
import java.util.List;

public class Viewper2 extends FragmentStatePagerAdapter {
    private List<Fragment> fs;
    private List<Bean_public.DataBean> nei;

    public Viewper2(FragmentManager fm, List<Fragment> fs, List<Bean_public.DataBean> nei) {
        super(fm);
        this.fs = fs;
        this.nei = nei;
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
        return nei.get(position).getName();
    }
}
