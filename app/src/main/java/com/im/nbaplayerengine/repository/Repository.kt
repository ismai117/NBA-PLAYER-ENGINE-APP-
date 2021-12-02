package com.im.nbaplayerengine.repository

import androidx.room.withTransaction
import com.im.nbaplayerengine.data.local.database.EngineDatabase
import com.im.nbaplayerengine.data.local.players.PlayerCacheEntity
import com.im.nbaplayerengine.data.local.players.PlayerDao
import com.im.nbaplayerengine.data.local.seasons.SeasonDao
import com.im.nbaplayerengine.data.local.teams.TeamDao
import com.im.nbaplayerengine.data.local.util.PlayerCacheMapper
import com.im.nbaplayerengine.data.local.util.SeasonCacheMapper
import com.im.nbaplayerengine.data.local.util.TeamCacheMapper
import com.im.nbaplayerengine.data.remote.util.PlayerResponseMapper
import com.im.nbaplayerengine.data.remote.service.WebService
import com.im.nbaplayerengine.data.remote.util.SeasonResponseMapper
import com.im.nbaplayerengine.data.remote.util.TeamResponseMapper
import com.im.nbaplayerengine.model.player.Player
import com.im.nbaplayerengine.model.seasons.Season
import com.im.nbaplayerengine.model.teams.Team
import com.im.nbaplayerengine.utils.Resource
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
    private val engineDatabase: EngineDatabase,
    private val playerResponseMapper: PlayerResponseMapper,
    private val teamResponseMapper: TeamResponseMapper,
    private val seasonResponseMapper: SeasonResponseMapper,
    private val playerCacheMapper: PlayerCacheMapper,
    private val teamCacheMapper: TeamCacheMapper,
    private val seasonCacheMapper: SeasonCacheMapper,
) {


    fun getPlayers(host: String, key: String): Flow<Resource<List<Player>>> {
        return networkBoundResource(
            query = {
                playerCacheMapper.mapFromFlowEntityList(playerDao.getPLayers())
            },
            fetch = {
                val response = webSerice.getPlayers(host, key)
                playerResponseMapper.fromNetworkEntityList(response)
            },
            saveFetchResult = {
                engineDatabase.withTransaction {
                    playerDao.deleteAllPlayers()
                    playerDao.insert(playerCacheMapper.mapToEntityList(it))
                }
            }
        )
    }

    fun getTeams(host: String, key: String): Flow<Resource<List<Team>>> {
        return networkBoundResource(
            query = {
                teamCacheMapper.mapFromFlowEntityList(teamDao.getTeams())
            },
            fetch = {
                val response = webSerice.getTeams(host, key)
                teamResponseMapper.fromNetworkEntityList(response)
            },
            saveFetchResult = {
                engineDatabase.withTransaction {
                    teamDao.deleteAllTeams()
                    teamDao.insert(teamCacheMapper.mapToEntityList(it))
                }
            }
        )
    }

    fun getSeasons(host: String, key: String, playerId: Int): Flow<Resource<List<Season>>> {
        return networkBoundResource(
            query = {
                seasonCacheMapper.mapFromFlowEntityList(seasonDao.getSeasons())
            },
            fetch = {
                val response = webSerice.getSeasons(host, key, playerId)
                seasonResponseMapper.fromNetworkEntityList(response)
            },
            saveFetchResult = {
                engineDatabase.withTransaction {
                    seasonDao.deleteAllSeasons()
                    seasonDao.insert(seasonCacheMapper.mapToEntityList(it))
                }
            }
        )
    }

    fun searchPlayer(searchQuery: String): Flow<List<Player>> {
        return playerCacheMapper.mapFromFlowEntityList(playerDao.searchDatabase(searchQuery = searchQuery))
    }


}

























