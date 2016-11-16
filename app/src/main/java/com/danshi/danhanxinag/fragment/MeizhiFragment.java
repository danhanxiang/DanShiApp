package com.danshi.danhanxinag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danshi.danhanxinag.adapter.PictureRecyclerAdapter;
import com.danshi.danhanxinag.base.BaseFragment;
import com.danshi.danhanxinag.danshiapp.R;
import com.jude.easyrecyclerview.EasyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MeizhiFragment extends BaseFragment {
    @BindView(R.id.pic_recycler_view)
    EasyRecyclerView pic_recycler_view;
    private View view;

    public static final String GANK_URL = "http://gank.io/api/";
    private PictureRecyclerAdapter adapter;
    private int page = 1;
    @BindView(R.id.pic_recycler_view)
    EasyRecyclerView pictureRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.meizhi_fragment_layout, container, false);
            ButterKnife.bind(this, view);
            initView();

        }
        return view;

    }

    private void initView() {


    }
}
