package org.techtown.crecker.news.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.zhpan.bannerview.holder.ViewHolder
import org.techtown.crecker.R
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.data.NewsBannerData

class NewsBannerVH  : ViewHolder<NewsBannerData>{
    override fun getLayoutId() = R.layout.news_banner_item

    override fun onBind(itemView: View?, data: NewsBannerData?, position: Int, size: Int) {

        val image : ImageView= itemView!!.findViewById(R.id.news_banner_img)

        Glide.with(itemView)
            .load(data?.img_url)
            .into(image)
        "bannerBindOk".debugLog()
    }
}