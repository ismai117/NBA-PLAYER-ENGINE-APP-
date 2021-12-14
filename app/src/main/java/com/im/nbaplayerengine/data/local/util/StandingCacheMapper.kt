package com.im.nbaplayerengine.data.local.util

import com.im.nbaplayerengine.data.local.dashboard.StandingCacheEntity
import com.im.nbaplayerengine.data.local.news.NewsCacheEntity
import com.im.nbaplayerengine.model.news.News
import com.im.nbaplayerengine.model.standings.Standing
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class StandingCacheMapper : EntityMapper<StandingCacheEntity, Standing> {


    override fun toDomainModel(entity: StandingCacheEntity): Standing {
        return Standing(
            played = entity.played,
            win = entity.win,
            lose = entity.lose,
            conference = entity.conference,
            season = entity.season,
            position = entity.position,
            logo = entity.logo,
            team = entity.team,
        )
    }

    override fun fromDomainModel(entity: Standing): StandingCacheEntity {
        return StandingCacheEntity(
            id = 0,
            played = entity.played,
            win = entity.win,
            lose = entity.lose,
            conference = entity.conference,
            season = entity.season,
            position = entity.position,
            logo = entity.logo,
            team = entity.team,
        )
    }


    fun mapFromEntityList(entity: List<StandingCacheEntity>): List<Standing> {
        return entity.map { toDomainModel(it) }
    }

    fun mapToEntityList(entity: List<Standing>): List<StandingCacheEntity> {
        return entity.map { fromDomainModel(it) }
    }

    fun mapFromFlowEntityList(entity: Flow<List<StandingCacheEntity>>): Flow<List<Standing>> {
        return entity.map { mapFromEntityList(it) }
    }


}