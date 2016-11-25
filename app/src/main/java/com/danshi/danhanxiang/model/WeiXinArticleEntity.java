package com.danshi.danhanxiang.model;

import java.util.List;

/**
 * Created by 20939 on 2016/11/23.
 */
public class WeiXinArticleEntity {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"pagebean":{"allNum":25434,"allPages":1272,"contentlist":[{"contentImg":"http://app1.showapi.com/weixin_info/article/0df9ffd5-c70c-4c35-bf1a-c16b7de5acdb.jpg","date":"2015-08-13 10:53","id":"55cc27086e36a9c5946e9004","title":"[影像]史上最霸气的4张照片，一定要横着看!","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=221359497&idx=4&sn=912db380b6df66405eacd81861e12e92&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/89d3162e-a9af-4621-a31f-efb94d5ac99c.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/1240f53a-acab-4406-9724-cdf6b8ab53b8.jpg","userName":"人民日报"},{"contentImg":"http://app1.showapi.com/weixin_info/article/7750c1a3-f988-4348-8087-3f62a369e682.jpg","date":"2015-08-13 10:52","id":"55cc27086e36a9c5946e9003","title":"最近做了一批恶趣味福利准备发\u2026\u2026","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MzA4MDE4OTYxNA==&mid=310850006&idx=4&sn=3291f731fd0f9edf9ae6e56e6a2e0df4&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/87ebc1c7-cb2e-4e4e-a776-381c64118f22.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/b598e031-a73e-4b2a-8769-9015665f8a9e.jpg","userName":"关爱八卦成长协会"},{"contentImg":"http://app1.showapi.com/weixin_info/article/487b016b-4e97-42ab-ad11-22e014a4800d.jpg","date":"2015-08-13 11:22","id":"55cc27076e36a9c5946e9002","title":"世上唯一在等你的人，看完我哭了","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MzA3NjA5MTkxNw==&mid=213270400&idx=3&sn=ba3e5c1e10151d32e8bf40d6ee3a282c&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/e8370091-c577-4632-bf2f-44ed633fcea9.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/3b3fa69c-67ca-4fe5-99af-706ee35d7c3b.jpg","userName":"成功智慧"}],"currentPage":1,"maxResult":20},"ret_code":0}
     */

    public int showapi_res_code;
    public String showapi_res_error;
    /**
     * pagebean : {"allNum":25434,"allPages":1272,"contentlist":[{"contentImg":"http://app1.showapi.com/weixin_info/article/0df9ffd5-c70c-4c35-bf1a-c16b7de5acdb.jpg","date":"2015-08-13 10:53","id":"55cc27086e36a9c5946e9004","title":"[影像]史上最霸气的4张照片，一定要横着看!","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=221359497&idx=4&sn=912db380b6df66405eacd81861e12e92&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/89d3162e-a9af-4621-a31f-efb94d5ac99c.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/1240f53a-acab-4406-9724-cdf6b8ab53b8.jpg","userName":"人民日报"},{"contentImg":"http://app1.showapi.com/weixin_info/article/7750c1a3-f988-4348-8087-3f62a369e682.jpg","date":"2015-08-13 10:52","id":"55cc27086e36a9c5946e9003","title":"最近做了一批恶趣味福利准备发\u2026\u2026","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MzA4MDE4OTYxNA==&mid=310850006&idx=4&sn=3291f731fd0f9edf9ae6e56e6a2e0df4&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/87ebc1c7-cb2e-4e4e-a776-381c64118f22.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/b598e031-a73e-4b2a-8769-9015665f8a9e.jpg","userName":"关爱八卦成长协会"},{"contentImg":"http://app1.showapi.com/weixin_info/article/487b016b-4e97-42ab-ad11-22e014a4800d.jpg","date":"2015-08-13 11:22","id":"55cc27076e36a9c5946e9002","title":"世上唯一在等你的人，看完我哭了","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MzA3NjA5MTkxNw==&mid=213270400&idx=3&sn=ba3e5c1e10151d32e8bf40d6ee3a282c&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/e8370091-c577-4632-bf2f-44ed633fcea9.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/3b3fa69c-67ca-4fe5-99af-706ee35d7c3b.jpg","userName":"成功智慧"}],"currentPage":1,"maxResult":20}
     * ret_code : 0
     */

    public ShowapiResBodyBean showapi_res_body;

    public static class ShowapiResBodyBean {
        /**
         * allNum : 25434
         * allPages : 1272
         * contentlist : [{"contentImg":"http://app1.showapi.com/weixin_info/article/0df9ffd5-c70c-4c35-bf1a-c16b7de5acdb.jpg","date":"2015-08-13 10:53","id":"55cc27086e36a9c5946e9004","title":"[影像]史上最霸气的4张照片，一定要横着看!","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=221359497&idx=4&sn=912db380b6df66405eacd81861e12e92&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/89d3162e-a9af-4621-a31f-efb94d5ac99c.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/1240f53a-acab-4406-9724-cdf6b8ab53b8.jpg","userName":"人民日报"},{"contentImg":"http://app1.showapi.com/weixin_info/article/7750c1a3-f988-4348-8087-3f62a369e682.jpg","date":"2015-08-13 10:52","id":"55cc27086e36a9c5946e9003","title":"最近做了一批恶趣味福利准备发\u2026\u2026","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MzA4MDE4OTYxNA==&mid=310850006&idx=4&sn=3291f731fd0f9edf9ae6e56e6a2e0df4&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/87ebc1c7-cb2e-4e4e-a776-381c64118f22.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/b598e031-a73e-4b2a-8769-9015665f8a9e.jpg","userName":"关爱八卦成长协会"},{"contentImg":"http://app1.showapi.com/weixin_info/article/487b016b-4e97-42ab-ad11-22e014a4800d.jpg","date":"2015-08-13 11:22","id":"55cc27076e36a9c5946e9002","title":"世上唯一在等你的人，看完我哭了","typeId":"0","typeName":"热点","url":"http://mp.weixin.qq.com/s?__biz=MzA3NjA5MTkxNw==&mid=213270400&idx=3&sn=ba3e5c1e10151d32e8bf40d6ee3a282c&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/article/e8370091-c577-4632-bf2f-44ed633fcea9.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/article/3b3fa69c-67ca-4fe5-99af-706ee35d7c3b.jpg","userName":"成功智慧"}]
         * currentPage : 1
         * maxResult : 20
         */

        public PagebeanBean pagebean;
        public int ret_code;

        public static class PagebeanBean {
            public int allNum;
            public int allPages;
            public int currentPage;
            public int maxResult;
            /**
             * contentImg : http://app1.showapi.com/weixin_info/article/0df9ffd5-c70c-4c35-bf1a-c16b7de5acdb.jpg
             * date : 2015-08-13 10:53
             * id : 55cc27086e36a9c5946e9004
             * title : [影像]史上最霸气的4张照片，一定要横着看!
             * typeId : 0
             * typeName : 热点
             * url : http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=221359497&idx=4&sn=912db380b6df66405eacd81861e12e92&3rd=MzA3MDU4NTYzMw==&scene=6#rd
             * userLogo : http://app1.showapi.com/weixin_info/article/89d3162e-a9af-4621-a31f-efb94d5ac99c.jpg
             * userLogo_code : http://app1.showapi.com/weixin_info/article/1240f53a-acab-4406-9724-cdf6b8ab53b8.jpg
             * userName : 人民日报
             */

            public List<ContentlistBean> contentlist;

            public static class ContentlistBean {
                public String contentImg;
                public String date;
                public String id;
                public String title;
                public String typeId;
                public String typeName;
                public String url;
                public String userLogo;
                public String userLogo_code;
                public String userName;
            }
        }
    }
}
