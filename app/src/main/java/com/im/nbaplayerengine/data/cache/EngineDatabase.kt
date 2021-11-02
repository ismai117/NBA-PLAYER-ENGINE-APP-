package com.im.nbaplayerengine.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [PlayerCacheEntity::class, TeamCacheEntity::class, SeasonCacheEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class EngineDatabase : RoomDatabase() {


    abstract fun getPlayerDao(): PlayerDao
    abstract fun getTeamDao(): TeamDao
    abstract fun getSeasonDao(): SeasonDao

}