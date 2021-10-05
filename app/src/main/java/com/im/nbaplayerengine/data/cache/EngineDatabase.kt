package com.im.nbaplayerengine.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PlayerCacheEntity::class, TeamCacheEntity::class],
    version = 2,
    exportSchema = false
)
abstract class EngineDatabase : RoomDatabase() {


    abstract fun getPlayerDao(): PlayerDao
    abstract fun getTeamDao(): TeamDao

}