package com.dzmitrykavalioum.rsstut.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dzmitrykavalioum.rsstut.R
import com.dzmitrykavalioum.rsstut.model.Article1

class NewsAdapter(private val listItems: List<Article1>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var onItemClick: ((Article1) -> Unit)? = null
    @SuppressLint("ResourceAsColor")
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivTitle: ImageView = itemView.findViewById(R.id.ivTitle)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvLink: TextView = itemView.findViewById(R.id.tvLink)
        val tvPubDate: TextView = itemView.findViewById(R.id.tvPubDate)
        init {
            itemView.setOnClickListener {
                //TODO test for change text color when article has been reading
                tvTitle.setTextColor(R.color.grey)
                onItemClick?.invoke(listItems[position])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = listItems.get(position)
        holder.tvTitle.text = currentItem.title
        holder.tvLink.text = currentItem.link
        holder.tvPubDate.text = currentItem.pubDate
    }

}