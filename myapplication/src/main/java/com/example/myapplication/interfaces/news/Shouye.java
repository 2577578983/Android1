package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_banner;
import com.example.myapplication.model.http.bean.Bean_collect;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_shouye;

public interface Shouye {
    interface View extends IBaseView{
        void getIBseView_shouye(Bean_shouye bean_shouye);
        void getBnaner(Bean_banner bean_banner);
        void getIBseView_collect(Bean_collect bean_collect);
        void getIBseView_quxiao(Bean_quxiao bean_quxiao);
    }
    interface Propert_shouye extends IPersenter<View>{
        void getdata_shouye();
        void getdata_banners();
        void getda_collect(int ur);
        void getda_quxiao(int ur);
    }
}