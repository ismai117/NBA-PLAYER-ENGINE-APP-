package com.im.nbaplayerengine.di


import com.im.nbaplayerengine.data.remote.service.GamesService
import com.im.nbaplayerengine.data.remote.service.NewsService
import com.im.nbaplayerengine.data.remote.service.PlayerService
import com.im.nbaplayerengine.data.remote.service.StandingService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder().build()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("player")
    fun provideRetrofitClientOne(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://nba-player-individual-stats.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun providePlayerService(@Named("player") retrofit: Retrofit): PlayerService {
        return retrofit.create(PlayerService::class.java)
    }

    @Singleton
    @Provides
    @Named("news")
    fun provideRetrofitClientTwo(
        client: OkHttpClient,
        moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://free-news.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }


    @Singleton
    @Provides
    fun provideNewsService(@Named("news") retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }


    @Singleton
    @Provides
    @Named("standing")
    fun provideStanding(
        moshi: Moshi,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api-basketball.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideStandingService(@Named("standing") retrofit: Retrofit): StandingService {
        return retrofit.create(StandingService::class.java)
    }


    @Singleton
    @Provides
    @Named("games")
    fun provideGames(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://livescore-basketball.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideGamesService(@Named("games") retrofit: Retrofit): GamesService {
        return retrofit.create(GamesService::class.java)
    }






























}