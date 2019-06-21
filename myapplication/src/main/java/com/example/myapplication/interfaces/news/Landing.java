package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_landing;

public interface Landing {
    interface View extends IBaseView {
        void getIBseView_Landing(Bean_landing bean_landing);
    }
    interface Proeprt_Landing extends IPersenter<View> {
        void getda_Landing(String username,String password);
    }
}
