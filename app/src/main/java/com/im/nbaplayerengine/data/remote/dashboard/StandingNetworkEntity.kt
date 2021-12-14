package com.im.nbaplayerengine.data.remote.dashboard

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandingNetworkEntity(

    val response: List<List<Standings>>,

    ) {


    @JsonClass(generateAdapter = true)
    class Standings(

        @Json(name = "country")
        val country: Country?,

        @Json(name = "description")
        val description: String?,

        @Json(name = "form")
        val form: String?,

        @Json(name = "games")
        val games: Games?,

        @Json(name = "group")
        val group: Group?,

        @Json(name = "league")
        val league: League?,

        @Json(name = "points")
        val points: Points?,

        @Json(name = "position")
        val position: Int?,

        @Json(name = "stage")
        val stage: String?,

        @Json(name = "team")
        val team: Team?,


    )


    @JsonClass(generateAdapter = true)
     class Team(

        @Json(name = "id")
        val id: Int?,

        @Json(name = "name")
        val logo: String?,

        @Json(name = "logo")
        val name: String?,

        )

    @JsonClass(generateAdapter = true)
    class League(

        @Json(name = "id")
        val id: Int?,

        @Json(name = "logo")
        val logo: String?,

        @Json(name = "name")
        val name: String?,

        @Json(name = "season")
        val season: String?,

        @Json(name = "type")
        val type: String?,

        )

    @JsonClass(generateAdapter = true)
    class Country(

        @Json(name = "code")
        val code: String?,

        @Json(name = "flag")
        val flag: String?,

        @Json(name = "id")
        val id: Int?,

        @Json(name = "name")
        val name: String?,

        )

    @JsonClass(generateAdapter = true)
     class Games(

        @Json(name = "lose")
        val lose: Lose?,

        @Json(name = "played")
        val played: Int?,

        @Json(name = "win")
        val win: Win?,

        )

    @JsonClass(generateAdapter = true)
     class Group(

        @Json(name = "name")
        val name: String?,

        @Json(name = "points")
        val points: String?,

        )

    @JsonClass(generateAdapter = true)
     class Win(

        @Json(name = "percentage")
        val percentage: String?,

        @Json(name = "total")
        val total: Int?,

        )

    @JsonClass(generateAdapter = true)
    class Lose(

        @Json(name = "percentage")
        val percentage: String?,

        @Json(name = "total")
        val total: Int?,

        )

    @JsonClass(generateAdapter = true)
     class Points(

        @Json(name = "against")
        val against: Int?,

        @Json(name = "fort")
        val `for`: Int?,
    )


}