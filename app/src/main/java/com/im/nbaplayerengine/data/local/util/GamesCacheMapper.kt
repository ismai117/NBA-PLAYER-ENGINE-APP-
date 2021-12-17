package com.im.nbaplayerengine.data.local.util

import com.im.nbaplayerengine.data.local.dashboard.StandingCacheEntity
import com.im.nbaplayerengine.data.local.games.GamesCacheEntity
import com.im.nbaplayerengine.data.remote.games.GamesNetworkEntity
import com.im.nbaplayerengine.model.games.Games
import com.im.nbaplayerengine.model.standings.Standing
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesCacheMapper : EntityMapper<GamesCacheEntity, Games> {

    override fun toDomainModel(entity: GamesCacheEntity): Games {
        return Games(
            last_update = entity.last_update,
            match_id = entity.match_id,
            round = entity.round,
            round_info = entity.round_info,
            status = entity.status,
            teamCountryOne = entity.teamCountryOne,
            teamCountryTwo = entity.teamCountryTwo,
            teamIdOne = entity.teamIdOne,
            teamIdTwo = entity.teamIdTwo,
            teamNameOne = entity.teamNameOne,
            teamNametwo = entity.teamNametwo,
            team_1_ot = entity.team_1_ot,
            team_2_ot = entity.team_2_ot,
            team_1_q1 = entity.team_1_q1,
            team_2_q1 = entity.team_2_q1,
            team_1_q2 = entity.team_1_q2,
            team_2_q2 = entity.team_2_q2,
            team_1_q3 = entity.team_1_q3,
            team_2_q3 = entity.team_2_q3,
            team_1_q4 = entity.team_1_q4,
            team_2_q4 = entity.team_2_q4,
            team_1_total = entity.team_1_total,
            team_2_total = entity.team_2_total,
        )
    }

    override fun fromDomainModel(entity: Games): GamesCacheEntity {
        return GamesCacheEntity(
            id = 0,
            last_update = entity.last_update,
            match_id = entity.match_id,
            round = entity.round,
            round_info = entity.round_info,
            status = entity.status,
            teamCountryOne = entity.teamCountryOne,
            teamCountryTwo = entity.teamCountryTwo,
            teamIdOne = entity.teamIdOne,
            teamIdTwo = entity.teamIdTwo,
            teamNameOne = entity.teamNameOne,
            teamNametwo = entity.teamNametwo,
            team_1_ot = entity.team_1_ot,
            team_2_ot = entity.team_2_ot,
            team_1_q1 = entity.team_1_q1,
            team_2_q1 = entity.team_2_q1,
            team_1_q2 = entity.team_1_q2,
            team_2_q2 = entity.team_2_q2,
            team_1_q3 = entity.team_1_q3,
            team_2_q3 = entity.team_2_q3,
            team_1_q4 = entity.team_1_q4,
            team_2_q4 = entity.team_2_q4,
            team_1_total = entity.team_1_total,
            team_2_total = entity.team_2_total,
        )
    }

    fun fromNetworkEntityList(networkEntity: List<GamesCacheEntity>): List<Games> {
        return networkEntity.map { toDomainModel(it) }
    }

    fun mapToEntityList(entity: List<Games>): List<GamesCacheEntity> {
        return entity.map { fromDomainModel(it) }
    }


    fun fromNetworkEntityFlowList(networkEntity: Flow<List<GamesCacheEntity>>): Flow<List<Games>> {
        return networkEntity.map { fromNetworkEntityList(it) }
    }

}