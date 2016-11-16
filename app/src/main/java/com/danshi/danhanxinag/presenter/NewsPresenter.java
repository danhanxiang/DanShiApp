package com.danshi.danhanxinag.presenter;

import com.danshi.danhanxinag.view.NewsView;


/**
 * Created by 20939 on 2016/11/16.
 */
public class NewsPresenter extends BasePresenter<NewsView> {

    @Override
    public void attachView(NewsView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }
    private  int page = 0;

//    public void getNewsData(){
//        HttpService.createApi(DanShiApi.class)
//                .getNewsDatas("", "10", page)
//                .subscribeOn(Schedulers.io())
//                .map(new Func1<News, List<News.NewslistBean>>() {
//                    @Override
//                    public List<News.NewslistBean> call(News news) {
//                        return news.getNewslist();
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<List<News.NewslistBean>>() {
//                    @Override
//                    public void onCompleted() {
//                        easyRecyclerView.setRefreshing(false);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Snackbar.make(easyRecyclerView, R.string.network_error, Snackbar.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onNext(List<News.NewslistBean> newslistBeen) {
//                        adapter.addAll(newslistBeen);
//                    }
//                });
//        page++;
//
//    }
}
