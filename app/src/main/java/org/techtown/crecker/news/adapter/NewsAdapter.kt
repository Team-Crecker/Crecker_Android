package org.techtown.crecker.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.news.data.NewsData
import org.techtown.crecker.news.viewholder.NewsHoriVH
import org.techtown.crecker.news.viewholder.NewsViewHolder

class NewsAdapter (private val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var data = arrayListOf<NewsData>()

    override fun getItemViewType(position: Int): Int {
        return if (data[position].grid == true) 0
        else 1

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
//        val view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent , false)
//
//        return NewsViewHolder(view)

        return when (viewType){
            0 ->{
                val view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent , false)
                NewsViewHolder(view)
            }
            else ->{
                val view = LayoutInflater.from(context).inflate(R.layout.news_hori_list_item, parent , false)
                NewsHoriVH(view)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//       holder.onBind(data[position])

        when(holder){
            is NewsViewHolder ->{
                holder.onBind(data[position])
            }
            is NewsHoriVH ->{
                holder.onBind(data[position])
            }
        }
    }

    fun addItem(item : NewsData){
        data.add(item)
    }
}