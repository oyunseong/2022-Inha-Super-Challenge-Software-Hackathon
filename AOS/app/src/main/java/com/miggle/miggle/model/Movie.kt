package com.miggle.miggle.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("result")
    val result: List<Result>,
)

data class Review(
    @SerializedName("result")
    val review: List<Result>
)

data class RvResult(
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: String,
)

data class MovieDetail(
    @SerializedName("result")
    val result: List<Detail>,
)

data class Detail(
    @SerializedName("koreaTitle")
    val kTitle: String,
    @SerializedName("englishTitle")
    val eTitle: String,
    @SerializedName("imageUrl")
    val image: String,
    @SerializedName("englishExplain")
    val englishExplain : String,
    @SerializedName("movieUrl")
    val movieUrl : String
)

data class Result(
    @SerializedName("englishTitle")
    val title: String,
    @SerializedName("imageUrl")
    val image: String,
)

