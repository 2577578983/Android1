package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_tixi;
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;

public interface System_liebiao {
    interface View extends IBaseView {
        void getIBseView_Tixi_liebiao(Bean_tixi_liebiao bean_tixi_liebiao);
    }
    interface Proeprt_Tixi_liebiao extends IPersenter<View> {
        void getda_Tixi_liebiao(String ui);
    }
}
