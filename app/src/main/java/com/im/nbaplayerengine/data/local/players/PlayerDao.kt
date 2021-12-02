package com.im.nbaplayerengine.data.local.players

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM players_table")
    fun getPLayers(): Flow<List<PlayerCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playerCacheEntity: List<PlayerCacheEntity>)

    @Query("DELETE FROM players_table")
    suspend fun deleteAllPlayers()

    @Query("SELECT * FROM players_table WHERE firstName LIKE :searchQuery OR lastName LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<PlayerCacheEntity>>

}