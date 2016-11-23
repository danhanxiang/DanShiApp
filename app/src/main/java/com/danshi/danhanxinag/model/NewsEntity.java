package com.danshi.danhanxinag.model;

import java.util.List;

/**
 * Created by 20939 on 2016/11/23.
 */
public class NewsEntity {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-11-23 14:23","title":"在华被捕日本人用搜集情报换酬劳 一次数百美元","description":"搜狐国际","picUrl":"","url":"http://news.sohu.com/20161123/n473930598.shtml"},{"ctime":"2016-11-23 14:24","title":"中国月嫂持旅游签赴美或涉欺诈罪 最高可判15年","description":"搜狐国际","picUrl":"","url":"http://news.sohu.com/20161123/n473930626.shtml"},{"ctime":"2016-11-23 14:36","title":"韩执政党前党首带头弹劾朴槿惠 不参加下届大选","description":"搜狐国际","picUrl":"","url":"http://news.sohu.com/20161123/n473932468.shtml"},{"ctime":"2016-11-23 14:39","title":"菲律宾与美国取消两项军演 拟缩减两军互动","description":"搜狐国际","picUrl":"","url":"http://news.sohu.com/20161123/n473932745.shtml"},{"ctime":"2016-11-23 14:43","title":"韩政法系统两大主管齐请辞 或对总统被立案负责","description":"搜狐国际","picUrl":"","url":"http://news.sohu.com/20161123/n473933515.shtml"},{"ctime":"2016-11-23 15:06","title":"外交部领事司提醒中国公民近期谨慎前往缅北地区","description":"搜狐国际","picUrl":"","url":"http://news.sohu.com/20161123/n473936520.shtml"},{"ctime":"2016-11-23 15:16","title":"三个摇摆州投票系统或被黑 希拉里本可能当总统？","description":"搜狐国际","picUrl":"http://photocdn.sohu.com/20161123/Img473924551_ss.jpg","url":"http://news.sohu.com/20161123/n473937013.shtml"},{"ctime":"2016-11-23 15:24","title":"印度女部长：印度属于强奸案最低4个国家之一","description":"搜狐国际","picUrl":"http://photocdn.sohu.com/20161123/Img473932746_ss.png","url":"http://news.sohu.com/20161123/n473937606.shtml"},{"ctime":"2016-11-23 15:26","title":"日不满南京大屠杀档案申遗成功 拒交教科文组织经费","description":"搜狐国际","picUrl":"http://photocdn.sohu.com/20161123/Img473937014_ss.jpeg","url":"http://news.sohu.com/20161123/n473937798.shtml"},{"ctime":"2016-11-23 15:41","title":"泰国下月起减免中国游客旅游签证费 落地签194元","description":"搜狐国际","picUrl":"http://photocdn.sohu.com/20161123/Img473937607_ss.jpeg","url":"http://news.sohu.com/20161123/n473939493.shtml"}]
     */

    public int code;
    public String msg;
    /**
     * ctime : 2016-11-23 14:23
     * title : 在华被捕日本人用搜集情报换酬劳 一次数百美元
     * description : 搜狐国际
     * picUrl :
     * url : http://news.sohu.com/20161123/n473930598.shtml
     */

    public List<NewslistBean> newslist;

    public static class NewslistBean {
        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;
    }
}
