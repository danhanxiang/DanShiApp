package com.danshi.danhanxinag.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.danshi.danhanxinag.danshiapp.R;

/**
 * Created by 20939 on 2016/11/21.
 */
public class ToastUtil {
    private static Toast mToast;
    private static Context mContext;

    public ToastUtil(Context context) {
        this.mContext = context;
    }
    public static Toast createLong(String title){

        mToast = new Toast(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.meizhi_fragment_layout, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_toast);
        mToast.setView(view);
        mToast.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
        mToast.setDuration(Toast.LENGTH_LONG);
        textView.setText(title);
        return mToast;
    }

    public static Toast createShort(String title){
        mToast = new Toast(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.meizhi_fragment_layout, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_toast);
        mToast.setView(view);
        mToast.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
        mToast.setDuration(Toast.LENGTH_SHORT);
        textView.setText(title);
        return mToast;
    }

}
