package org.techtown.crecker.mypage.report.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.report.data.RatingData
import org.techtown.crecker.mypage.report.data.TotalData
import org.techtown.crecker.mypage.report.viewholder.RatingVH

class RatingRvAdp (private val context: Context) : RecyclerView.Adapter<RatingVH>(){
    var data = listOf<TotalData.Data.Top>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingVH {
        val view = LayoutInflater.from(context).inflate(R.layout.report_rating_list_item, parent, false)
        return RatingVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RatingVH, position: Int) {
        holder.onBind(data[position],position + 1)
    }
}