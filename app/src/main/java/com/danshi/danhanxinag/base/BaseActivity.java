package com.danshi.danhanxinag.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.danshi.danhanxinag.view.MvpView;

import java.util.List;

/**
 * Created by 20939 on 2016/11/16.
 */
public class BaseActivity extends AppCompatActivity implements MvpView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId) {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }

    protected void showContentFragment(BaseFragment to, int container) {
        if (to != null) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            if (to.isAdded()) {
                t.show(to);
            } else {
                t.add(container, to, to.getClass().getSimpleName());
            }
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (fragments == null) {
                t.commit();
                return;
            }
            for (Fragment fragment : fragments) {
                if (fragment != to && !fragment.isHidden()) {
                    t.hide(fragment);
                }
            }
            t.commit();
        }
    }

    protected <T extends View> T $(View view,int id) {
        return (T) view.findViewById(id);
    }
}
