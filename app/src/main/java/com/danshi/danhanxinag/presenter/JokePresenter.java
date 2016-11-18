package com.danshi.danhanxinag.presenter;

import com.danshi.danhanxinag.api.DanShiApi;
import com.danshi.danhanxinag.api.HttpService;
import com.danshi.danhanxinag.model.ContentlistEntity;
import com.danshi.danhanxinag.model.JokeEntity;
import com.danshi.danhanxinag.view.JokeView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 20939 on 2016/11/16.
 */
public class JokePresenter extends BasePresenter<JokeView> {

    @Override
    public void attachView(JokeView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadList(final int page) {
        HttpService.createApi(DanShiApi.class)
                .getJoke(page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<JokeEntity, List<ContentlistEntity>>() {
                    @Override
                    public List<ContentlistEntity> call(JokeEntity jokeEntity) {
                        return jokeEntity.getShowapi_res_body().getContentlist();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ContentlistEntity>>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(null, null);
                    }

                    @Override
                    public void onNext(List<ContentlistEntity> contentlistEntities) {
                        if (page == 1) {
                            getMvpView().refresh(contentlistEntities);
                        } else {
                            getMvpView().loadMore(contentlistEntities);
                        }
                    }
                });

    }

}
