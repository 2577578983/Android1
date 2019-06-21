package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Collect_liiebiao;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_collect_liebiao;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_quxiaos;
import com.example.myapplication.model.http.bean.Bean_shanchu;
import com.example.myapplication.utils.RxUtils;

public class Propert_collect_liebiao extends BasePersenter<Collect_liiebiao.View> implements Collect_liiebiao.Proeprt_collect_liebiao {
    @Override
    public void getda_collect_liebiao() {
        addSubscribe(HttpManager.getMyApi().getdata_collect_liebiao()
                .compose(RxUtils.<Bean_collect_liebiao>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_collect_liebiao>(mView) {
                    @Override
                    public void onNext(Bean_collect_liebiao bean_collect_liebiao) {
                        mView.getIBseView_collect_liebiao(bean_collect_liebiao);
                    }
                }));
    }

    @Override
    public void getda_quxiaos(int ur, int a) {
        addSubscribe(HttpManager.getMyApi().getdata_quxiaos(ur,a)
                .compose(RxUtils.<Bean_quxiaos>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_quxiaos>(mView) {
                    @Override
                    public void onNext(Bean_quxiaos bean_quxiaos) {
                        mView.getIBseView_quxiaos(bean_quxiaos);
                    }
                }));
    }


}
