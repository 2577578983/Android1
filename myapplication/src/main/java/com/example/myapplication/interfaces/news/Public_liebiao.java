package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_public;
import com.example.myapplication.model.http.bean.Bean_public_liebiao;

public interface Public_liebiao {
    //主页数据
    interface View extends IBaseView {
        void getIndexReturn_public_liebiao(Bean_public_liebiao bean_public_liebiao);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        void getIndex_public_liebiao(String page);

    }
}
