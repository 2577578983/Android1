package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Entry;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_shouye;
import com.example.myapplication.model.http.bean.Bean_tiaomu;
import com.example.myapplication.utils.RxUtils;

import org.w3c.dom.Entity;

public class Propert_tiao extends BasePersenter<Entry.View> implements  Entry.Proeprt_tiao {
    @Override
    public void getda_tiao() {
        addSubscribe(HttpManager.getMyApi().getdata_tiao()
                .compose(RxUtils.<Bean_tiaomu>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_tiaomu>(mView) {
                    @Override
                    public void onNext(Bean_tiaomu bean_tiaomu) {
                        mView.getIBseView_Tiao(bean_tiaomu);
                    }
                }));
    }
}
