package com.im.nbaplayerengine.data.remote.service

import com.im.nbaplayerengine.data.remote.news.NewsNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsService {

    @GET("v1/search?q=nba&lang=en")
    suspend fun getNews(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
    ): NewsNetworkEntity
}