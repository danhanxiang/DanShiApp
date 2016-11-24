package com.danshi.danhanxinag.api;

import com.danshi.danhanxinag.model.GirlsEntity;
import com.danshi.danhanxinag.model.JokeEntity;
import com.danshi.danhanxinag.model.MeiZhi;
import com.danshi.danhanxinag.model.News;
import com.danshi.danhanxinag.model.WeiXinArticleEntity;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
/**
 * Created by 20939 on 2016/11/16.
 */
public interface DanShiApi {
    @Headers("apikey:83ec99fff780989a5376a1bc595ed5ff")
    @GET("showapi_open_bus/showapi_joke/joke_text")
    Observable<JokeEntity> getJoke(@Query("page") int page);

    // 微信精选
    @Headers("apikey:83ec99fff780989a5376a1bc595ed5ff")
    @GET("showapi_open_bus/weixin/weixin_article_list")
    Observable<WeiXinArticleEntity> getWeixin(@Query("typeId") String typeId, @Query("key") String key, @Query("page") int page);

    @Headers("apikey:83ec99fff780989a5376a1bc595ed5ff")
    @GET("/txapi/mvtp/meinv")
    Observable<MeiZhi> getMeiZhiPic( @Query("num") int page);


    @GET("data/福利/{num}/{page}")
    Observable<GirlsEntity> getPictures(@Path("num") int num, @Path("page") int page);

    /**
     * 技术文章列表
     */
    @GET("data/{tech}/{num}/{page}")
    Observable<GirlsEntity> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);
    /**
     * 随机妹纸图
     */
    @GET("random/data/福利/{num}")
    Observable<GirlsEntity> getRandomGirl(@Path("num") int num);


    //    科技新闻：
    @GET("keji/")
    Observable<News> getNewsDatas(@Query("key") String key,@Query("num") String num, @Query("page") int page);

}
