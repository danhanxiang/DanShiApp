package com.danshi.danhanxinag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class StoryFragment extends BaseFragment implements JokeView {

    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private View view;

    private JokePresenter jokePresenter;
    private LinearLayoutManager layoutManager;
    private int page = 1;
    private List<ContentlistEntity> jokeList;
    private JokeAdapter jokeAdapter;

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

        jokeList = new ArrayList<>();
        jokeAdapter = new JokeAdapter(getActivity());
        easyRecyclerView.setAdapter(jokeAdapter);

        jokePresenter = new JokePresenter();
        jokePresenter.attachView(this);

        initData();
    }

    private void initData() {
        jokePresenter.loadList(page);
        page++;
    }



    @Override
    public void refresh(List<ContentlistEntity> data) {
        jokeAdapter.addAll(data);
    }

    @Override
    public void loadMore(List<ContentlistEntity> data) {

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
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId) {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }
}
