package com.im.nbaplayerengine.data.local.converter

import androidx.room.TypeConverter
import com.im.nbaplayerengine.data.local.seasons.SeasonCacheEntity


class Converters {


    @TypeConverter
    fun fromPLayerId(playerid: SeasonCacheEntity.PlayerId): Int{
        return playerid.id
    }

    @TypeConverter
    fun toPLayerId(id: Int): SeasonCacheEntity.PlayerId {
        return SeasonCacheEntity.PlayerId(id = id)
    }


}