package com.danshi.danhanxiang.presenter;

import com.danshi.danhanxiang.api.DanShiApi;
import com.danshi.danhanxiang.api.MeiZhiService;
import com.danshi.danhanxiang.model.GirlsEntity;
import com.danshi.danhanxiang.view.MeiZhiView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 20939 on 2016/11/18.
 */
public class MeiZhiPresenter extends BasePresenter<MeiZhiView> {

    @Override
    public void attachView(MeiZhiView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }


    public void getMeiZhiPic(final int page) {
        MeiZhiService.createApi(DanShiApi.class).getPictures(10, page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<GirlsEntity, List<GirlsEntity.ResultsBean>>() {
                    @Override
                    public List<GirlsEntity.ResultsBean> call(GirlsEntity girlsEntity) {
                        return girlsEntity.getResults();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<GirlsEntity.ResultsBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError("网络错误！");
                    }

                    @Override
                    public void onNext(List<GirlsEntity.ResultsBean> resultsBeen) {
                        if (page == 1) {
                            getMvpView().refresh(resultsBeen);
                        } else {
                            getMvpView().loadMore(resultsBeen);
                        }
                    }
                });
    }
}
