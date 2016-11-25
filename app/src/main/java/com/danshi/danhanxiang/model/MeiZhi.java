package com.danshi.danhanxiang.model;

import java.util.List;

/**
 * Created by 20939 on 2016/11/18.
 */
public class MeiZhi {

    public int code;
    public String msg;

    public List<NewslistBean> newslist;

    public static class NewslistBean {
        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;
    }
}
