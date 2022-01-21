package com.miggle.miggle.model

data class DartResponse (
    val isSuccess: Boolean? = null,
    val code: Int? = null,
    val message: String? = null,
    val result: Movie
)

//data class Result(
//    val plusmoney : String? = null
//)