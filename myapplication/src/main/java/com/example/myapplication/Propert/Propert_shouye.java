package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Registered;
import com.example.myapplication.interfaces.news.Shouye;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_banner;
import com.example.myapplication.model.http.bean.Bean_collect;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_registered;
import com.example.myapplication.model.http.bean.Bean_shouye;
import com.example.myapplication.utils.RxUtils;

public class Propert_shouye extends BasePersenter<Shouye.View> implements Shouye.Propert_shouye {

    @Override
    public void getdata_shouye() {
        addSubscribe(HttpManager.getMyApi().getdata_shouye()
                .compose(RxUtils.<Bean_shouye>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_shouye>(mView) {
                    @Override
                    public void onNext(Bean_shouye bean_shouye) {
                        mView.getIBseView_shouye(bean_shouye);
                    }
                }));
    }
    @Override
    public void getdata_banners() {
        addSubscribe(HttpManager.getMyApi().getdata_banner()
                .compose(RxUtils.<Bean_banner>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_banner>(mView) {
                    @Override
                    public void onNext(Bean_banner bean_banner) {
                        mView.getBnaner(bean_banner);
                    }
                }));
    }

    @Override
    public void getda_collect(int ur) {
        addSubscribe(HttpManager.getMyApi().getdata_collect(ur)
                .compose(RxUtils.<Bean_collect>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_collect>(mView) {
                    @Override
                    public void onNext(Bean_collect bean_collect) {
                        mView.getIBseView_collect(bean_collect);
                    }
                }));
    }

    @Override
    public void getda_quxiao(int ur) {
        addSubscribe(HttpManager.getMyApi().getdata_quxiao(ur)
                .compose(RxUtils.<Bean_quxiao>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_quxiao>(mView) {

                    @Override
                    public void onNext(Bean_quxiao bean_quxiao) {
                        mView.getIBseView_quxiao(bean_quxiao);
                    }
                }));
    }

}
