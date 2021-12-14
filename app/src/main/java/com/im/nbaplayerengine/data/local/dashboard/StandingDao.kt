package com.im.nbaplayerengine.data.local.dashboard

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StandingDao {

    @Query("SELECT * FROM league_table")
    fun getStandings(): Flow<List<StandingCacheEntity>>

    @Query("SELECT * FROM league_table WHERE conference = :conference")
    fun getEasternConference(conference: String): Flow<List<StandingCacheEntity>>

    @Query("SELECT * FROM league_table WHERE conference = :conference")
    fun getWesternConference(conference: String): Flow<List<StandingCacheEntity>>




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(standing: List<StandingCacheEntity>)

    @Query("DELETE FROM league_table")
    suspend fun deleteAllStandings()

}