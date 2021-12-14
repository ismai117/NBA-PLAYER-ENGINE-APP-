package com.im.nbaplayerengine.data.local.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "league_table")
data class StandingCacheEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val position: Int?,
    val team: String?,
    val conference: String?,
    val logo: String?,
    val played: Int?,
    val win: Int?,
    val lose: Int?,
    val season: String?,

)