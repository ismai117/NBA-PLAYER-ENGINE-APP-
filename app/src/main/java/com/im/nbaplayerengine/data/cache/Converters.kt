package com.im.nbaplayerengine.data.cache

import androidx.room.TypeConverter


class Converters {


    @TypeConverter
    fun fromPLayerId(playerid: PlayerId): Int{
        return playerid.id
    }

    @TypeConverter
    fun toPLayerId(id: Int): PlayerId{
        return PlayerId(id = id)
    }


}