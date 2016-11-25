package com.danshi.danhanxiang.presenter;

import com.danshi.danhanxiang.api.DanShiApi;
import com.danshi.danhanxiang.api.NewsService;
import com.danshi.danhanxiang.model.News;
import com.danshi.danhanxiang.view.NewsView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by 20939 on 2016/11/16.
 */
public class NewsPresenter extends BasePresenter<NewsView> {
    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";
    @Override
    public void attachView(NewsView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }


    public void getNewsData(final int page) {
        NewsService.createApi(DanShiApi.class)
                .getNewsDatas(APIKEY, "10", page)
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

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError("网络错误！");
                    }

                    @Override
                    public void onNext(List<News.NewslistBean> newslistBeen) {
                        if (page == 1) {
                            getMvpView().refresh(newslistBeen);
                        } else {
                            getMvpView().loadMore(newslistBeen);
                        }
                    }
                });

    }


}
