package org.techtown.crecker.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.home.data.HomeAdsItem
import org.techtown.crecker.home.data.HomeAdsListData
import org.techtown.crecker.home.viewholder.HomeAdsListViewHolder

class HomeAdsListAdapter(
    private val context: Context
) : RecyclerView.Adapter<HomeAdsListViewHolder>() {

    var data: List<HomeAdsListData.Data> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdsListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_ads_item, parent, false)
        return HomeAdsListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeAdsListViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}