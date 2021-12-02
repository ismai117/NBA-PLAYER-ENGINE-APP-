package com.im.nbaplayerengine.data.local.seasons

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "seasons_table")
data class SeasonCacheEntity(

    @PrimaryKey(autoGenerate = true)
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

): Serializable {

    data class PlayerId(
        val id: Int
    )

}



