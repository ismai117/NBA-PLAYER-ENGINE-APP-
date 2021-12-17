package com.im.nbaplayerengine.data.remote.service

import com.im.nbaplayerengine.data.remote.games.GamesNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GamesService {

    @GET("basketball/matches-by-date")
    suspend fun getGames(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
        @Query("date")  date: String,
        @Query("country_code") code: String,
    ): GamesNetworkEntity

}