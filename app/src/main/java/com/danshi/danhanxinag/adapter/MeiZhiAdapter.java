package com.danshi.danhanxinag.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.MeiZhi;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MeiZhiAdapter extends RecyclerArrayAdapter<MeiZhi.NewslistBean> {
    public MeiZhiAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(parent);
    }




    class EasyViewHolder extends BaseViewHolder<MeiZhi.NewslistBean> {
        ImageView mImageView;
        TextView mTime;

        public EasyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_meizhi);
            /* itemView.findViewById()的封装 */
            mImageView = $(R.id.iv_pic);
            mTime = $(R.id.tv_time);
        }

        @Override
        public void setData(MeiZhi.NewslistBean data) {
            mTime.setText(data.ctime);
            Glide.with(getContext()).load(data.picUrl).error(R.mipmap.ic_launcher).into(mImageView);
        }
    }
}