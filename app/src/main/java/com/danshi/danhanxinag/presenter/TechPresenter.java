package com.danshi.danhanxinag.presenter;

import com.danshi.danhanxinag.api.DanShiApi;
import com.danshi.danhanxinag.api.MeiZhiService;
import com.danshi.danhanxinag.model.GirlsEntity;
import com.danshi.danhanxinag.view.TechView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 20939 on 2016/11/18.
 */
public class TechPresenter extends BasePresenter<TechView> {

    @Override
    public void attachView(TechView mvpView) {
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


    /**
     * 获取随机网络妹纸图片
     * @param num
     */
    public void getRandomPic(int num){
        MeiZhiService.createApi(DanShiApi.class)
                .getRandomGirl(num)
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

                    }
                });

    }

    /**
     *  技术相关网络请求
     * @param tech
     * @param page
     */

    public void getTechPage(String tech, final int page){
        MeiZhiService.createApi(DanShiApi.class)
                .getTechList(tech,10,page)
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
