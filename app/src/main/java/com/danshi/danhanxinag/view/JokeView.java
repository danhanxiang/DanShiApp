package com.danshi.danhanxinag.view;


import com.danshi.danhanxinag.model.ContentlistEntity;

import java.util.List;

/**
 * Created by 20939 on 2016/11/16.
 */
public interface JokeView extends MvpView {


    void refresh(List<ContentlistEntity> data);

    void loadMore(List<ContentlistEntity> data);

}
