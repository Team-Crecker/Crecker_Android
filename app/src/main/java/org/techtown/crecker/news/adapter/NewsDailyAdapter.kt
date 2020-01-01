package org.techtown.crecker.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.news.data.NewsDailyData
import org.techtown.crecker.news.viewholder.NewsDailyVH

class NewsDailyAdapter (private val context : Context) : RecyclerView.Adapter<NewsDailyVH>(){
    var data = listOf<NewsDailyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsDailyVH {
        val view = LayoutInflater.from(context).inflate(R.layout.daily_list_item,parent, false)
        return NewsDailyVH(view)
    }

    override fun onBindViewHolder(holder: NewsDailyVH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size
}