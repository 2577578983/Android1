package com.example.myapplication.Viewper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myapplication.model.http.bean.Bean_tiaomu;
import com.example.myapplication.model.http.bean.Bean_tixi;
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;

import java.util.ArrayList;
import java.util.List;

public class Viewper1 extends FragmentStatePagerAdapter {
    private List<Fragment> fs;
    public Viewper1(FragmentManager fm, List<Fragment> fs) {
        super(fm);
        this.fs=fs;
    }

    @Override
    public Fragment getItem(int position) {
        return fs.get(position);
    }

    @Override
    public int getCount() {
        return fs.size();
    }

}
