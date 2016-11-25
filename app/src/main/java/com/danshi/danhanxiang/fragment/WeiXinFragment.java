package com.danshi.danhanxiang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxiang.activity.WeiXinDetailActivity;
import com.danshi.danhanxiang.adapter.WeiXinAdapter;
import com.danshi.danhanxiang.base.BaseFragment;
import com.danshi.danhanxiang.danshiapp.R;
import com.danshi.danhanxiang.model.WeiXinArticleEntity;
import com.danshi.danhanxiang.presenter.WeiXinPresenter;
import com.danshi.danhanxiang.utils.SnackbarUtil;
import com.danshi.danhanxiang.view.WeiXinView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class WeiXinFragment extends BaseFragment implements WeiXinView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {

    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private View view;

    private WeiXinPresenter mWeiXinPresenter;
    private WeiXinAdapter mWeiXinAdapter;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.story_fragment_layout, container, false);
            ButterKnife.bind(this, view);
            initView();
        }
        return view;

    }

    private void initView() {
        mWeiXinPresenter = new WeiXinPresenter();
        mWeiXinPresenter.attachView(this);
        mWeiXinPresenter.getWeiXinList(page);

        easyRecyclerView.setRefreshing(true);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWeiXinAdapter = new WeiXinAdapter(getActivity());
        easyRecyclerView.setAdapter(mWeiXinAdapter);
        easyRecyclerView.setRefreshListener(this);
        mWeiXinAdapter.setOnItemClickListener(this);
        mWeiXinAdapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                page++;
                mWeiXinPresenter.getWeiXinList(page);
            }

            @Override
            public void onMoreClick() {

            }
        });

    }


    @Override
    public void refresh(List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> data) {
        easyRecyclerView.setRefreshing(false);
        mWeiXinAdapter.addAll(data);
    }

    @Override
    public void loadMore(List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> data) {
        mWeiXinAdapter.addAll(data);
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
        SnackbarUtil.showShort(getView(), msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mWeiXinPresenter.detachView();
    }

    @Override
    public void onRefresh() {
        easyRecyclerView.setRefreshing(true);
        mWeiXinAdapter.clear();
        page = 1;
        mWeiXinPresenter.getWeiXinList(page);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), WeiXinDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ContentUrl", mWeiXinAdapter.getAllData().get(position).url);
        bundle.putString("PicUrl", mWeiXinAdapter.getAllData().get(position).contentImg);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
