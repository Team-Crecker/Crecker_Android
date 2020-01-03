package org.techtown.crecker.mypage.contents.myAd

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.mypage.advertise.activity.MyAdsDetailActivity
import org.techtown.crecker.mypage.advertise.data.UserAdData


class MyAdsVH(view : View, private val flag: Int) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.my_ad_item_img)
    private val tvKor : TextView = view.findViewById(R.id.my_ad_kor)
    private val tvPrice : TextView = view.findViewById(R.id.my_ad_tv_price)

    fun bind(data : UserAdData.Data) {
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

        if(flag == 4){
            itemView.alpha = 0.5f
            itemView.isEnabled = false
        }
    }
}