package com.im.nbaplayerengine.data.local.news

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Entity(tableName = "article_table")
data class NewsCacheEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
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


)
