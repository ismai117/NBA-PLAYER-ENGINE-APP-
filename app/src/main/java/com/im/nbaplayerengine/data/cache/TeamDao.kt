package com.im.nbaplayerengine.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TeamDao {

    @Query("SELECT * FROM teams_table")
    fun getTeams(): Flow<List<TeamCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teamCacheEntity: List<TeamCacheEntity>)

    @Query("Delete FROM teams_table")
    suspend fun deleteAllTeams()
}

