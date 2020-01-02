package org.techtown.crecker.news.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.techtown.crecker.R
import org.techtown.crecker.news.activity.NewsMoreActivity
import org.techtown.crecker.news.data.NewsApiData
import org.techtown.crecker.news.data.NewsData


class NewsViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val glideManager : RequestManager = Glide.with(itemView)

    val news_item_img : ImageView = view.findViewById(R.id.news_item_img)
    val news_item_company : TextView = view.findViewById(R.id.news_item_company_tv)
    val news_item_title : TextView = view.findViewById(R.id.news_item_title_tv)
    val news_item_day : TextView = view.findViewById(R.id.news_item_day_tv)

    fun onBind(data : NewsApiData.Data) {
        news_item_company.text = data.host
        news_item_title.text = data.title
        news_item_day.text = "7"
        loading(data.poster, news_item_img)

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, NewsMoreActivity::class.java)
            intent.putExtra("Idx",data.newsIdx)
            itemView.context.startActivity(intent)
        }
    }

    private fun loading(url:String, view : ImageView){
        view.post {
            glideManager.load(url).into(view)
        }
    }
}