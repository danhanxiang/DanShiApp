package com.danshi.danhanxiang.presenter;

import com.danshi.danhanxiang.api.DanShiApi;
import com.danshi.danhanxiang.api.HttpService;
import com.danshi.danhanxiang.model.WeiXinArticleEntity;
import com.danshi.danhanxiang.view.WeiXinView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 20939 on 2016/11/16.
 */
public class WeiXinPresenter extends BasePresenter<WeiXinView> {

    @Override
    public void attachView(WeiXinView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getWeiXinList(final int page) {
        HttpService.createApi(DanShiApi.class)
                .getWeixin("1","推荐",page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<WeiXinArticleEntity, List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> call(WeiXinArticleEntity weiXinArticleEntity) {
                        return weiXinArticleEntity.showapi_res_body.pagebean.contentlist;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError("网络错误！");
                    }

                    @Override
                    public void onNext(List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlistBeen) {
                        if (page ==1){
                            getMvpView().refresh(contentlistBeen);
                        }else {
                            getMvpView().loadMore(contentlistBeen);
                        }

                    }
                });

    }

}
