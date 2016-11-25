package com.danshi.danhanxiang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxiang.activity.TechDetailActivity;
import com.danshi.danhanxiang.adapter.TechAdapter;
import com.danshi.danhanxiang.base.BaseFragment;
import com.danshi.danhanxiang.danshiapp.R;
import com.danshi.danhanxiang.model.GirlsEntity;
import com.danshi.danhanxiang.presenter.TechPresenter;
import com.danshi.danhanxiang.utils.SnackbarUtil;
import com.danshi.danhanxiang.view.TechView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/21.
 */
public class TechFragments extends BaseFragment implements TechView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {
    @BindView(R.id.tech_recycler_view)
    EasyRecyclerView techRecyclerView;
    private TechPresenter mTechPresenter;
    private View view;
    private int position;
    public int page = 1;
    private TechAdapter mTechAdapter;
    private String tech [] = {"Android","iOS","前端"};
    public static Fragment getInstance(int position) {
        TechFragments f = new TechFragments();
        Bundle b = new Bundle();
        b.putInt("position", position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null) {
            position = b.getInt("position");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.tech_fragment, container, false);
            ButterKnife.bind(this, view);
            initView();
        }
        return view;

    }

    private void initView() {
        mTechPresenter = new TechPresenter();
        mTechPresenter.attachView(this);
        mTechPresenter.getTechPage(tech[position], page);

        techRecyclerView.setRefreshing(true);
        techRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTechAdapter = new TechAdapter(getActivity(),tech[position]);
        techRecyclerView.setAdapter(mTechAdapter);
        techRecyclerView.setRefreshListener(this);
        mTechAdapter.setOnItemClickListener(this);


        mTechAdapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                page++;
                mTechPresenter.getTechPage(tech[position], page);
            }

            @Override
            public void onMoreClick() {

            }
        });
    }


    @Override
    public void refresh(List<GirlsEntity.ResultsBean> data) {
        techRecyclerView.setRefreshing(false);
        mTechAdapter.addAll(data);
    }

    @Override
    public void loadMore(List<GirlsEntity.ResultsBean> data) {
        mTechAdapter.addAll(data);
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
        SnackbarUtil.showShort(getView(),msg);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTechPresenter.detachView();
    }
    @Override
    public void onRefresh() {
        techRecyclerView.setRefreshing(true);
        mTechAdapter.clear();
        page = 1;
        mTechPresenter.getTechPage(tech[position] , page);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), TechDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", mTechAdapter.getAllData().get(position).getUrl());
        bundle.putString("title", mTechAdapter.getAllData().get(position).getDesc());
        bundle.putString("id", mTechAdapter.getAllData().get(position).get_id());
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
