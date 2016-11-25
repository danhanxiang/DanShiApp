package com.danshi.danhanxiang.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.danshi.danhanxiang.danshiapp.R;
import com.danshi.danhanxiang.model.WeiXinArticleEntity;
import com.danshi.danhanxiang.utils.TimeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 20939 on 2016/11/16.
 */
public class WeiXinAdapter extends RecyclerArrayAdapter<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> {
    public WeiXinAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(parent);
    }




    class EasyViewHolder extends BaseViewHolder<WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean> {

        ImageView mImageView;
        TextView type;
        TextView title;
        TextView name;
        TextView time;

        public EasyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_weixin);
            /* itemView.findViewById()的封装 */
            mImageView = $(R.id.iv_pic);
            title = $(R.id.tv_title);
            type = $(R.id.tv_type);
            name = $(R.id.tv_name);
            time = $(R.id.tv_time);


        }

        @Override
        public void setData(WeiXinArticleEntity.ShowapiResBodyBean.PagebeanBean.ContentlistBean data) {
            Glide.with(getContext()).load(data.userLogo).error(R.mipmap.ic_android).into(mImageView);
            type.setText("#" + data.typeName + "#");
            title.setText(data.title );
            name.setText(data.userName);
            time.setText(TimeUtil.getDateBySplit(data.date));
        }
    }
}