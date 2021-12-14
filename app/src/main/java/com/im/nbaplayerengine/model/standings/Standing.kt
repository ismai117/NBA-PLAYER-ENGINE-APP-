package com.im.nbaplayerengine.model.standings

import com.im.nbaplayerengine.data.remote.dashboard.StandingNetworkEntity

data class Standing(

    val position: Int?,
    val team: String?,
    val conference: String?,
    val logo: String?,
    val played: Int?,
    val win: Int?,
    val lose: Int?,
    val season: String?,

    )

