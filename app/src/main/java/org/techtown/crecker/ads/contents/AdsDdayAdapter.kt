package org.techtown.crecker.ads.contents

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R

class AdsDdayAdapter (private val context : Context) : RecyclerView.Adapter<AdsDayVH>(){
    var data = arrayListOf<AdDataWithDay>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsDayVH {
        val view = LayoutInflater.from(context).inflate(R.layout.ads_list_item_dday, parent , false)
        return AdsDayVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AdsDayVH, position: Int) {
        holder.bind(data[position])
    }
}