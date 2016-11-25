package com.danshi.danhanxinag.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.danshi.danhanxinag.app.App;
import com.danshi.danhanxinag.danshiapp.R;

/**
 * Created by 20939 on 2016/11/21.
 */
public class ToastUtil {
    private static int screenWidth;

    public static void createToast(Context context,String title) {

        Toast mToast = new Toast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_toast);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(getScreenWidth(), 80);
        textView.setLayoutParams(params);
        mToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setView(view);
        textView.setText(title);
        mToast.show();
    }


    /**
     * 获取屏幕的宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        return screenWidth = screenWidth == 0 ? App.getInstance().getApplicationContext()
                .getResources().getDisplayMetrics().widthPixels : screenWidth;

    }
}
