package com.example.myapplication.Propert.Ui_acivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Dbhdler.Dbhdler;
import com.example.myapplication.Propert.Propert_liushi;
import com.example.myapplication.R;
import com.example.myapplication.adaper.Adapert_jilu;
import com.example.myapplication.adaper.SearchAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.interfaces.news.Liushibuju;
import com.example.myapplication.model.http.bean.Bean_Lei;
import com.example.myapplication.model.http.bean.SearchBean;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Acivity_search extends BaseActivity<Liushibuju.View, Liushibuju.Proeprt_liushi> implements Liushibuju.View {

    @BindView(R.id.zuo)
    TextView zuo;
    @BindView(R.id.fl)
    RecyclerView fl;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_container)
    FrameLayout toolbarContainer;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_cun)
    TextView tvCun;
    @BindView(R.id.rx_jilu)
    RecyclerView rxJilu;
    private ArrayList<SearchBean> searchBeans;
    private SearchAdapter searchAdapter;
    private MenuItem item;
    private ArrayList<Bean_Lei> bean_leis;
    private Adapert_jilu adapert_jilu;


    @Override
    protected int getLayout() {
        return R.layout.activity_acivity_search;
    }

    @Override
    protected void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        searchBeans = new ArrayList<>();
        searchAdapter = new SearchAdapter(Acivity_search.this, searchBeans);
        fl.setAdapter(searchAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        fl.setLayoutManager(linearLayoutManager);
        zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bean_leis = new ArrayList<>();
        adapert_jilu = new Adapert_jilu(bean_leis, Acivity_search.this);
        rxJilu.setAdapter(adapert_jilu);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(Acivity_search.this);
        rxJilu.setLayoutManager(linearLayoutManager1);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {

            private Bean_Lei bean_lei;

            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Bean_Lei> query1 = Dbhdler.getDbhdler().queryName(query);
                        bean_leis.addAll(query1);
                adapert_jilu.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                Toast.makeText(Acivity_search.this, "onSearchViewShown", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchViewClosed() {
                Toast.makeText(Acivity_search.this, "onSearchViewClosed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
        persenter.getda_liushi();
    }

    @Override
    protected Liushibuju.Proeprt_liushi createPersenter() {
        return new Propert_liushi();
    }

    @Override
    public void getIBseView_liushi(SearchBean searchBean) {
        if (searchBean != null) {
            searchBeans.add(searchBean);
        }
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        item = menu.findItem(R.id.action_search);
        //隐藏menu,搜索框就不见了,想要搜索框不见只能使用mSearchViewItem
        item.setVisible(true);
        searchView.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            onBackPressed();
        }
    }

}
