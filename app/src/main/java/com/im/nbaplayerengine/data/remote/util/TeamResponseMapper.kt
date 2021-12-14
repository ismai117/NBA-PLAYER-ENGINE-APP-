package com.im.nbaplayerengine.data.remote.util

import com.im.nbaplayerengine.data.local.teams.TeamCacheEntity
import com.im.nbaplayerengine.data.remote.teams.TeamNetworkEntity
import com.im.nbaplayerengine.model.teams.Team
import com.im.nbaplayerengine.model.util.EntityMapper

class TeamResponseMapper : EntityMapper<TeamNetworkEntity, Team> {

    override fun toDomainModel(entity: TeamNetworkEntity): Team {
        return Team(
            id = entity.id,
            conference = entity.conference,
            dateLastUpdated = entity.dateLastUpdated,
            name = entity.name,
            record = entity.record,
            teamLogoUrl = entity.teamLogoUrl
        )
    }

    override fun fromDomainModel(entity: Team): TeamNetworkEntity {
        TODO("Not yet implemented")
    }

    fun fromNetworkEntityList (networkEntity: List<TeamNetworkEntity>): List<Team>{
        return networkEntity.map { toDomainModel(it) }
    }

}