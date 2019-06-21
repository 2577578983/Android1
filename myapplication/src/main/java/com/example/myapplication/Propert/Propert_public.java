package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Publi;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_public;
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;
import com.example.myapplication.utils.RxUtils;

public class Propert_public extends BasePersenter<Publi.View> implements Publi.Presenter {
    @Override
    public void getIndex() {
        addSubscribe(HttpManager.getMyApi().getdata_public()
                .compose(RxUtils.<Bean_public>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_public>(mView) {

                    @Override
                    public void onNext(Bean_public bean_public) {
                        mView.getIndexReturn(bean_public);
                    }
                }));
    }
}
