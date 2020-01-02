package org.techtown.crecker.news.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.techtown.crecker.R
import org.techtown.crecker.news.activity.NewsDetailActivity
import org.techtown.crecker.news.data.NewsDailyData

class NewsDailyVH (view : View) : RecyclerView.ViewHolder(view){
    private val glideManager : RequestManager = Glide.with(itemView)

    private val thumbnail : ImageView = view.findViewById(R.id.daily_thumbnail_img)
    private val title : TextView = view.findViewById(R.id.daily_news_title_tv)
    private val upload : TextView = view.findViewById(R.id.daily_upload_tv)

    fun onBind(data : NewsDailyData){
        title.text = data.title
        upload.text = data.upload.toString()

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, NewsDetailActivity::class.java)
            itemView.context.startActivity(intent)
        }
    }

    private fun loading(url : String, view : ImageView){
        view.post{
            glideManager.load(url).into(view)
        }
    }
}