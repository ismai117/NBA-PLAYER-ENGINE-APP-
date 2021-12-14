package com.im.nbaplayerengine.repository

import android.util.Log
import androidx.room.Query
import androidx.room.withTransaction
import com.im.nbaplayerengine.data.local.dashboard.StandingCacheEntity
import com.im.nbaplayerengine.data.local.dashboard.StandingDao
import com.im.nbaplayerengine.data.local.database.EngineDatabase
import com.im.nbaplayerengine.data.local.news.NewsDao
import com.im.nbaplayerengine.data.local.players.PlayerDao
import com.im.nbaplayerengine.data.local.seasons.SeasonDao
import com.im.nbaplayerengine.data.local.teams.TeamDao
import com.im.nbaplayerengine.data.local.util.*

import com.im.nbaplayerengine.data.remote.service.NewsService

import com.im.nbaplayerengine.data.remote.service.PlayerService
import com.im.nbaplayerengine.data.remote.service.StandingService
import com.im.nbaplayerengine.data.remote.util.*

import com.im.nbaplayerengine.model.news.News
import com.im.nbaplayerengine.model.players.Player
import com.im.nbaplayerengine.model.seasons.Season
import com.im.nbaplayerengine.model.standings.Standing
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
    private val newsDao: NewsDao,
    private val standingDao: StandingDao,
    private val playerSerice: PlayerService,
    private val newsService: NewsService,
    private val standingService: StandingService,
    private val engineDatabase: EngineDatabase,
    private val playerResponseMapper: PlayerResponseMapper,
    private val teamResponseMapper: TeamResponseMapper,
    private val seasonResponseMapper: SeasonResponseMapper,
    private val newsResponseMapper: NewsResponseMapper,
    private val standingResponseMapper: StandingResponseMapper,
    private val playerCacheMapper: PlayerCacheMapper,
    private val teamCacheMapper: TeamCacheMapper,
    private val seasonCacheMapper: SeasonCacheMapper,
    private val newsCacheMapper: NewsCacheMapper,
    private val standingCacheMapper: StandingCacheMapper,
) {



    fun getEasternConference(conference: String): Flow<List<Standing>> {
        return standingCacheMapper.mapFromFlowEntityList(standingDao.getEasternConference(conference))
    }


    fun getWesternConference(conference: String): Flow<List<Standing>> {
        return standingCacheMapper.mapFromFlowEntityList(standingDao.getWesternConference(conference))
    }


    fun getStandings(host: String, key: String): Flow<Resource<List<Standing>>> {

        return networkBoundResource(
            query = {
                standingCacheMapper.mapFromFlowEntityList(standingDao.getStandings())
            },
            fetch = {
                val response = standingService.getStanding(host, key).response
                standingResponseMapper.fromNetworkEntityListList(response)
            },
            saveFetchResult = {
                engineDatabase.withTransaction {

                    standingDao.deleteAllStandings()


                    it.forEach {
                        standingDao.insert(standingCacheMapper.mapToEntityList(it))
                    }

                    it.forEach {
                        it.forEach {
                            Log.d("teamPos", "Team: ${it.team}, Position: ${it.position}")
                        }
                    }


                }
            }
        )
    }


    fun getNews(host: String, key: String): Flow<Resource<List<News>>> {
        return networkBoundResource(
            query = {
                newsCacheMapper.mapFromFlowEntityList(newsDao.getNews())
            },
            fetch = {
                val response = newsService.getNews(host, key)
                newsResponseMapper.fromNetworkEntityList(response.articles)
            },
            saveFetchResult = {
                engineDatabase.withTransaction {
                    newsDao.deleteAlLNews()
                    newsDao.insert(newsCacheMapper.mapToEntityList(it))
                }
            }
        )
    }


    fun getPlayers(host: String, key: String): Flow<Resource<List<Player>>> {
        return networkBoundResource(
            query = {
                playerCacheMapper.mapFromFlowEntityList(playerDao.getPLayers())
            },
            fetch = {
                val response = playerSerice.getPlayers(host, key)
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
                val response = playerSerice.getTeams(host, key)
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
                val response = playerSerice.getSeasons(host, key, playerId)
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

    fun getTeamPLayers(team: String): Flow<List<Player>> {
        return playerCacheMapper.mapFromFlowEntityList(playerDao.getTeamPLayers(team))
    }


}











