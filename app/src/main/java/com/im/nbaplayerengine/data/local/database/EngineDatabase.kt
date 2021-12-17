package com.im.nbaplayerengine.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.im.nbaplayerengine.data.local.converter.Converters
import com.im.nbaplayerengine.data.local.dashboard.StandingCacheEntity
import com.im.nbaplayerengine.data.local.dashboard.StandingDao
import com.im.nbaplayerengine.data.local.games.GamesCacheEntity
import com.im.nbaplayerengine.data.local.games.GamesDao
import com.im.nbaplayerengine.data.local.news.NewsCacheEntity
import com.im.nbaplayerengine.data.local.news.NewsDao
import com.im.nbaplayerengine.data.local.players.PlayerCacheEntity
import com.im.nbaplayerengine.data.local.players.PlayerDao
import com.im.nbaplayerengine.data.local.seasons.SeasonCacheEntity
import com.im.nbaplayerengine.data.local.seasons.SeasonDao
import com.im.nbaplayerengine.data.local.teams.TeamCacheEntity
import com.im.nbaplayerengine.data.local.teams.TeamDao

@Database(
    entities = [PlayerCacheEntity::class, TeamCacheEntity::class, SeasonCacheEntity::class, NewsCacheEntity::class, StandingCacheEntity::class, GamesCacheEntity::class],
    version = 39,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class EngineDatabase : RoomDatabase() {


    abstract fun getPlayerDao(): PlayerDao
    abstract fun getTeamDao(): TeamDao
    abstract fun getSeasonDao(): SeasonDao
    abstract fun getNewsDao(): NewsDao
    abstract fun getStanding(): StandingDao
    abstract fun getGames(): GamesDao


}