package com.danshi.danhanxinag.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.activity.MeiZhiDetailActivity;
import com.danshi.danhanxinag.adapter.PictureRecyclerAdapter;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.GirlsEntity;
import com.danshi.danhanxinag.presenter.MeiZhipPresenter;
import com.danshi.danhanxinag.utils.SnackbarUtil;
import com.danshi.danhanxinag.view.MeiZhiView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MeizhiFragment extends BaseFragment implements MeiZhiView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {
    @BindView(R.id.pic_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private View view;

    private PictureRecyclerAdapter adapter;
    private int page = 1;
    private MeiZhipPresenter mMeiZhipPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.meizhi_fragment_layout, container, false);
            ButterKnife.bind(this, view);
            initView();

        }
        return view;

    }

    private void initView() {
        mMeiZhipPresenter = new MeiZhipPresenter();
        mMeiZhipPresenter.attachView(this);
        mMeiZhipPresenter.getMeiZhiPic(page);

        easyRecyclerView.setRefreshing(true);
        easyRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        adapter = new PictureRecyclerAdapter(getActivity());
        easyRecyclerView.setAdapter(adapter);
        /* 设置下拉刷新动作 */
        easyRecyclerView.setRefreshListener(this);
        /* 上拉加载更多 */
        adapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                page++;
                mMeiZhipPresenter.getMeiZhiPic(page);
            }

            @Override
            public void onMoreClick() {

            }
        });
        adapter.setOnItemClickListener(this);

    }


    @Override
    public void refresh(List<GirlsEntity.ResultsBean> data) {
        easyRecyclerView.setRefreshing(false);
        adapter.addAll(data);
    }

    @Override
    public void loadMore(List<GirlsEntity.ResultsBean> data) {
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
    public void showError(String msg) {
        SnackbarUtil.showShort(getView(),msg);
    }

    @Override
    public void onRefresh() {
        easyRecyclerView.setRefreshing(true);
        adapter.clear();
        page = 1;
        mMeiZhipPresenter.getMeiZhiPic(page);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMeiZhipPresenter.detachView();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), MeiZhiDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("PicUrl", adapter.getAllData().get(position).getUrl());
        bundle.putString("PicId", adapter.getAllData().get(position).get_id());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
