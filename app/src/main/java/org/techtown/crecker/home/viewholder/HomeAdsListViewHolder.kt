package org.techtown.crecker.home.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.home.data.HomeAdsItem


class HomeAdsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val img : ImageView = view.findViewById(R.id.img_list_item_home_ads)
    val name : TextView = view.findViewById(R.id.tv_list_item_home_ads_name)
    val price : TextView = view.findViewById(R.id.tv_list_item_home_ads_price)
    val cash : ImageView = view.findViewById(R.id.img_list_item_home_ads_cash)

    fun onBind(data: HomeAdsItem) {
        name.text = data.name
        price.text = data.price
    }




}
