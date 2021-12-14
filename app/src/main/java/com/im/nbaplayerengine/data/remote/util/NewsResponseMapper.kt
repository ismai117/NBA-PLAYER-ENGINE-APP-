package com.im.nbaplayerengine.data.remote.util

import com.im.nbaplayerengine.data.remote.news.NewsNetworkEntity
import com.im.nbaplayerengine.model.news.News
import com.im.nbaplayerengine.model.util.EntityMapper

class NewsResponseMapper : EntityMapper<NewsNetworkEntity.Articles, News> {

    override fun toDomainModel(entity: NewsNetworkEntity.Articles): News {
        return News(
            _id = entity._id,
            _score = entity._score,
            author = entity.author,
            clean_url = entity.clean_url,
            country = entity.country,
            language = entity.language,
            link = entity.link,
            media = entity.media,
            published_date = entity.published_date,
            rank = entity.rank,
            rights = entity.rights,
            summary = entity.summary,
            title = entity.title,
            topic = entity.topic,
            twitter_account = entity.twitter_account,
            published_date_precision = entity.published_date_precision,
            is_opinion = entity.is_opinion
        )

    }

    override fun fromDomainModel(entity: News): NewsNetworkEntity.Articles {
        TODO("Not yet implemented")
    }


    fun fromNetworkEntityList(networkEntity: List<NewsNetworkEntity.Articles>): List<News> {
        return networkEntity.map { toDomainModel(it) }
    }


}