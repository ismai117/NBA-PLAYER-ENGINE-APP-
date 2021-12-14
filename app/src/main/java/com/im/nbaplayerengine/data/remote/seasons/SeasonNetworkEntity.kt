package com.im.nbaplayerengine.data.remote.seasons

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class SeasonNetworkEntity(

    @Json(name = "id")
    val id: Int,

    @Json(name = "playerId")
    val playerId: PlayerId,

    @Json(name = "season")
    val season: String,

    @Json(name = "team")
    val team: String,

    @Json(name = "gamesPlayed")
    val gamesPlayed: String,

    @Json(name = "gamesStarted")
    val gamesStarted: String,

    @Json(name = "pointsPerGame")
    val pointsPerGame: String,

    @Json(name = "blocksPerGame")
    val blocksPerGame: String,

    @Json(name = "assistsPerGame")
    val assistsPerGame: String,

    @Json(name = "reboundsPerGame")
    val reboundsPerGame: String,

    @Json(name = "turnoversPerGame")
    val turnoversPerGame: String,

    @Json(name = "percentageThree")
    val percentageThree: String,

    @Json(name = "percentageFieldGoal")
    val percentageFieldGoal: String,

    @Json(name = "percentageFreeThrow")
    val percentageFreeThrow: String,

    @Json(name = "minsPerGame")
    val minsPerGame: String,

    @Json(name = "dateLastUpdated")
    val dateLastUpdated: String,

    ) {

    @JsonClass(generateAdapter = true)
    data class PlayerId(

        @Json(name = "id")
        val id: Int,

        )

}