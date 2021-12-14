package com.im.nbaplayerengine.data.remote.players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class PlayerNetworkEntity(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "firstName")
    val firstName: String?,

    @Json(name = "lastName")
    val lastName: String?,

    @Json(name = "team")
    val team: String?,

    @Json(name = "position")
    val position: String?,

    @Json(name = "dateOfBirth")
    val dateOfBirth: String?,

    @Json(name = "height")
    val height: String?,

    @Json(name = "weight")
    val weight: String?,

    @Json(name = "jerseyNumber")
    val jerseyNumber: String?,

    @Json(name = "age")
    val age: String?,

    @Json(name = "careerPoints")
    val careerPoints: Double?,

    @Json(name = "careerBlocks")
    val careerBlocks: Double?,

    @Json(name = "carrerAssists")
    val carrerAssists: Double?,

    @Json(name = "careerRebounds")
    val careerRebounds: Double?,

    @Json(name = "careerTurnovers")
    val careerTurnovers: Double?,

    @Json(name = "careerPercentageThree")
    val careerPercentageThree: Double?,

    @Json(name = "careerPercentageFreethrow")
    val careerPercentageFreethrow: Double?,

    @Json(name = "careerPercentageFieldGoal")
    val careerPercentageFieldGoal: Double?,

    @Json(name = "headShotUrl")
    val headShotUrl: String?,

    @Json(name = "dateLastUpdated")
    val dateLastUpdated: String?,

    ) {

}
