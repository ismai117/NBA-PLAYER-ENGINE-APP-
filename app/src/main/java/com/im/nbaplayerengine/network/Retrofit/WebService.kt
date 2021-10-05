package com.im.nbaplayerengine.network.Retrofit

import com.im.nbaplayerengine.data.cache.PlayerCacheEntity
import com.im.nbaplayerengine.data.cache.TeamCacheEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface WebService {

    @GET("players")
    suspend fun getPlayers(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String
    ): List<PlayerCacheEntity>


    @GET("teams")
    suspend fun getTeams(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String
    ): List<TeamCacheEntity>

}