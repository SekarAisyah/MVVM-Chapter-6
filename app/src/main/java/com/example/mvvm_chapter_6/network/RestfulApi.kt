package com.example.mvvm_chapter_6.network

import com.example.mvvm_chapter_6.model.ResponseDataUserItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {

    @GET("news")
    fun getAllUser(): Call<List<ResponseDataUserItem>>
}