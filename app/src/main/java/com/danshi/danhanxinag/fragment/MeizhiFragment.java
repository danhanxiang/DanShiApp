package com.danshi.danhanxinag.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.RetrofitService.GankService;
import com.danshi.danhanxinag.activity.MeiZhiDetailActivity;
import com.danshi.danhanxinag.adapter.PictureRecyclerAdapter;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.Girls;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MeizhiFragment extends BaseFragment {
    @BindView(R.id.pic_recycler_view)
    EasyRecyclerView pictureRecyclerView;
    private View view;

    public static final String GANK_URL = "http://gank.io/api/";
    private PictureRecyclerAdapter adapter;
    private int page = 1;

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
        adapter = new PictureRecyclerAdapter(getActivity());
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
                Intent intent = new Intent(getActivity(), MeiZhiDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("PicUrl",adapter.getAllData().get(position).getUrl());
                bundle.putString("PicId",adapter.getAllData().get(position).get_id());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void getPictureDatas(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GANK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        GankService gankService = retrofit.create(GankService.class);
        gankService.getPictures(20,page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<Girls, List<Girls.ResultsBean>>() {
                    @Override
                    public List<Girls.ResultsBean> call(Girls girls) {
                        return girls.getResults();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Girls.ResultsBean>>() {
                    @Override
                    public void onCompleted() {
                        pictureRecyclerView.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        pictureRecyclerView.setRefreshing(false);
                        Snackbar.make(pictureRecyclerView, "error",Snackbar.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<Girls.ResultsBean> resultsBeen) {
                        adapter.addAll(resultsBeen);
                    }
                });
        page++;
    }
}
