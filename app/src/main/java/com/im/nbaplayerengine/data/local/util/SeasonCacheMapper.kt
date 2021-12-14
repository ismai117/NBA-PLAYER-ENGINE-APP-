package com.im.nbaplayerengine.data.local.util

import com.im.nbaplayerengine.data.local.seasons.SeasonCacheEntity
import com.im.nbaplayerengine.model.seasons.Season
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SeasonCacheMapper : EntityMapper<SeasonCacheEntity, Season> {

    override fun toDomainModel(entity: SeasonCacheEntity): Season {
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

    override fun fromDomainModel(cacheEntity: Season): SeasonCacheEntity {
        return SeasonCacheEntity(
            id = cacheEntity.id,
            assistsPerGame = cacheEntity.assistsPerGame,
            blocksPerGame = cacheEntity.blocksPerGame,
            dateLastUpdated = cacheEntity.dateLastUpdated,
            gamesPlayed = cacheEntity.gamesPlayed,
            gamesStarted = cacheEntity.gamesStarted,
            minsPerGame = cacheEntity.minsPerGame,
            percentageFieldGoal = cacheEntity.percentageFieldGoal,
            percentageFreeThrow = cacheEntity.percentageFreeThrow,
            percentageThree = cacheEntity.percentageThree,
            playerId = SeasonCacheEntity.PlayerId(
                id = cacheEntity.playerId.id
            ),
            pointsPerGame = cacheEntity.pointsPerGame,
            reboundsPerGame = cacheEntity.reboundsPerGame,
            season = cacheEntity.season,
            team = cacheEntity.team,
            turnoversPerGame = cacheEntity.turnoversPerGame
        )
    }

    fun mapFromEntityList(entity: List<SeasonCacheEntity>): List<Season> {
        return entity.map { toDomainModel(it) }
    }

    fun mapToEntityList(entity: List<Season>): List<SeasonCacheEntity> {
        return entity.map { fromDomainModel(it) }
    }

    fun mapFromFlowEntityList(entity: Flow<List<SeasonCacheEntity>>): Flow<List<Season>> {
        return entity.map { mapFromEntityList(it) }
    }

}