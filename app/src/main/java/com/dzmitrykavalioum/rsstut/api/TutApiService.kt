package com.dzmitrykavalioum.rsstut.api

import com.dzmitrykavalioum.rsstut.model.Feed
import com.dzmitrykavalioum.rsstut.model.Feed1
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TutApiService {
    @GET("index.rss")
    fun getNews(): Call<Feed1>
}