package com.danshi.danhanxiang.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.danshi.danhanxiang.base.BaseActivity;
import com.danshi.danhanxiang.danshiapp.R;

import java.util.ArrayList;

/**
 * Created by 20939 on 2016/12/15.
 */
public class TestviewActivity extends BaseActivity {
    private PieView pie;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        initView();
    }

    private void initView() {
        pie = (PieView) findViewById(R.id.pie);
        ArrayList<PieData> datas = new ArrayList<>();
        PieData pieData = new PieData("sloop", 60);
        PieData pieData2 = new PieData("sloop", 30);
        PieData pieData3 = new PieData("sloop", 40);
        PieData pieData4 = new PieData("sloop", 20);
        PieData pieData5 = new PieData("sloop", 20);
        datas.add(pieData);
        datas.add(pieData2);
        datas.add(pieData3);
        datas.add(pieData4);
        datas.add(pieData5);
        pie.setData(datas);
    }
}
