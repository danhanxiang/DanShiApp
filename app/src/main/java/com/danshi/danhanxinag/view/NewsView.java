package com.danshi.danhanxinag.view;

import com.danshi.danhanxinag.model.News;

import java.util.List;

/**
 * Created by 20939 on 2016/11/16.
 */
public interface NewsView extends MvpView {

    void refresh(List<News.NewslistBean> data);

    void loadMore(List<News.NewslistBean> data);

}
