package com.danshi.danhanxinag.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.News;
import com.danshi.danhanxinag.view.NewsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class TechFragment extends BaseFragment implements NewsView {
    @BindView(R.id.tab)
    TabLayout mTabLayout;
    @BindView(R.id.vp)
    ViewPager mViewPager;
    private int page = 1;

    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";
    private View view;

    private String TITLE [] = {"Android","IOS","WEB"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.news_fragment_layout, container, false);
            ButterKnife.bind(this, view);
            initView();
        }
        ButterKnife.bind(this, view);
        return view;

    }

    private void initView() {
        mViewPager.setAdapter(new TechAdapter(getChildFragmentManager(),TITLE));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0;i<TITLE.length;i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(TITLE[i]));
        }
        mTabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public void refresh(List<News.NewslistBean> data) {

    }

    @Override
    public void loadMore(List<News.NewslistBean> data) {

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
    public void showError(String msg) {

    }

    private class TechAdapter extends FragmentStatePagerAdapter {
        private String [] titles;
        public TechAdapter(FragmentManager fm, String[] TITLE) {
            super(fm);
            this.titles = TITLE;

        }

        @Override
        public Fragment getItem(int position) {
            return TechFragments.getInstance(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
