package com.im.nbaplayerengine.data.local.games

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {


    @Query("SELECT * FROM games_table")
    fun getGames(): Flow<List<GamesCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gamesCacheEntity: List<GamesCacheEntity>)

    @Query("DELETE FROM games_table")
    fun deleteAllGames()


}