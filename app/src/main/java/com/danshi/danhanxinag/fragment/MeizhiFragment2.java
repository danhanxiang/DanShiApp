package com.danshi.danhanxinag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.adapter.MeiZhiAdapter;
import com.danshi.danhanxinag.api.DanShiApi;
import com.danshi.danhanxinag.api.HttpService;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.MeiZhi;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MeizhiFragment2 extends BaseFragment {
    @BindView(R.id.pic_recycler_view)
    EasyRecyclerView pictureRecyclerView;
    private View view;


    private MeiZhiAdapter adapter;
    private int page = 10;

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
        pictureRecyclerView.setRefreshing(true);
        pictureRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        adapter = new MeiZhiAdapter(getActivity());
        /* 设置延迟1秒后显示内容 */
        pictureRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                getPictureDatas();
            }
        },1000);
        pictureRecyclerView.setAdapter(adapter);
        /* 设置下拉刷新动作 */
        pictureRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pictureRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        page = 1;
                        getPictureDatas();
                    }
                },1000);

            }
        });
        /* 上拉加载更多 */
        adapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                pictureRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPictureDatas();
                    }
                }, 1000);
            }

            @Override
            public void onMoreClick() {

            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Intent intent = new Intent(getActivity(), MeiZhiDetailActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("PicUrl",adapter.getAllData().get(position).getUrl());
//                bundle.putString("PicId",adapter.getAllData().get(position).get_id());
//                intent.putExtras(bundle);
//                startActivity(intent);
            }
        });

    }

    private void getPictureDatas() {

        HttpService.createApi(DanShiApi.class).getMeiZhiPic(page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<MeiZhi, List<MeiZhi.NewslistBean>>() {
                    @Override
                    public List<MeiZhi.NewslistBean> call(MeiZhi meiZhi) {
                        return meiZhi.newslist;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MeiZhi.NewslistBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<MeiZhi.NewslistBean> newslistBeen) {
                    adapter.addAll(newslistBeen);
                    }
                });
    }
}
