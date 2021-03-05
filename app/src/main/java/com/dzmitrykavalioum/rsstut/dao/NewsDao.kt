package com.dzmitrykavalioum.rsstut.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dzmitrykavalioum.rsstut.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query ("SELECT * from news_table")
    fun getNews (): Flow<List<News>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(news: News)

    @Query("DELETE FROM news_table")
    suspend fun deleteAll()
}