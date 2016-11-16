package com.danshi.danhanxinag.presenter;


import com.danshi.danhanxinag.view.MvpView;

/**
 * Created by 20939 on 2016/11/16.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
