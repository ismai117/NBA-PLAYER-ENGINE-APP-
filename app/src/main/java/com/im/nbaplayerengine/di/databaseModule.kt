package com.im.nbaplayerengine.di

import android.content.Context
import androidx.room.Room
import com.im.nbaplayerengine.data.cache.EngineDatabase
import com.im.nbaplayerengine.data.cache.PlayerDao
import com.im.nbaplayerengine.data.cache.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object databaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): EngineDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            EngineDatabase::class.java,
            "playerengine_database"
        ).fallbackToDestructiveMigration().build()
    }


    @Provides
    @Singleton
    fun providePlayerDao(engineDatabase: EngineDatabase): PlayerDao{
        return engineDatabase.getPlayerDao()
    }

    @Provides
    @Singleton
    fun provideTeamDao(engineDatabase: EngineDatabase): TeamDao{
        return engineDatabase.getTeamDao()
    }

}