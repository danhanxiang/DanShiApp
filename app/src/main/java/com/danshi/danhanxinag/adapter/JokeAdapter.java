package com.danshi.danhanxinag.adapter;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.model.ContentlistEntity;
import com.danshi.danhanxinag.utils.TimeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 20939 on 2016/11/16.
 */
public class JokeAdapter extends RecyclerArrayAdapter<ContentlistEntity> {
    public JokeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(parent);
    }




    class EasyViewHolder extends BaseViewHolder<ContentlistEntity> {
        TextView title;
        TextView time;
        TextView content;

        public EasyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_story);
            /* itemView.findViewById()的封装 */
            title = $(R.id.title);
            time = $(R.id.time);
            content = $(R.id.content);


        }

        @Override
        public void setData(ContentlistEntity data) {

            title.setText("#" + data.getTitle() + "#");
            time.setText(TimeUtil.getDateBySplit(data.getCt()));
             /*使html中<标签>得以转化*/
            content.setText(Html.fromHtml(data.getText().toString()));
        }
    }
}