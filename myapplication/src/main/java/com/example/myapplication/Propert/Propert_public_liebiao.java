package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Public_liebiao;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_public;
import com.example.myapplication.model.http.bean.Bean_public_liebiao;
import com.example.myapplication.utils.RxUtils;

public class Propert_public_liebiao extends BasePersenter<Public_liebiao.View> implements Public_liebiao.Presenter {
    @Override
    public void getIndex_public_liebiao(String page) {
        addSubscribe(HttpManager.getMyApi().getdata_public_liebiao(page)
                .compose(RxUtils.<Bean_public_liebiao>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_public_liebiao>(mView) {
                    @Override
                    public void onNext(Bean_public_liebiao bean_public_liebiao) {
                        mView.getIndexReturn_public_liebiao(bean_public_liebiao);
                    }
                }));
    }
}
