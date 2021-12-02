package com.im.nbaplayerengine.data.local.players

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "players_table")
data class PlayerCacheEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val age: String?,
    val careerBlocks: Double?,
    val careerPercentageFieldGoal: Double?,
    val careerPercentageFreethrow: Double?,
    val careerPercentageThree: Double?,
    val careerPoints: Double?,
    val careerRebounds: Double?,
    val careerTurnovers: Double?,
    val carrerAssists: Double?,
    val dateLastUpdated: String?,
    val dateOfBirth: String?,
    val firstName: String?,
    val headShotUrl: String?,
    val height: String?,
    val jerseyNumber: String?,
    val lastName: String?,
    val position: String?,
    val team: String?,
    val weight: String?

): Serializable