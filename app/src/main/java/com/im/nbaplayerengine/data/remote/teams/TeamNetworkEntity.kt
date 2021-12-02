package com.im.nbaplayerengine.data.remote.teams

import java.io.Serializable

class TeamNetworkEntity(
    val id: Int,
    val conference: String,
    val dateLastUpdated: String,
    val name: String,
    val record: String,
    val teamLogoUrl: String
) : Serializable