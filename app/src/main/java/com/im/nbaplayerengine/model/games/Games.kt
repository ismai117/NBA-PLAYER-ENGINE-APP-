package com.im.nbaplayerengine.model.games

import com.im.nbaplayerengine.data.remote.games.GamesNetworkEntity

data class Games(


    val last_update: Long?,
    val match_id: String?,
    val round: Int?,
    val round_info: String?,
    val status: String?,
    val teamCountryOne: String?,
    val teamCountryTwo: String?,
    val teamIdOne: String?,
    val teamIdTwo: String?,
    val teamNameOne: String?,
    val teamNametwo: String?,
    val team_1_ot: Int?,
    val team_2_ot: Int?,
    val team_1_q1: Int?,
    val team_2_q1: Int?,
    val team_1_q2: Int?,
    val team_2_q2: Int?,
    val team_1_q3: Int?,
    val team_2_q3: Int?,
    val team_1_q4: Int?,
    val team_2_q4: Int?,
    val team_1_total: Int?,
    val team_2_total: Int?,


    )