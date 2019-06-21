package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.Fragment_Home_page.Fragment_Home_page;
import com.example.myapplication.Fragment_Home_page.Fragment_The_public;
import com.example.myapplication.Fragment_Home_page.Fragment_navigation;
import com.example.myapplication.Fragment_Home_page.Fragment_project;
import com.example.myapplication.Fragment_Home_page.Fragment_system;
import com.example.myapplication.Propert.Propert;
import com.example.myapplication.Propert.Ui_acivity.Acivity_search;
import com.example.myapplication.Propert.Ui_acivity.Activity_about;
import com.example.myapplication.Propert.Ui_acivity.Activity_collectionner;
import com.example.myapplication.Propert.Ui_acivity.Activity_denglus;
import com.example.myapplication.adaper.WanAndorid_adaper;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;
import com.example.myapplication.utils.ThemeManager;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ThemeManager .OnThemeChangeListener {

    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    private int theme = R.style.AppTheme;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.Toolbar)
    TextView Toolbar;
    private TextView viewById;

    private FragmentManager manager;
    private int a;
    private ArrayList<Fragment> fragments;
    private Button bt;
    private boolean isDay = true;//默认是日间模式

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

        super.onCreate(savedInstanceState, persistentState);

    }


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        ThemeManager.registerThemeChangeListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewById = navigationView.getHeaderView(0).findViewById(R.id.textView);


        bt = navigationView.getHeaderView(0).findViewById(R.id.bai);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDay == true) {
                    ThemeManager.setThemeMode(ThemeManager .ThemeMode.NIGHT);
                    bt.setText("日间模式");
                    isDay = false;
                } else {
                    ThemeManager .setThemeMode(ThemeManager .ThemeMode.DAY);
                    bt.setText("夜间模式");
                    isDay = true;
                }
            }
        });
        this.viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_denglus.class);
                startActivityForResult(intent, 1);
            }
        });
        fragments = new ArrayList<>();
        fragments.add(new Fragment_Home_page(this.viewById));
        fragments.add(new Fragment_project());
        fragments.add(new Fragment_system());
        fragments.add(new Fragment_The_public());
        fragments.add(new Fragment_navigation());
        tl.addTab(tl.newTab().setText("首页").setIcon(R.drawable.shouye));
        tl.addTab(tl.newTab().setText("项目").setIcon(R.drawable.xiangmu));
        tl.addTab(tl.newTab().setText("体系").setIcon(R.drawable.tixi));
        tl.addTab(tl.newTab().setText("公众号").setIcon(R.drawable.gongzhong));
        tl.addTab(tl.newTab().setText("导航").setIcon(R.drawable.daohang));
        manager = getSupportFragmentManager();

        manager.beginTransaction().add(R.id.fl, fragments.get(0)).commit();
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    Toolbar.setText("首页");
                } else if (position == 1) {
                    Toolbar.setText("项目");
                } else if (position == 2) {
                    Toolbar.setText("体系");
                } else if (position == 3) {
                    Toolbar.setText("公众号");
                } else if (position == 4) {
                    Toolbar.setText("导航");
                }
                Fragment fragment = fragments.get(position);
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                if (!fragment.isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragments.get(position));
                }
                fragmentTransaction.show(fragment);
                fragmentTransaction.hide(fragments.get(a));
                fragmentTransaction.commit();
                a = position;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onThemeChanged() {
        //日间模式下的颜色
        bt.setTextColor(getResources().getColor(ThemeManager .getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        relativeLayout.setBackgroundColor(getResources().getColor(ThemeManager .getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeManager .unregisterThemeChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    protected Propert createPersenter() {
        return new Propert();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuItem item = menu.add(1, 1, 1, "");
        item.setIcon(R.drawable.ic_action_action_search).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == 1) {
            Intent intent = new Intent(MainActivity.this, Acivity_search.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addZhihuFragment() {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.fl, fragments.get(0));
        fragmentTransaction.commit();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(MainActivity.this, Activity_collectionner.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this, Activity_about.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            String name = data.getStringExtra("name");
            viewById.setText(name);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }


}
