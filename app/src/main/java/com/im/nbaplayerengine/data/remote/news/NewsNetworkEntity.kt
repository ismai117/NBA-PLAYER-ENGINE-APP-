package com.im.nbaplayerengine.data.remote.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsNetworkEntity(


    val articles: List<Articles>,

    ) {

    @JsonClass(generateAdapter = true)
    class Articles(

        @Json(name = "_id")
        val _id: String?,

        @Json(name = "_score")
        val _score: Double?,

        @Json(name = "author")
        val author: String?,

//        @Json(name = "authors")
//        val authors: List<String>,

        @Json(name = "clean_url")
        val clean_url: String?,

        @Json(name = "country")
        val country: String?,

        @Json(name = "is_opinion")
        val is_opinion: Boolean?,

        @Json(name = "language")
        val language: String?,

        @Json(name = "link")
        val link: String?,

        @Json(name = "media")
        val media: String?,

        @Json(name = "published_date")
        val published_date: String?,

        @Json(name = "published_date_precision")
        val published_date_precision: String?,

        @Json(name = "rank")
        val rank: Int?,

        @Json(name = "rights")
        val rights: String?,

        @Json(name = "summary")
        val summary: String?,

        @Json(name = "title")
        val title: String?,

        @Json(name = "topic")
        val topic: String?,

        @Json(name = "twitter_account")
        val twitter_account: String?


        )

}

