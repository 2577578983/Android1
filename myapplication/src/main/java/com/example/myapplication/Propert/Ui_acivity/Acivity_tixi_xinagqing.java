package com.example.myapplication.Propert.Ui_acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.Fragment_Home_page.Fragment_system_LIEBIA;
import com.example.myapplication.R;
import com.example.myapplication.Viewper.Viewper;
import com.example.myapplication.Viewper.Viewper1;

import java.util.ArrayList;

public class Acivity_tixi_xinagqing extends AppCompatActivity {

    private TabLayout mTl;
    private ViewPager mVpP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_tixi_xinagqing);
        initView();
    }

    private void initView() {
        mTl = (TabLayout) findViewById(R.id.tl);
        mVpP = (ViewPager) findViewById(R.id.vp_p);
        Intent intent = getIntent();
        ArrayList<String> list = intent.getStringArrayListExtra("list");
        ArrayList<Integer> listid = intent.getIntegerArrayListExtra("listid");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer integer = listid.get(i);
            fragments.add(new Fragment_system_LIEBIA(integer));
            mTl.addTab(mTl.newTab().setText(list.get(i)));
        }
        Viewper1 viewper1 = new Viewper1(getSupportFragmentManager(), fragments);
        mVpP.setAdapter(viewper1);
        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVpP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVpP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTl));
    }
}
