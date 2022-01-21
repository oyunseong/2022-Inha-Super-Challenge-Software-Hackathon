package com.miggle.miggle.server

import com.miggle.miggle.model.Movie
import com.miggle.miggle.model.MovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IkcAPI {
    // movie & Drama
    @GET("mainPageOne")
    fun getMovie(): Call<Movie?>?

    // recommended in the US
    @GET("mainPageTwo")
    fun getMovieUS(): Call<Movie?>

    @GET("detailPageOne")
    fun getDetail(): Call<MovieDetail>

}
