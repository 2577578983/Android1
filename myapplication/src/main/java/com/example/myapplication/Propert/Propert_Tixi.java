package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.System;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_tiaomu;
import com.example.myapplication.model.http.bean.Bean_tixi;
import com.example.myapplication.utils.RxUtils;

public class Propert_Tixi extends BasePersenter<System.View> implements System.Proeprt_Tixi {
    @Override
    public void getda_Tixi() {
        addSubscribe(HttpManager.getMyApi().getdta_tixi()
                .compose(RxUtils.<Bean_tixi>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_tixi>(mView) {
                    @Override
                    public void onNext(Bean_tixi bean_tixi) {
                        mView.getIBseView_Tixi(bean_tixi);
                    }
                }));
    }
}
