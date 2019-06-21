package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_Lei;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.SearchBean;

public interface Liushibuju {
    interface View extends IBaseView {
        void getIBseView_liushi(SearchBean searchBean);

    }
    interface Proeprt_liushi extends IPersenter<View> {
        void getda_liushi();

    }
}
