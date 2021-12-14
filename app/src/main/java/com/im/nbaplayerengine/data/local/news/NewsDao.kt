package com.im.nbaplayerengine.data.local.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM article_table")
    fun getNews(): Flow<List<NewsCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: List<NewsCacheEntity>)

    @Query("DELETE FROM article_table")
    suspend fun deleteAlLNews()

}