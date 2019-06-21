package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.NewsContract;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;
import com.example.myapplication.utils.RxUtils;

public class Propert extends BasePersenter<NewsContract.View> implements NewsContract.Presenter {

    @Override
    public void getIndex() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
                .compose(RxUtils.<Bean_wanAndorid>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_wanAndorid>(mView) {
                    @Override
                    public void onNext(Bean_wanAndorid bean_wanAndorid) {
                        mView.getIndexReturn(bean_wanAndorid);
                    }
                }));
    }
}
