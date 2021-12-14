package com.im.nbaplayerengine.data.remote.teams

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
class TeamNetworkEntity(

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "conference")
    val conference: String,

    @Json(name = "record")
    val record: String,

    @Json(name = "teamLogoUrl")
    val teamLogoUrl: String,

    @Json(name = "dateLastUpdated")
    val dateLastUpdated: String,

    ) {

}