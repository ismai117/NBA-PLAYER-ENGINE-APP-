package com.im.nbaplayerengine.data.local.util

import com.im.nbaplayerengine.data.local.teams.TeamCacheEntity
import com.im.nbaplayerengine.model.teams.Team
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamCacheMapper : EntityMapper<TeamCacheEntity, Team> {

    override fun toDomainModel(entity: TeamCacheEntity): Team {
        return Team(
            id = entity.id,
            conference = entity.conference,
            dateLastUpdated = entity.dateLastUpdated,
            name = entity.name,
            record = entity.record,
            teamLogoUrl = entity.teamLogoUrl
        )
    }

    override fun fromDomainModel(cacheEntity: Team): TeamCacheEntity {
        return TeamCacheEntity(
            id = cacheEntity.id,
            conference = cacheEntity.conference,
            dateLastUpdated = cacheEntity.dateLastUpdated,
            name = cacheEntity.name,
            record = cacheEntity.record,
            teamLogoUrl = cacheEntity.teamLogoUrl
        )
    }

    fun mapFromEntityList(entity: List<TeamCacheEntity>): List<Team> {
        return entity.map { toDomainModel(it) }
    }

    fun mapToEntityList(entity: List<Team>): List<TeamCacheEntity> {
        return entity.map { fromDomainModel(it) }
    }

    fun mapFromFlowEntityList(entity: Flow<List<TeamCacheEntity>>): Flow<List<Team>> {
        return entity.map { mapFromEntityList(it) }
    }

}