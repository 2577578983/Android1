package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_liebiao;

public interface Tableau {
    interface View extends IBaseView {
        void getIBseView_lieiao(Bean_liebiao bean_liebiao);
    }
    interface Proeprt_liebiao extends IPersenter<View> {
        void getda_liebiao(String url);
    }
}
