package com.dzmitrykavalioum.rsstut

import android.util.Log
import com.dzmitrykavalioum.rsstut.api.RetrofitInstance
import com.dzmitrykavalioum.rsstut.model.Feed
import com.dzmitrykavalioum.rsstut.model.Feed1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : MainContract.PresenterContract {

    private val TAG = "MainPresenter"
    private var view: MainContract.ViewContract? = null
    private var feed: Feed1? = null

    constructor(view: MainContract.ViewContract?) {
        this.view = view
    }

    override fun onViewCreated() {
        val call: Call<Feed1> = RetrofitInstance.api.getNews()
        call.enqueue(object : Callback<Feed1> {
            override fun onFailure(call: Call<Feed1>, t: Throwable) {
                //TODO do correct messages
                view?.showError(t.message.toString())
//                    Log.d(TAG,t.message.toString())
            }

            override fun onResponse(call: Call<Feed1>, response: Response<Feed1>) {
                feed = response.body()
                feed?.let { view?.showNews(it) }
                Log.d(TAG, response.toString())
                //Log.d(TAG, feed!!.channelTitle)

            }

        }

        )
    }

    override fun updateListNews() {
        Log.d(TAG, "update news")
        onViewCreated()
    }



}