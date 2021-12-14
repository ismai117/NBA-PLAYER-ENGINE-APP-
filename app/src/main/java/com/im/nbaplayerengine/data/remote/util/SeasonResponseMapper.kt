package com.im.nbaplayerengine.data.remote.util

import com.im.nbaplayerengine.data.local.seasons.SeasonCacheEntity
import com.im.nbaplayerengine.data.remote.seasons.SeasonNetworkEntity
import com.im.nbaplayerengine.model.seasons.Season
import com.im.nbaplayerengine.model.util.EntityMapper

class SeasonResponseMapper : EntityMapper<SeasonNetworkEntity, Season> {

    override fun toDomainModel(entity: SeasonNetworkEntity): Season {
        return Season(
            id = entity.id,
            assistsPerGame = entity.assistsPerGame,
            blocksPerGame = entity.blocksPerGame,
            dateLastUpdated = entity.dateLastUpdated,
            gamesPlayed = entity.gamesPlayed,
            gamesStarted = entity.gamesStarted,
            minsPerGame = entity.minsPerGame,
            percentageFieldGoal = entity.percentageFieldGoal,
            percentageFreeThrow = entity.percentageFreeThrow,
            percentageThree = entity.percentageThree,
            playerId = Season.PlayerId(
                id = entity.playerId.id
            ),
            pointsPerGame = entity.pointsPerGame,
            reboundsPerGame = entity.reboundsPerGame,
            season = entity.season,
            team = entity.team,
            turnoversPerGame = entity.turnoversPerGame
        )

    }

    override fun fromDomainModel(entity: Season): SeasonNetworkEntity {
      TODO()
    }

    fun fromNetworkEntityList(networkEntity: List<SeasonNetworkEntity>): List<Season> {
        return networkEntity.map { toDomainModel(it) }
    }

}