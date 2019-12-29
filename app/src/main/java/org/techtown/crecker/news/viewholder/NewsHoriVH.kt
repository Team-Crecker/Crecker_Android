package org.techtown.crecker.news.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.news.data.NewsData


class NewsHoriVH(view : View) : RecyclerView.ViewHolder(view){
    val news_item_img : ImageView = view.findViewById(R.id.news_hori_item_img)
    val news_item_company : TextView = view.findViewById(R.id.news_hori_item_company_tv)
    val news_item_title : TextView = view.findViewById(R.id.news_hori_item_title_tv)
    val news_item_day : TextView = view.findViewById(R.id.news_hori_item_day_tv)

    fun onBind(data : NewsData) {
        news_item_company.text = data.company
        news_item_title.text = data.title
        news_item_day.text = data.day
    }
}