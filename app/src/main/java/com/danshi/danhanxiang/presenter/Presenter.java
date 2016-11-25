package com.danshi.danhanxiang.presenter;


import com.danshi.danhanxiang.view.MvpView;

/**
 * Created by 20939 on 2016/11/16.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
