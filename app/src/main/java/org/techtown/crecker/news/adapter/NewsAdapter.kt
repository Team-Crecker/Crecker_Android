package org.techtown.crecker.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.news.data.NewsData
import org.techtown.crecker.news.viewholder.NewsViewHolder

class NewsAdapter (private val context : Context) : RecyclerView.Adapter<NewsViewHolder>(){
    var data = arrayListOf<NewsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent , false)

        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       holder.onBind(data[position])
    }

    fun addItem(item : NewsData){
        data.add(item)
    }
}