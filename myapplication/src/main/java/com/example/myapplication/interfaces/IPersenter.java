package com.example.myapplication.interfaces;

public interface IPersenter<V extends IBaseView> {

    void attchView(V view);

    void detachView();

}
