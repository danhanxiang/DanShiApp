
package com.danshi.danhanxinag.view;


import android.view.View;
/**
 * Created by 20939 on 2016/11/16.
 */
public interface MvpView {

    void showLoading(String msg);

    void hideLoading();

    void showError(String msg);

    void showError(String msg, View.OnClickListener onClickListener);


}
