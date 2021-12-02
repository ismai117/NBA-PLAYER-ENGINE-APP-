package com.im.nbaplayerengine.di

import android.content.Context
import androidx.room.Room
import com.im.nbaplayerengine.data.local.database.EngineDatabase
import com.im.nbaplayerengine.data.local.players.PlayerDao
import com.im.nbaplayerengine.data.local.seasons.SeasonDao
import com.im.nbaplayerengine.data.local.teams.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): EngineDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            EngineDatabase::class.java,
            "playerengine_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePlayerDao(engineDatabase: EngineDatabase): PlayerDao {
        return engineDatabase.getPlayerDao()
    }

    @Singleton
    @Provides
    fun provideTeamDao(engineDatabase: EngineDatabase): TeamDao {
        return engineDatabase.getTeamDao()
    }

    @Singleton
    @Provides
    fun provideSeasonDao(engineDatabase: EngineDatabase): SeasonDao {
        return engineDatabase.getSeasonDao()
    }

}