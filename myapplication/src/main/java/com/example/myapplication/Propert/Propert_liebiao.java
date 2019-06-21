package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Tableau;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_liebiao;
import com.example.myapplication.utils.RxUtils;

public class Propert_liebiao extends BasePersenter<Tableau.View> implements Tableau.Proeprt_liebiao {
    @Override
    public void getda_liebiao(String url) {
        addSubscribe(HttpManager.getMyApi().getdata(url)
                .compose(RxUtils.<Bean_liebiao>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_liebiao>(mView) {

                    @Override
                    public void onNext(Bean_liebiao bean_liebiao) {
                        mView.getIBseView_lieiao(bean_liebiao);
                    }
                }));
    }
}
