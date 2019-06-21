package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.System;
import com.example.myapplication.interfaces.news.System_liebiao;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_tixi;
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;
import com.example.myapplication.utils.RxUtils;

public class Propert_TiXiLieBiao extends BasePersenter<System_liebiao.View>implements System_liebiao.Proeprt_Tixi_liebiao {

    @Override
    public void getda_Tixi_liebiao(String ui) {
        addSubscribe(HttpManager.getMyApi().getdata_tixi_liebiao(ui)
                .compose(RxUtils.<Bean_tixi_liebiao>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_tixi_liebiao>(mView) {
                    @Override
                    public void onNext(Bean_tixi_liebiao bean_tixi_liebiao) {
                        mView.getIBseView_Tixi_liebiao(bean_tixi_liebiao);
                    }
                }));
    }
}
