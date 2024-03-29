package com.example.myapplication.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.utils.SystemUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<V extends IBaseView,P extends IPersenter> extends AppCompatActivity implements IBaseView {

    protected Context context;
    protected P persenter;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        if(!SystemUtils.checkNetWork()){
            //自定义布局实现无网络状态的提示
            View view = LayoutInflater.from(this).inflate(R.layout.layout_network_error,null);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addContentView(view,params);
        }else{
            context = this;
            initView();
            persenter = createPersenter();
            if(persenter != null){
                persenter.attchView(this);
            }
            initData();
        }
    }

    //获取布局
    protected abstract int getLayout();

    //初始化布局
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //创建P
    protected abstract P createPersenter();

    @Override
    protected void onResume() {
        super.onResume();
        if(persenter != null){
            persenter.attchView(this);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(unbinder != null)
        {
            unbinder.unbind();
        }
    }
}
