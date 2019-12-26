package org.techtown.crecker.feature.ads

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.zhpan.bannerview.holder.ViewHolder
import org.techtown.crecker.R

class BannerVH : ViewHolder<BannerData> {
    override fun getLayoutId() = R.layout.banner_ads

    override fun onBind(itemView: View?, data: BannerData?, position: Int, size: Int) {
        val imageView: ImageView = itemView!!.findViewById(R.id.banner_image)
        val titleView: TextView = itemView.findViewById(R.id.title)
        val descView: TextView = itemView.findViewById(R.id.desc)
        val ddayView: TextView = itemView.findViewById(R.id.dday)

        Glide.with(itemView)
            .load(data?.imgLocalUrl)
            .into(imageView)
        titleView.text = data?.imageTitle
        descView.text = data?.imageDescription
        ddayView.text = data?.imageDday
    }

}