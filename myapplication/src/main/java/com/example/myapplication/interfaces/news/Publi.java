package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_public;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;

public interface Publi {
    //主页数据
    interface View extends IBaseView {
        void getIndexReturn(Bean_public bean_public);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        void getIndex();

    }
}
