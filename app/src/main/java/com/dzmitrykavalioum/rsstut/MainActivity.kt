package com.dzmitrykavalioum.rsstut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.withStyledAttributes
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzmitrykavalioum.rsstut.adapter.NewsAdapter
import com.dzmitrykavalioum.rsstut.model.Article1
import com.dzmitrykavalioum.rsstut.model.Feed1
import com.dzmitrykavalioum.rsstut.ui.itemarticle.ArticleActivity
import kotlinx.android.synthetic.main.activity_main.*

//https://news.tut.by/rss.html
class MainActivity : AppCompatActivity(), View.OnClickListener, MainContract.ViewContract {
    private val TAG = "MainActivity"

    private var newsAdapter: NewsAdapter? = null
    private lateinit var list: MutableList<Article1>
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList()
        newsAdapter = NewsAdapter(list)
        rvNews.adapter = newsAdapter
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.setHasFixedSize(true)
        newsAdapter?.onItemClick={article1 ->
            var intent = Intent(this,ArticleActivity::class.java)
            intent?.putExtra(Article1::class.java.name, article1)
            startActivity(intent)

        }
        btnUpdate.setOnClickListener(this)

        presenter = MainPresenter(this).apply {
            onViewCreated()
        }

    }

    override fun showNews(feed: Feed1) {
        tvMain.text = feed.channelTitle.toString()
        list.clear()
        list.addAll(feed.articleList)
        newsAdapter?.notifyDataSetChanged()
//        rvNews.adapter = NewsAdapter(feed.articleList)
//        rvNews.layoutManager = LinearLayoutManager(this)
//        rvNews.setHasFixedSize(true)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnUpdate -> {
                Log.d(TAG, "btn update has been pressed")
                presenter.apply { MainPresenter(this@MainActivity).updateListNews() }
            }
        }
    }
}