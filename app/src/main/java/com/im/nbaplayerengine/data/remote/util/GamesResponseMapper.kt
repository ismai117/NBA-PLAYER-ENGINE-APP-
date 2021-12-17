package com.im.nbaplayerengine.data.remote.util


import com.im.nbaplayerengine.data.remote.games.GamesNetworkEntity
import com.im.nbaplayerengine.model.games.Games

import com.im.nbaplayerengine.model.util.EntityMapper

class GamesResponseMapper : EntityMapper<GamesNetworkEntity.Data.Matches, Games>{

    override fun toDomainModel(entity: GamesNetworkEntity.Data.Matches): Games {
        return Games(
            last_update = entity.last_update,
            match_id = entity.match_id,
            round = entity.round,
            round_info = entity.round_info,
            status = entity.status,
            teamCountryOne = entity.team_1?.teamCountryOne,
            teamCountryTwo = entity.team_2?.teamCountryTwo,
            teamIdOne = entity.team_1?.teamIdOne,
            teamIdTwo = entity.team_2?.teamIdTwo,
            teamNameOne = entity.team_1?.teamNameOne,
            teamNametwo = entity.team_2?.teamNametwo,
            team_1_ot = entity.points?.OT?.team_1_ot,
            team_2_ot = entity.points?.OT?.team_2_ot,
            team_1_q1 = entity.points?.Q1?.team_1_q1,
            team_2_q1 = entity.points?.Q1?.team_2_q1,
            team_1_q2 = entity.points?.Q2?.team_1_q2,
            team_2_q2 = entity.points?.Q2?.team_2_q2,
            team_1_q3 = entity.points?.Q3?.team_1_q3,
            team_2_q3 = entity.points?.Q3?.team_2_q3,
            team_1_q4 = entity.points?.Q4?.team_1_q4,
            team_2_q4 = entity.points?.Q4?.team_2_q4,
            team_1_total = entity.points?.total?.team_1_total,
            team_2_total = entity.points?.total?.team_2_total,
        )
    }

    override fun fromDomainModel(entity: Games): GamesNetworkEntity.Data.Matches {
        TODO("Not yet implemented")
    }

    fun fromNetworkEntityList(networkEntity: List<GamesNetworkEntity.Data.Matches>): List<Games> {
        return networkEntity.map { toDomainModel(it) }
    }

    fun fromNetworkEntityListList(entity: List<GamesNetworkEntity.Data>): List<List<Games>>{
        return entity.map { fromNetworkEntityList(it.matches) }
    }


}