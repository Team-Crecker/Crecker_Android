package org.techtown.crecker.mypage.scrap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.scrap.ViewHolder.ScrapVH
import org.techtown.crecker.mypage.scrap.data.ScrapApiData

class ScrapAdp (private val context : Context) : RecyclerView.Adapter<ScrapVH>(){
    var data = listOf<ScrapApiData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrapVH {
        val view = LayoutInflater.from(context).inflate(R.layout.daily_list_item, parent, false)
        return ScrapVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ScrapVH, position: Int) {
       holder.onBind(data[position])
    }
}