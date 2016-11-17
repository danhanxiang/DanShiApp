package com.danshi.danhanxinag.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.News;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


/**
 * Created by 20939 on 2016/11/16.
 */
public class NewsAdapter extends RecyclerArrayAdapter<News.NewslistBean> {
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(parent);
    }

    class EasyViewHolder extends BaseViewHolder<News.NewslistBean> {
        private ImageView easyImageView;
        private TextView easyTitleText;
        private TextView easyContentText;

        public EasyViewHolder(ViewGroup parent) {
            super(parent, R.layout.adapter_item);
            /* itemView.findViewById()的封装 */
            easyImageView = $(R.id.adapter_item_image);
            easyTitleText = $(R.id.adapter_item_title);
            easyContentText = $(R.id.adapter_item_content);
        }

        @Override
        public void setData(News.NewslistBean data) {
            easyTitleText.setText(data.getTitle());
            easyContentText.setText(data.getDescription());
            Glide.with(getContext())
                    .load(data.getPicUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(easyImageView);
        }
    }
}
