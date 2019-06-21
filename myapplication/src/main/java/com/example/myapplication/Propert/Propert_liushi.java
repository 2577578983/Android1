package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Landing;
import com.example.myapplication.interfaces.news.Liushibuju;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_registered;
import com.example.myapplication.model.http.bean.SearchBean;
import com.example.myapplication.utils.RxUtils;

public class Propert_liushi extends BasePersenter<Liushibuju.View> implements Liushibuju.Proeprt_liushi{


    @Override
    public void getda_liushi() {
        addSubscribe(HttpManager.getMyApi().getdata_liushi()
                .compose(RxUtils.<SearchBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SearchBean>(mView) {

                    @Override
                    public void onNext(SearchBean searchBean) {
                        mView.getIBseView_liushi(searchBean);
                    }
                }));
    }

}
