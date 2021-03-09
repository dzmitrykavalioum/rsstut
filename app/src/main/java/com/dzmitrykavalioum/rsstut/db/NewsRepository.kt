package com.dzmitrykavalioum.rsstut.db

import androidx.annotation.WorkerThread
import com.dzmitrykavalioum.rsstut.model.News
import kotlinx.coroutines.flow.Flow


class NewsRepository  (private val newsDao: NewsDao){

    val allNews: Flow<List<News>> = newsDao.getNews()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert (news: News){
        newsDao.insert(news)
    }
}