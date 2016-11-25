package com.danshi.danhanxiang.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.danshi.danhanxiang.base.BaseActivity;
import com.danshi.danhanxiang.danshiapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/17.
 */
public class AboutMeActivity extends BaseActivity {

    @BindView(R.id.iv_about_me)
    ImageView ivAboutMe;

    @BindView(R.id.detail_tool_bar)
    Toolbar detailToolBar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.detail_web_view)
    TextView detailWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about_me);
        ButterKnife.bind(this);
        toolbarLayout.setTitle(getResources().getString(R.string.about_xiangzi));
        setSupportActionBar(detailToolBar);
        /* 显示返回箭头 */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /* 设置返回箭头点击事件 */
        detailToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}