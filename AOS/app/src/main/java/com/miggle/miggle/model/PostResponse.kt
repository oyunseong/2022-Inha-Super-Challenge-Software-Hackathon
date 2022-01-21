package com.miggle.miggle.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)