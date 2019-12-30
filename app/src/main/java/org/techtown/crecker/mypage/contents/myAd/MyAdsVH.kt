package org.techtown.crecker.mypage.contents.myAd

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.ads.contents.AdData


class MyAdsVH(view : View) : RecyclerView.ViewHolder(view){
    private val img : ImageView = view.findViewById(R.id.my_ad_item_img)
    private val tvKor : TextView = view.findViewById(R.id.my_ad_kor)
    private val tvEng : TextView = view.findViewById(R.id.my_ad_eng)
    private val tvPrice : TextView = view.findViewById(R.id.my_ad_tv_price)

    fun bind(data : AdData) {
        Glide.with(itemView)
            .load(data.img_local)
            .into(img)

        tvKor.text = data.title_kor
        tvEng.text = data.title_eng
        tvPrice.text = "제품 · ${data.price}"
    }
}