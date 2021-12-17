package com.im.nbaplayerengine.data.remote.games

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesNetworkEntity(

    val data: List<Data>

    ) {

    @JsonClass(generateAdapter = true)
    class Data(

        val matches: List<Matches>

    ) {


    @JsonClass(generateAdapter = true)
    class Matches(

        @Json(name = "last_update")
        val last_update: Long?,

        @Json(name = "match_id")
        val match_id: String?,

        @Json(name = "points")
        val points: Points?,

        @Json(name =  "round")
        val round: Int?,

        @Json(name = "round_info")
        val round_info: String?,

        @Json(name = "status")
        val status: String?,

        @Json(name = "team_1")
        val team_1: Team1?,

        @Json(name = "team_2")
        val team_2: Team2?,

        @Json(name = "time")
        val time: Time?,

        )

    @JsonClass(generateAdapter = true)
    class Time(

        @Json(name = "finish")
        val finish: Any?,

        @Json(name = "scheduled")
        val scheduled: Long?,

        @Json(name = "start")
        val start: Any?,

        @Json(name = "timezone")
        val timezone: String?,

        )

    @JsonClass(generateAdapter = true)
    class Team1(

        @Json(name = "country")
        val teamCountryOne: String?,

        @Json(name = "id")
        val teamIdOne: String?,

        @Json(name = "name")
        val teamNameOne: String?,

        )

    @JsonClass(generateAdapter = true)
    class Team2(

        @Json(name = "country")
        val teamCountryTwo: String?,

        @Json(name = "id")
        val teamIdTwo: String?,

        @Json(name = "name")
        val teamNametwo: String?,

        )

    @JsonClass(generateAdapter = true)
    class Points(

        @Json(name = "OT")
        val OT: OT?,

        @Json(name = "Q1")
        val Q1: Q1?,

        @Json(name = "Q2")
        val Q2: Q2?,

        @Json(name = "Q3")
        val Q3: Q3?,

        @Json(name = "Q4")
        val Q4: Q4?,

        @Json(name = "total")
        val total: Total?,

        )

    @JsonClass(generateAdapter = true)
    class OT(

        @Json(name = "team_1")
        val team_1_ot: Int?,

        @Json(name = "team_2")
        val team_2_ot: Int?,

    )

    @JsonClass(generateAdapter = true)
    class Q1(

        @Json(name = "team_1")
        val team_1_q1: Int?,

        @Json(name = "team_2")
        val team_2_q1: Int?,

    )

    @JsonClass(generateAdapter = true)
    class Q2(

        @Json(name = "team_1")
        val team_1_q2: Int?,

        @Json(name = "team_2")
        val team_2_q2: Int?,

    )

    @JsonClass(generateAdapter = true)
    class Q3(

        @Json(name = "team_1")
        val team_1_q3: Int?,

        @Json(name = "team_2")
        val team_2_q3: Int?,

    )

    @JsonClass(generateAdapter = true)
    class Q4(

        @Json(name = "team_1")
        val team_1_q4: Int?,

        @Json(name = "team_2")
        val team_2_q4: Int?,

    )

    @JsonClass(generateAdapter = true)
    class Total(

        @Json(name = "team_1")
        val team_1_total: Int?,

        @Json(name = "team_2")
        val team_2_total: Int?,

    )


    }



}