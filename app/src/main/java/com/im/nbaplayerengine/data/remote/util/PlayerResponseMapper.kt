package com.im.nbaplayerengine.data.remote.util

import com.im.nbaplayerengine.data.remote.players.PlayerNetworkEntity
import com.im.nbaplayerengine.model.players.Player
import com.im.nbaplayerengine.model.util.EntityMapper

class PlayerResponseMapper : EntityMapper<PlayerNetworkEntity, Player> {


    override fun toDomainModel(entity: PlayerNetworkEntity): Player {
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

    override fun fromDomainModel(entity: Player): PlayerNetworkEntity {
        TODO("Not yet implemented")
    }


    fun fromNetworkEntityList(networkEntity: List<PlayerNetworkEntity>): List<Player> {
        return networkEntity.map { toDomainModel(it) }
    }


}