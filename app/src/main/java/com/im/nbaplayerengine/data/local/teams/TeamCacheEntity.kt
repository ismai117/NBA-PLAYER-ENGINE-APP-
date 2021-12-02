package com.im.nbaplayerengine.data.local.teams

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "teams_table")
data class TeamCacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val conference: String,
    val dateLastUpdated: String,
    val name: String,
    val record: String,
    val teamLogoUrl: String
): Serializable