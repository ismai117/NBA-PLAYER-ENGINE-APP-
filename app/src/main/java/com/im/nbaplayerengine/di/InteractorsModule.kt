package com.im.nbaplayerengine.di

import com.im.nbaplayerengine.data.local.players.PlayerCacheEntity
import com.im.nbaplayerengine.data.local.util.PlayerCacheMapper
import com.im.nbaplayerengine.data.local.util.SeasonCacheMapper
import com.im.nbaplayerengine.data.local.util.TeamCacheMapper
import com.im.nbaplayerengine.data.remote.util.PlayerResponseMapper
import com.im.nbaplayerengine.data.remote.util.SeasonResponseMapper
import com.im.nbaplayerengine.data.remote.util.TeamResponseMapper
import com.im.nbaplayerengine.model.player.Player
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {


    @Singleton
    @Provides
    fun providePlayerResponseMapper(): PlayerResponseMapper {
        return PlayerResponseMapper()
    }

    @Singleton
    @Provides
    fun provideTeamResponseMapper(): TeamResponseMapper {
        return TeamResponseMapper()
    }

    @Singleton
    @Provides
    fun provideSeasonResponseMapper(): SeasonResponseMapper{
        return SeasonResponseMapper()
    }

    @Singleton
    @Provides
    fun providePlayerCacheMapper(): PlayerCacheMapper{
        return PlayerCacheMapper()
    }

    @Singleton
    @Provides
    fun provideTeamCacheMapper(): TeamCacheMapper {
        return TeamCacheMapper()
    }

    @Singleton
    @Provides
    fun provideSeasonCacheMapper(): SeasonCacheMapper {
        return SeasonCacheMapper()
    }


}