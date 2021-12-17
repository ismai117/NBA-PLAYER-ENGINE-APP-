package com.im.nbaplayerengine.di


import com.im.nbaplayerengine.data.local.util.*
import com.im.nbaplayerengine.data.remote.util.*

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
    fun provideSeasonResponseMapper(): SeasonResponseMapper {
        return SeasonResponseMapper()
    }


    @Singleton
    @Provides
    fun provideNewsResponseMapper(): NewsResponseMapper {
        return NewsResponseMapper()
    }

    @Singleton
    @Provides
    fun provideStandingResponseMapper(): StandingResponseMapper {
        return StandingResponseMapper()
    }

    @Singleton
    @Provides
    fun provideGamesResponseMapper(): GamesResponseMapper {
        return GamesResponseMapper()
    }

    @Singleton
    @Provides
    fun providePlayerCacheMapper(): PlayerCacheMapper {
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

    @Singleton
    @Provides
    fun provideNewsCacheMapper(): NewsCacheMapper {
        return NewsCacheMapper()
    }

    @Singleton
    @Provides
    fun provideStandingCacheMapper(): StandingCacheMapper{
        return StandingCacheMapper()
    }

    @Singleton
    @Provides
    fun provideGamesCacheMapper(): GamesCacheMapper{
        return GamesCacheMapper()
    }



}