package com.im.nbaplayerengine.data.remote.service

import com.im.nbaplayerengine.data.remote.dashboard.StandingNetworkEntity
import com.im.nbaplayerengine.data.remote.news.NewsNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface StandingService {

    @GET("standings?league=12&season=2021-2022")
    suspend fun getStanding(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
    ): StandingNetworkEntity

}