package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_liebiao;
import com.example.myapplication.model.http.bean.Bean_tixi;

public interface System {
    interface View extends IBaseView {
        void getIBseView_Tixi(Bean_tixi bean_tixi);
    }
    interface Proeprt_Tixi extends IPersenter<View> {
        void getda_Tixi();
    }
}
