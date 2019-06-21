package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Navigation;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_Navigation;
import com.example.myapplication.model.http.bean.Bean_public;
import com.example.myapplication.utils.RxUtils;

public class Propert_navigation extends BasePersenter<Navigation.View> implements Navigation.Presenter {
    @Override
    public void getIndex_navigation() {
        addSubscribe(HttpManager.getMyApi().getdata_Navigation()
                .compose(RxUtils.<Bean_Navigation>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_Navigation>(mView) {
                    @Override
                    public void onNext(Bean_Navigation bean_navigation) {
                        mView.getIndexReturn_navigation(bean_navigation);
                    }
                }));
    }
}
