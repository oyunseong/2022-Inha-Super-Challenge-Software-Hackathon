package com.miggle.miggle.server

import com.miggle.miggle.model.DartResponse
import com.miggle.miggle.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPI {

    @GET("posts/1")
    suspend fun getPost(): Post

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("app/users/miggle/dart/")
    fun getDart(
        @Query("crtfc_key") crtfc_key: String?,
        @Query("corp_code") corp_code: String?,
        @Query("bsns_year") bsns_year: Int,
        @Query("reprt_code") reprt_code: Int
    ): Call<DartResponse?>?
    // call 안에 response가 들어가야함
}