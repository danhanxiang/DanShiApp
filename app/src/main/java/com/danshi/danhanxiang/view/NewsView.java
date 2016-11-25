package com.danshi.danhanxiang.view;

import com.danshi.danhanxiang.model.News;

import java.util.List;

/**
 * Created by 20939 on 2016/11/16.
 */
public interface NewsView extends MvpView {

    void refresh(List<News.NewslistBean> data);

    void loadMore(List<News.NewslistBean> data);

}
