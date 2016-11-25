package com.danshi.danhanxiang.view;

import com.danshi.danhanxiang.model.GirlsEntity;

import java.util.List;

/**
 * Created by 20939 on 2016/11/18.
 */
public interface MeiZhiView extends MvpView {

    void refresh(List<GirlsEntity.ResultsBean> data);

    void loadMore(List<GirlsEntity.ResultsBean> data);
}
