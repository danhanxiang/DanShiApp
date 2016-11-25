package com.danshi.danhanxiang.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MeiZhiService {

    private static final String BASETESTURL = "http://gank.io/api/";
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor
            (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASETESTURL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MeiZhiService() {
        //construct

    }


    public static <T> T createApi(Class<T> clazz) {

        return retrofit.create(clazz);
    }

}

