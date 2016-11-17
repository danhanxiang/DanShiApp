package com.danshi.danhanxinag.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.danshi.danhanxinag.base.BaseActivity;
import com.danshi.danhanxinag.danshiapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/17.
 */
public class AboutMeActivity extends BaseActivity {

    @BindView(R.id.about_me_toolbar)
    Toolbar toolbar;
    @BindView(R.id.about_me_imageview)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about_me);
        ButterKnife.bind(this);
        toolbar.setTitle(getString(R.string.about_me));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imageView.setImageResource(R.drawable.xiang);
    }
}