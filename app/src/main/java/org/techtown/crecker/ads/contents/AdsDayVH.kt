package org.techtown.crecker.ads.contents

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R


class AdsDayVH(view : View) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.ad_item_img)
    private val tvTitle : TextView = view.findViewById(R.id.ad_item_tv_title)
    private val tvPrice : TextView = view.findViewById(R.id.ad_item_tv_price)
    private val tvDday : TextView = view.findViewById(R.id.item_tv_dday)

    fun bind(data : AdDataWithDay) {
        Glide.with(itemView)
            .load(data.img_local)
            .into(img)

        tvTitle.text = data.title
        tvPrice.text = "제품 · ${data.price}"
        tvDday.text = "D-${data.dday}"

        if(data.dday > 7)
            tvDday.setBackgroundColor(Color.parseColor("#c9cdd2"))
    }
}