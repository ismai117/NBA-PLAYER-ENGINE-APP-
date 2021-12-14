package com.im.nbaplayerengine.model.news

import com.squareup.moshi.Json
import java.io.Serializable

data class News(


    val _id: String?,
    val _score: Double?,
    val author: String?,
//        val authors: List<String>,
    val clean_url: String?,
    val country: String?,
    val is_opinion: Boolean?,
    val language: String?,
    val link: String?,
    val media: String?,
    val published_date: String?,
    val published_date_precision: String?,
    val rank: Int?,
    val rights: String?,
    val summary: String?,
    val title: String?,
    val topic: String?,
    val twitter_account: String?

): Serializable
