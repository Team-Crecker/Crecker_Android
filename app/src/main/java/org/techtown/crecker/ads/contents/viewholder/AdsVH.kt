package org.techtown.crecker.ads.contents.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.ads.activity.AdsDetailActivity
import org.techtown.crecker.ads.contents.data.Ads


class AdsVH(view : View) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.ad_item_img)
    private val tvTitle : TextView = view.findViewById(R.id.ad_item_tv_title)
    private val tvPrice : TextView = view.findViewById(R.id.ad_item_tv_price)

    fun bind(data : Ads.Data) {
        Glide.with(itemView)
            .load(data.thumbnail)
            .into(img)

        tvTitle.text = data.title
        tvPrice.text = "제품 · ${data.cash}"

        itemView.setOnClickListener {
            it.context.startActivity(
                Intent(it.context, AdsDetailActivity::class.java)
                    .apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        putExtra("idx", data.adIdx)
                    }
            )
        }
    }
}