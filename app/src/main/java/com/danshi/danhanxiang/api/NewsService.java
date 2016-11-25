package com.danshi.danhanxiang.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 20939 on 2016/11/16.
 */
public class NewsService {

    public static final String BASE_URL = "http://api.tianapi.com/";
    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";


    private static final String BASETESTURL  = "http://api.tianapi.com/";
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor
            (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASETESTURL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private NewsService() {
        //construct

    }

    public static <T> T createApi(Class<T> clazz) {

        return retrofit.create(clazz);
    }

}

