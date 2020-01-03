package org.techtown.crecker.mypage.scrap.ViewHolder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.daily_list_item.view.*
import org.techtown.crecker.R
import org.techtown.crecker.mypage.scrap.data.ScrapApiData
import org.techtown.crecker.news.activity.NewsMoreActivity

class ScrapVH(view : View) : RecyclerView.ViewHolder(view){

    val image : ImageView = view.findViewById(R.id.daily_thumbnail_img)
    val title : TextView = view.findViewById(R.id.daily_news_title_tv)
    val upload : TextView = view.findViewById(R.id.daily_upload_tv)

    fun onBind(data : ScrapApiData.Data){
        Glide.with(itemView)
            .load(data.poster)
            .into(image)

        title.text = data.title
        upload.text = data.createAt

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, NewsMoreActivity::class.java)
            intent.putExtra("Idx",data.newsIdx)
            itemView.context.startActivity(intent)
        }
    }

}