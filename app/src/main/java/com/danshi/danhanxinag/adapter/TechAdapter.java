package com.danshi.danhanxinag.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.GirlsEntity;
import com.danshi.danhanxinag.utils.DateUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 20939 on 2016/11/16.
 */
public class TechAdapter extends RecyclerArrayAdapter<GirlsEntity.ResultsBean> {
    private String mString;
    public TechAdapter(Context context,String tech) {
        super(context);
        this.mString = tech;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(parent);
    }




    class EasyViewHolder extends BaseViewHolder<GirlsEntity.ResultsBean> {
        ImageView ivIcon;
        TextView tvContent;
        TextView tvAuthor;
        TextView tvTime;

        public EasyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_tech);
            /* itemView.findViewById()的封装 */
            ivIcon = $(R.id.iv_tech_icon);
            tvContent = $(R.id.tv_tech_title);
            tvAuthor = $(R.id.tv_tech_author);
            tvTime = $(R.id.tv_tech_time);
        }

        @Override
        public void setData(GirlsEntity.ResultsBean data) {
//            mTime.setText(data.ctime);
//            Glide.with(getContext()).load(data.picUrl).error(R.mipmap.ic_launcher).into(mImageView);
            if(mString.equals("Android")) {
                ivIcon.setImageResource(R.mipmap.ic_android);
            } else if(mString.equals("iOS")) {
                ivIcon.setImageResource(R.mipmap.ic_ios);
            } else if(mString.equals("前端")) {
                ivIcon.setImageResource(R.mipmap.ic_web);
            }
            tvContent.setText(data.getDesc());
            tvAuthor.setText(data.getWho());
            String date = data.getPublishedAt();
            int idx = date.indexOf(".");
            date = date.substring(0,idx).replace("T"," ");
            tvTime.setText(DateUtil.formatDateTime(date,true));
        }
    }


}