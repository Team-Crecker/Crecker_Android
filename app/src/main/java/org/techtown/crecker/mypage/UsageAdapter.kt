package org.techtown.crecker.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R

class UsageAdapter (private val context : Context) : RecyclerView.Adapter<UsageVH>(){
    var data = arrayListOf<UsageRecord>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsageVH {
        val view = LayoutInflater.from(context).inflate(R.layout.usage_item, parent , false)
        return UsageVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UsageVH, position: Int) {
        holder.bind(data[position])
    }
}