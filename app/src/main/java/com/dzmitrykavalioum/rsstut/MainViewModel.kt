package com.dzmitrykavalioum.rsstut

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.dzmitrykavalioum.rsstut.db.NewsRepository
import com.dzmitrykavalioum.rsstut.model.News
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val repository: NewsRepository) : ViewModel() {


    val allNews: Flow<List<News>> = repository.allNews

    fun insert (news: News) =  {  }

}