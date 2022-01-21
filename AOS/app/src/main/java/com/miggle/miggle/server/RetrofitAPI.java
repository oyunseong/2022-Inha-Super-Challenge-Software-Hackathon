package com.miggle.miggle.server;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface RetrofitAPI {

    @GET("http://www.developer-hyun.com/app/users/miggle/dart")
    Call<Model__CheckAlready> getDart(
            @Query("crtfc_key") String crtfc_key,
            @Query("corp_code") String corp_code,
            @Query("bsns_year") int bsns_year,
            @Query("reprt_code") int reprt_code
    );


    //@FormUrlEncoded
    //@POST("/auth/overlapChecker")
    //Call<Model__CheckAlready> postOverlapCheck(@Field("phone") String phoneNum, @Field("message") String message); //이건 요청시 사용하는거 (*데이터를 보낼때)
}