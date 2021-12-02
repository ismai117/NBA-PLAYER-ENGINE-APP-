package com.im.nbaplayerengine.data.local.util

import com.im.nbaplayerengine.data.local.players.PlayerCacheEntity
import com.im.nbaplayerengine.model.player.Player
import com.im.nbaplayerengine.model.teams.Team
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlayerCacheMapper : EntityMapper<PlayerCacheEntity, Player> {

    override fun toDomainModel(entity: PlayerCacheEntity): Player {
        return Player(
            id = entity.id,
            age = entity.age,
            careerBlocks = entity.careerBlocks,
            careerPercentageFieldGoal = entity.careerPercentageFieldGoal,
            careerPercentageFreethrow = entity.careerPercentageFreethrow,
            careerPercentageThree = entity.careerPercentageThree,
            careerPoints = entity.careerPoints,
            careerRebounds = entity.careerRebounds,
            careerTurnovers = entity.careerTurnovers,
            carrerAssists = entity.carrerAssists,
            dateLastUpdated = entity.dateLastUpdated,
            dateOfBirth = entity.dateOfBirth,
            firstName = entity.firstName,
            headShotUrl = entity.headShotUrl,
            height = entity.height,
            jerseyNumber = entity.jerseyNumber,
            lastName = entity.lastName,
            position = entity.position,
            team = entity.team,
            weight = entity.weight,
        )
    }

    override fun fromDomainModel(cacheEntity: Player): PlayerCacheEntity {
        return PlayerCacheEntity(
            id = cacheEntity.id,
            age = cacheEntity.age,
            careerBlocks = cacheEntity.careerBlocks,
            careerPercentageFieldGoal = cacheEntity.careerPercentageFieldGoal,
            careerPercentageFreethrow = cacheEntity.careerPercentageFreethrow,
            careerPercentageThree = cacheEntity.careerPercentageThree,
            careerPoints = cacheEntity.careerPoints,
            careerRebounds = cacheEntity.careerRebounds,
            careerTurnovers = cacheEntity.careerTurnovers,
            carrerAssists = cacheEntity.carrerAssists,
            dateLastUpdated = cacheEntity.dateLastUpdated,
            dateOfBirth = cacheEntity.dateOfBirth,
            firstName = cacheEntity.firstName,
            headShotUrl = cacheEntity.headShotUrl,
            height = cacheEntity.height,
            jerseyNumber = cacheEntity.jerseyNumber,
            lastName = cacheEntity.lastName,
            position = cacheEntity.position,
            team = cacheEntity.team,
            weight = cacheEntity.weight,
        )
    }

    fun mapFromEntityList(entity: List<PlayerCacheEntity>): List<Player> {
        return entity.map { toDomainModel(it) }
    }

    fun mapToEntityList(entity: List<Player>): List<PlayerCacheEntity> {
        return entity.map { fromDomainModel(it) }
    }

    fun mapFromFlowEntityList(entity: Flow<List<PlayerCacheEntity>>): Flow<List<Player>> {
        return entity.map { mapFromEntityList(it) }
    }

}