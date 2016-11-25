package com.danshi.danhanxiang.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.danshi.danhanxiang.base.BaseActivity;
import com.danshi.danhanxiang.danshiapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/17.
 */
public class WeiXinDetailActivity extends BaseActivity {
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
        toolbarLayout.setTitle(getResources().getString(R.string.weixin));
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
        Bundle bundle = getIntent().getExtras();
        Glide.with(this).load(bundle.getString("PicUrl")).error(R.mipmap.logo).into(detailImageView);
        /* 设置webView在应用内显示内容 */
        detailWebView.getSettings().setJavaScriptEnabled(true);
        detailWebView.setWebViewClient(new WebViewClient());
        detailWebView.loadUrl(bundle.getString("ContentUrl"));
    }
}
