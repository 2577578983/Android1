package com.example.myapplication.interfaces.news;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.model.http.bean.Bean_registered;

public interface Registered {
    interface View extends IBaseView{
        void getIBseView_registered(Bean_registered bean_registered);
    }
    interface Proeprt_registered extends IPersenter<View>{
        void getda_registered(String username,String password,String repassword);

    }
}
