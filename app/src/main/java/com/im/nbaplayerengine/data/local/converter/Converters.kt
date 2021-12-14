package com.im.nbaplayerengine.data.local.converter

import androidx.room.TypeConverter
import com.im.nbaplayerengine.data.local.dashboard.StandingCacheEntity

import com.im.nbaplayerengine.data.local.seasons.SeasonCacheEntity

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class Converters {

    val moshi: Moshi = Moshi.Builder().build()


    @TypeConverter
    fun fromPLayerId(playerid: SeasonCacheEntity.PlayerId): Int {
        return playerid.id
    }

    @TypeConverter
    fun toPLayerId(id: Int): SeasonCacheEntity.PlayerId {
        return SeasonCacheEntity.PlayerId(id = id)
    }

    @TypeConverter
    fun fromResponse(country: List<StandingCacheEntity>): String {
        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
        val adapter = moshi.adapter<List<StandingCacheEntity>>(type)
        return adapter.toJson(country)
    }

    @TypeConverter
    fun fromResponse(value: String): List<StandingCacheEntity>?{
        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
        val adapter = moshi.adapter<List<StandingCacheEntity>>(type)
        return adapter.fromJson(value)
    }

//
//    @TypeConverter
//    fun fromCountry(country: List<StandingCacheEntity.Country>): String {
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Country>>(type)
//        return adapter.toJson(country)
//    }
//
//    @TypeConverter
//    fun fromCountry(value: String): List<StandingCacheEntity.Country>?{
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Country>>(type)
//        return adapter.fromJson(value)
//    }
//
//    @TypeConverter
//    fun fromGames(country: List<StandingCacheEntity.Games>): String {
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Games>>(type)
//        return adapter.toJson(country)
//    }
//
//    @TypeConverter
//    fun fromGames(value: String): List<StandingCacheEntity.Games>?{
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Games>>(type)
//        return adapter.fromJson(value)
//    }
//
//
//    @TypeConverter
//    fun fromGroup(country: List<StandingCacheEntity.Group>): String {
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Group>>(type)
//        return adapter.toJson(country)
//    }
//
//    @TypeConverter
//    fun fromGroup(value: String): List<StandingCacheEntity.Group>?{
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Group>>(type)
//        return adapter.fromJson(value)
//    }
//
//    @TypeConverter
//    fun fromLeague(country: List<StandingCacheEntity.League>): String {
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.League>>(type)
//        return adapter.toJson(country)
//    }
//
//    @TypeConverter
//    fun fromLeague(value: String): List<StandingCacheEntity.League>?{
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.League>>(type)
//        return adapter.fromJson(value)
//    }
//
//    @TypeConverter
//    fun fromPoints(country: List<StandingCacheEntity.Points>): String {
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Points>>(type)
//        return adapter.toJson(country)
//    }
//
//    @TypeConverter
//    fun fromPoints(value: String): List<StandingCacheEntity.Points>?{
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Points>>(type)
//        return adapter.fromJson(value)
//    }
//
//    @TypeConverter
//    fun fromTeam(country: List<StandingCacheEntity.Team>): String {
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Team>>(type)
//        return adapter.toJson(country)
//    }
//
//    @TypeConverter
//    fun fromTeam(value: String): List<StandingCacheEntity.Team>?{
//        val type = Types.newParameterizedType(List::class.java, StandingCacheEntity::class.java)
//        val adapter = moshi.adapter<List<StandingCacheEntity.Team>>(type)
//        return adapter.fromJson(value)
//    }

}