package com.miggle.miggle.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String BASE_MIGGLE_URL = "http://www.developer-hyun.com/";

    public static RetrofitAPI getRetrofitAPIService() {
        return getInstance().create(RetrofitAPI.class);
    }

    public static PostAPI getPostService() {
        return getInstance().create(PostAPI.class);
    }

    /**
     * 레트로핏 인스턴스 반환 메서드
     * 빌더 패턴으로 레트로핏 인스턴스를 생성
     *
     * @return
     */
    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_MIGGLE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}