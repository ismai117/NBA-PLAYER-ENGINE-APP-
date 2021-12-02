package com.im.nbaplayerengine.data.remote.seasons

import java.io.Serializable

class SeasonNetworkEntity(
    val id: Int,
    val assistsPerGame: String,
    val blocksPerGame: String,
    val dateLastUpdated: String,
    val gamesPlayed: String,
    val gamesStarted: String,
    val minsPerGame: String,
    val percentageFieldGoal: String,
    val percentageFreeThrow: String,
    val percentageThree: String,
    val playerId: PlayerId,
    val pointsPerGame: String,
    val reboundsPerGame: String,
    val season: String,
    val team: String,
    val turnoversPerGame: String
) : Serializable {

    data class PlayerId(
        val id: Int
    )

}