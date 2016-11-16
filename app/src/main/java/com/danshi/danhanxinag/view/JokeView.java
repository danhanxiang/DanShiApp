package com.danshi.danhanxinag.view;


import com.danshi.danhanxinag.model.ContentlistEntity;

import java.util.List;

/**
 * Created by JDD on 2016/4/21 0021.
 */
public interface JokeView extends MvpView {
    void refresh(List<ContentlistEntity> data);

    void loadMore(List<ContentlistEntity> data);

}
