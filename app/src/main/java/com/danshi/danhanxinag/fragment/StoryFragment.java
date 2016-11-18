package com.danshi.danhanxinag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.adapter.JokeAdapter;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.ContentlistEntity;
import com.danshi.danhanxinag.presenter.JokePresenter;
import com.danshi.danhanxinag.view.JokeView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class StoryFragment extends BaseFragment implements JokeView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {

    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private View view;

    private JokePresenter jokePresenter;

    private JokeAdapter jokeAdapter;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.news_fragment_layout, container, false);
            ButterKnife.bind(this, view);
            initView();
        }
        return view;

    }

    private void initView() {

        easyRecyclerView.setRefreshing(true);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jokeAdapter = new JokeAdapter(getActivity());
        easyRecyclerView.setAdapter(jokeAdapter);
        easyRecyclerView.setRefreshListener(this);
        jokeAdapter.setOnItemClickListener(this);
        jokeAdapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                page++;
                jokePresenter.loadList(page);
            }

            @Override
            public void onMoreClick() {

            }
        });

        jokePresenter = new JokePresenter();
        jokePresenter.attachView(this);

        jokePresenter.loadList(page);


    }

    @Override
    public void refresh(List<ContentlistEntity> data) {
        easyRecyclerView.setRefreshing(false);
        jokeAdapter.addAll(data);
    }

    @Override
    public void loadMore(List<ContentlistEntity> data) {
        jokeAdapter.addAll(data);
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
        jokeAdapter.clear();
        page = 1;
        jokePresenter.loadList(page);
    }

    @Override
    public void onItemClick(int position) {
        Snackbar.make(getView(), "position=="+position,Snackbar.LENGTH_SHORT).show();
    }
}
