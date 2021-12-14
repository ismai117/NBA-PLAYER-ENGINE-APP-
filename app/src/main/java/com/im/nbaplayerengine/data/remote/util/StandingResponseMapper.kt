package com.im.nbaplayerengine.data.remote.util

import com.im.nbaplayerengine.data.remote.dashboard.StandingNetworkEntity
import com.im.nbaplayerengine.model.standings.Standing
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlin.math.log

class StandingResponseMapper : EntityMapper<StandingNetworkEntity.Standings, Standing> {


    override fun toDomainModel(entity: StandingNetworkEntity.Standings): Standing {
        return Standing(
            played = entity.games?.played,
            win = entity.games?.win?.total,
            lose =  entity.games?.lose?.total,
            conference = entity.group?.name,
            season = entity.league?.season,
            position = entity.position,
            logo = entity.team?.logo,
            team = entity.team?.name,
        )
    }

    override fun fromDomainModel(entity: Standing): StandingNetworkEntity.Standings {
        TODO("Not yet implemented")
    }


    fun fromNetworkEntityList(entity: List<StandingNetworkEntity.Standings>): List<Standing>{
        return entity.map { toDomainModel(it) }
    }


    fun fromNetworkEntityListList(entity: List<List<StandingNetworkEntity.Standings>>): List<List<Standing>>{
        return entity.map { fromNetworkEntityList(it) }
    }


}