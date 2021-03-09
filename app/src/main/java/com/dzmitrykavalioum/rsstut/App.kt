package com.dzmitrykavalioum.rsstut

import android.app.Application
import com.dzmitrykavalioum.rsstut.db.NewsRepository
import com.dzmitrykavalioum.rsstut.db.NewsRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class App:Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {  NewsRoomDatabase.getDatabase(this   ,applicationScope) }
    val repository by lazy {NewsRepository(database.newsDao())}
}