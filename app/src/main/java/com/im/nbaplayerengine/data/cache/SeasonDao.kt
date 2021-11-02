package com.im.nbaplayerengine.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SeasonDao {

    @Query("SELECT * FROM seasons_table")
    fun getSeasons(): Flow<List<SeasonCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(seasonCacheEntity: List<SeasonCacheEntity>)

    @Query("DELETE FROM seasons_table")
    suspend fun deleteAllSeasons()

}