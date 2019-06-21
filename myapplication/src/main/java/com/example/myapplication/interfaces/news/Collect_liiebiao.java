package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_collect_liebiao;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_quxiaos;
import com.example.myapplication.model.http.bean.Bean_shanchu;
import com.example.myapplication.model.http.bean.Bean_tiaomu;

public interface Collect_liiebiao {
    interface View extends IBaseView {
        void getIBseView_collect_liebiao(Bean_collect_liebiao bean_collect_liebiao);
        void getIBseView_quxiaos(Bean_quxiaos bean_quxiaos);
    }
    interface Proeprt_collect_liebiao extends IPersenter<View> {
        void getda_collect_liebiao();
        void getda_quxiaos(int ur,int a);
    }
}
