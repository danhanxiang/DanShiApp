package com.danshi.danhanxinag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.RetrofitService.NewsService;
import com.danshi.danhanxinag.adapter.EasyRecyclerAdapter;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.News;
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
public class NewsFragment extends BaseFragment {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private View view;

    private int page = 0;
    private EasyRecyclerAdapter adapter;


    public static final String BASE_URL = "http://api.tianapi.com/";
    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";

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
        adapter = new EasyRecyclerAdapter(getActivity());


        easyRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                easyGetDatas();
            }
        }, 1000);
        easyRecyclerView.setAdapter(adapter);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                easyRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 0;
                        adapter.clear();
                        easyGetDatas();
                    }
                }, 1000);
            }
        });
        adapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                easyRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        easyGetDatas();
                    }
                }, 1000);
            }

            @Override
            public void onMoreClick() {

            }
        });
        /* 设置item点击事件 */
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Intent intent = new Intent(getActivity(), DetailActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("PicUrl", adapter.getAllData().get(position).getPicUrl());
//                bundle.putString("ContentUrl", adapter.getAllData().get(position).getUrl());
//                intent.putExtras(bundle);
//                startActivity(intent);
            }
        });


    }

    private void easyGetDatas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsFragment.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        NewsService newsService = retrofit.create(NewsService.class);
        newsService.getNewsDatas(NewsFragment.APIKEY, "10", page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<News, List<News.NewslistBean>>() {
                    @Override
                    public List<News.NewslistBean> call(News news) {
                        return news.getNewslist();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<News.NewslistBean>>() {
                    @Override
                    public void onCompleted() {
                        easyRecyclerView.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(easyRecyclerView, "", Snackbar.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<News.NewslistBean> newslistBeen) {
                        adapter.addAll(newslistBeen);
                    }
                });
        page++;

    }
}
