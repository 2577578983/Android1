package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_tiaomu;

public interface Entry {
    interface View extends IBaseView {
        void getIBseView_Tiao(Bean_tiaomu bean_tiaomu);
    }
    interface Proeprt_tiao extends IPersenter<View> {
        void getda_tiao();
    }
}
