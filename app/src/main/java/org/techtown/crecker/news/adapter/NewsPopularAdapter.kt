package org.techtown.crecker.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.news.data.NewsApiData
import org.techtown.crecker.news.viewholder.NewsHoriVH

class NewsPopularAdapter (private val context : Context) : RecyclerView.Adapter<NewsHoriVH>(){
    var data = listOf<NewsApiData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHoriVH {
        val view = LayoutInflater.from(context).inflate(
            R.layout.news_hori_list_item, parent ,
            false)

        return NewsHoriVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NewsHoriVH, position: Int) {
        holder.onBind(data[position])
    }
}