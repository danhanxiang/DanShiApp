package com.danshi.danhanxiang.view;


import com.danshi.danhanxiang.model.WeiXinArticleEntity;

import java.util.List;

/**
 * Created by 20939 on 2016/11/16.
 */
public interface WeiXinView extends MvpView {


    void refresh(List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> data);

    void loadMore(List<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> data);

}
