package org.techtown.crecker.mypage.contents.notice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class NoticeAdapter (private val context : Context) : RecyclerView.Adapter<NoticeVH>(){

    var data = ArrayList<NoticeData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeVH {
        val view = LayoutInflater.from(context).inflate(org.techtown.crecker.R.layout.rv_notice, parent , false)
        return NoticeVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NoticeVH, position: Int) {
        holder.bind(data[position])
    }
}