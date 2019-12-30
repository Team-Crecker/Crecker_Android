package org.techtown.crecker.ads.contents

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.ads.activity.AdsDetailActivity


class AdsVH(view : View) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.ad_item_img)
    private val tvTitle : TextView = view.findViewById(R.id.ad_item_tv_title)
    private val tvPrice : TextView = view.findViewById(R.id.ad_item_tv_price)

    fun bind(data : AdData) {
        Glide.with(itemView)
            .load(data.img_local)
            .into(img)

        tvTitle.text = data.title_kor
        tvPrice.text = "제품 · ${data.price}"

        itemView.setOnClickListener {
            it.context.startActivity(
                Intent(it.context, AdsDetailActivity::class.java)
                    .apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        putExtra("title", data.title_kor)
                    }
            )
        }
    }
}