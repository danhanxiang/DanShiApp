package com.danshi.danhanxinag.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.danshi.danhanxinag.base.BaseActivity;
import com.danshi.danhanxinag.danshiapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/23.
 */
public class TechDetailActivity extends BaseActivity {
    @BindView(R.id.detail_image_view)
    ImageView detailImageView;
    @BindView(R.id.detail_web_view)
    WebView detailWebView;
    @BindView(R.id.detail_tool_bar)
    Toolbar detailToolBar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        toolbarLayout.setTitle(bundle.getString("title"));
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
        /* 获取Bundle中的数据 */

        Glide.with(this).load("").error(R.mipmap.bg_drawer).into(detailImageView);
        /* 设置webView在应用内显示内容 */
        detailWebView.getSettings().setJavaScriptEnabled(true);
        detailWebView.setWebViewClient(new WebViewClient());
        detailWebView.loadUrl(bundle.getString("url"));
    }
}
