package org.techtown.crecker.ads.contents.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.ads.contents.data.Ads
import org.techtown.crecker.ads.contents.viewholder.AdsHorizontalVH

class AdsHorizontalAdapter (private val context : Context) : RecyclerView.Adapter<AdsHorizontalVH>(){
    var data = listOf<Ads.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsHorizontalVH {
        val view = LayoutInflater.from(context).inflate(R.layout.ads_list_item, parent , false)
        return AdsHorizontalVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AdsHorizontalVH, position: Int) {
        holder.bind(data[position])
    }
}