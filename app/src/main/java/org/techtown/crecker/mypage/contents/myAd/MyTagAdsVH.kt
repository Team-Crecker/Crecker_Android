package org.techtown.crecker.mypage.contents.myAd

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.mypage.advertise.activity.MyAdsDetailActivity
import org.techtown.crecker.mypage.advertise.data.TagAdData

class MyTagAdsVH(view : View, private val flag: Int) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.my_ad_item_img)
    private val tvKor : TextView = view.findViewById(R.id.my_ad_kor)
    private val tvPrice : TextView = view.findViewById(R.id.my_ad_tv_price)
    private val tag : TextView = view.findViewById(R.id.need_upload)

    fun bind(data : TagAdData.Data) {
        Glide.with(itemView)
            .load(data.thumbnail)
            .into(img)

        tvKor.text = data.title
        tvPrice.text = "제품 · ${data.cash}"

        itemView.setOnClickListener {
            it.context.startActivity(
                Intent(it.context, MyAdsDetailActivity::class.java).apply {
                    putExtra("idx", data.adIdx)
                    putExtra("flag", flag)
                })
        }

        if(data.isWarn == 1)
            tag.isVisible = true

        if(flag == 4){
            itemView.alpha = 0.5f
            itemView.isEnabled = false
        }
    }
}