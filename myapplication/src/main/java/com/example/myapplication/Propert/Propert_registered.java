package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Registered;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_registered;
import com.example.myapplication.utils.RxUtils;

public class Propert_registered extends BasePersenter<Registered.View>implements Registered.Proeprt_registered {

    @Override
    public void getda_registered(String username, String password, String repassword) {
        addSubscribe(HttpManager.getMyApi().getdata_registered(username,password,repassword)
                .compose(RxUtils.<Bean_registered>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_registered>(mView) {
                    @Override
                    public void onNext(Bean_registered bean_registered) {
                        mView.getIBseView_registered(bean_registered);
                    }
                }));
    }
}
