package com.danshi.danhanxinag.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.activity.NewsDetailActivity;
import com.danshi.danhanxinag.adapter.NewsAdapter;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.News;
import com.danshi.danhanxinag.presenter.NewsPresenter;
import com.danshi.danhanxinag.view.NewsView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class NewsMainFragment extends BaseFragment implements NewsView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private int page = 1;
    private NewsAdapter adapter;

    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";
    private View view;
    private NewsPresenter mNewsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.news_main_fragment_layout, container, false);
            ButterKnife.bind(this, view);
            initView();
        }
        ButterKnife.bind(this, view);
        return view;

    }

    private void initView() {
        mNewsPresenter = new NewsPresenter();
        mNewsPresenter.attachView(this);
        easyRecyclerView.setRefreshing(true);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsAdapter(getActivity());
        easyRecyclerView.setAdapter(adapter);
        easyRecyclerView.setRefreshListener(this);
        adapter.setOnItemClickListener(this);

        adapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                page++;
                mNewsPresenter.getNewsData(page);
            }

            @Override
            public void onMoreClick() {

            }
        });

    }

    @Override
    public void refresh(List<News.NewslistBean> data) {
        easyRecyclerView.setRefreshing(false);
        adapter.addAll(data);
    }

    @Override
    public void loadMore(List<News.NewslistBean> data) {
        adapter.addAll(data);
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
    public void onRefresh() {
        easyRecyclerView.setRefreshing(true);
        adapter.clear();
        page = 1;
        mNewsPresenter.getNewsData(page);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("PicUrl", adapter.getAllData().get(position).getPicUrl());
        bundle.putString("ContentUrl", adapter.getAllData().get(position).getUrl());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
