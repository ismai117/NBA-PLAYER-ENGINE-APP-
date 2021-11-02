package com.im.nbaplayerengine.data.repository

import androidx.lifecycle.asLiveData
import androidx.room.withTransaction
import com.im.nbaplayerengine.data.cache.*
import com.im.nbaplayerengine.network.Retrofit.WebService
import com.im.nbaplayerengine.utils.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository
@Inject
constructor(
    private val playerDao: PlayerDao,
    private val teamDao: TeamDao,
    private val seasonDao: SeasonDao,
    private val webSerice: WebService,
    private val engineDatabase: EngineDatabase
){

    fun getPlayers(host: String, key: String) = networkBoundResource(
        query = {
            playerDao.getPLayers()
        },
        fetch = {
            webSerice.getPlayers(host = host, key = key)
        },
        saveFetchResult = { players ->
            engineDatabase.withTransaction {
                playerDao.deleteAllPlayers()
                playerDao.insert(players)
            }
        }
    )


    fun getTeams(host: String, key: String) = networkBoundResource(
        query = {
            teamDao.getTeams()
        },
        fetch = {
            webSerice.getTeams(host = host, key = key)
        },
        saveFetchResult = { players ->
            engineDatabase.withTransaction {
                teamDao.deleteAllTeams()
                teamDao.insert(players)
            }
        }
    )


    fun getSeasons(host: String, key: String, playerId: Int) = networkBoundResource(
        query = {
            seasonDao.getSeasons()
        },
        fetch = {
            webSerice.getSeasons(host = host, key = key, playerId = playerId)
        },
        saveFetchResult = { seasons ->
            engineDatabase.withTransaction {
                seasonDao.deleteAllSeasons()
                seasonDao.insert(seasons)
            }
        }
    )





    fun searchPlayer(searchQuery: String): Flow<List<PlayerCacheEntity>> {
        return playerDao.searchDatabase(searchQuery = searchQuery)
    }



}

























