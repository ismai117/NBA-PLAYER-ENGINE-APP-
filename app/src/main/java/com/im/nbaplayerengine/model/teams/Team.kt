package com.im.nbaplayerengine.model.teams

import java.io.Serializable

data class Team(
    val id: Int,
    val conference: String,
    val dateLastUpdated: String,
    val name: String,
    val record: String,
    val teamLogoUrl: String,
) : Serializable