package com.example.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment <V extends IBaseView,P extends IPersenter> extends Fragment implements IBaseView {

    protected P persenter;

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), container, false);
        bind = ButterKnife.bind(this, inflate);
        persenter=Propert_sss();
        if (persenter!=null){
            persenter.attchView(this);
        }
        initView();
        initdata();
        return inflate;
    }

    protected abstract P Propert_sss();

    protected void initView() {
    }

    protected void initdata() {

    }

    protected abstract int getLayout();

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (persenter!=null){
            persenter.attchView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (persenter!=null){
            persenter.detachView();
        }
        if (bind!=null){
            bind.unbind();
        }
    }
}
