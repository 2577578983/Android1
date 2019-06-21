package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_Navigation;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;

public interface Navigation {
    //主页数据
    interface View extends IBaseView {
        void getIndexReturn_navigation(Bean_Navigation bean_navigation);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        void getIndex_navigation();

    }
}
