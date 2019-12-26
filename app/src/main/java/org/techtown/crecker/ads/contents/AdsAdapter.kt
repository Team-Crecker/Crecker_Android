package org.techtown.crecker.ads.contents

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R

class AdsAdapter (private val context : Context) : RecyclerView.Adapter<AdsVH>(){
    var data = arrayListOf<AdData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsVH {
        val view = LayoutInflater.from(context).inflate(R.layout.ads_list_item, parent , false)
        return AdsVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AdsVH, position: Int) {
        holder.bind(data[position])
    }
}