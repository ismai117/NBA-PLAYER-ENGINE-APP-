package com.im.nbaplayerengine.data.remote.service

import com.im.nbaplayerengine.data.local.players.PlayerCacheEntity
import com.im.nbaplayerengine.data.local.seasons.SeasonCacheEntity
import com.im.nbaplayerengine.data.local.teams.TeamCacheEntity
import com.im.nbaplayerengine.data.remote.players.PlayerNetworkEntity
import com.im.nbaplayerengine.data.remote.seasons.SeasonNetworkEntity
import com.im.nbaplayerengine.data.remote.teams.TeamNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WebService {

    @GET("players")
    suspend fun getPlayers(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String
    ): List<PlayerNetworkEntity>


    @GET("teams")
    suspend fun getTeams(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String
    ): List<TeamNetworkEntity>

    @GET("playerseasons")
    suspend fun getSeasons(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
        @Query("playerId") playerId: Int
    ): List<SeasonNetworkEntity>

}