package org.techtown.crecker.ads.contents

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R


class AdsVH(view : View) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.ad_item_img)
    private val tvTitle : TextView = view.findViewById(R.id.ad_item_tv_title)
    private val tvPrice : TextView = view.findViewById(R.id.ad_item_tv_price)

    fun bind(data : AdData) {
        Glide.with(itemView)
            .load(data.img_local)
            .into(img)

        tvTitle.text = data.title
        tvPrice.text = "제품 · ${data.price}"
    }
}