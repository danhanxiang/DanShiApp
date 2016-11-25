package com.danshi.danhanxiang.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by 20939 on 2016/11/21.
 */
public class SnackbarUtil {
    public static void showLong(View view,String title){
        Snackbar.make(view,title,Snackbar.LENGTH_LONG).show();
    }
    public static void showShort(View view,String title){
        Snackbar.make(view,title,Snackbar.LENGTH_SHORT).show();
    }
}
