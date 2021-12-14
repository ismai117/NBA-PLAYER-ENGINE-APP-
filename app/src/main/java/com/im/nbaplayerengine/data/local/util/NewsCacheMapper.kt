package com.im.nbaplayerengine.data.local.util

import com.im.nbaplayerengine.data.local.news.NewsCacheEntity

import com.im.nbaplayerengine.model.news.News
import com.im.nbaplayerengine.model.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsCacheMapper : EntityMapper<NewsCacheEntity, News> {


    override fun toDomainModel(entity: NewsCacheEntity): News {
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

    override fun fromDomainModel(entity: News): NewsCacheEntity {
        return NewsCacheEntity(
            id = 0,
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


    fun mapFromEntityList(entity: List<NewsCacheEntity>): List<News> {
        return entity.map { toDomainModel(it) }
    }

    fun mapToEntityList(entity: List<News>): List<NewsCacheEntity> {
        return entity.map { fromDomainModel(it) }
    }

    fun mapFromFlowEntityList(entity: Flow<List<NewsCacheEntity>>): Flow<List<News>> {
        return entity.map { mapFromEntityList(it) }
    }

}