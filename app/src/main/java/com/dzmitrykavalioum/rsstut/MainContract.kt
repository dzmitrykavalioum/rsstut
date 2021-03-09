package com.dzmitrykavalioum.rsstut

import com.dzmitrykavalioum.rsstut.model.Feed
import com.dzmitrykavalioum.rsstut.model.Feed1

interface MainContract {
    interface PresenterContract{
        fun onViewCreated()
        fun updateListNews()
    }

    interface ViewContract{
        fun showNews(feed: Feed1)
        fun showError(messge: String)
    }
}