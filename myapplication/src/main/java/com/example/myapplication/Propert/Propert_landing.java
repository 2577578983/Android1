package com.example.myapplication.Propert;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.component.CommonSubscriber;
import com.example.myapplication.interfaces.news.Landing;
import com.example.myapplication.interfaces.news.NewsContract;
import com.example.myapplication.interfaces.news.Registered;
import com.example.myapplication.model.http.HttpManager;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;
import com.example.myapplication.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import retrofit2.Retrofit;

public class Propert_landing extends BasePersenter<Landing.View> implements Landing.Proeprt_Landing {
    @Override
    public void getda_Landing(String username, String password) {
        addSubscribe(HttpManager.getMyApi().getdata_landing(username,password)
                .compose(RxUtils.<Bean_landing>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_landing>(mView) {
                    @Override
                    public void onNext(Bean_landing bean_landing) {
                        mView.getIBseView_Landing(bean_landing);
                    }
                }));
    }
}
