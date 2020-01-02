package org.techtown.crecker.news.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.zhpan.bannerview.holder.ViewHolder
import org.techtown.crecker.R
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.activity.NewsDetailActivity
import org.techtown.crecker.news.data.NewsBannerApiData


class NewsBannerVH  : ViewHolder<NewsBannerApiData.Data>{
    override fun getLayoutId() = R.layout.news_banner_item

    override fun onBind(itemView: View?, data: NewsBannerApiData.Data?, position: Int, size: Int) {

        val image : ImageView= itemView!!.findViewById(R.id.news_banner_img)

        Glide.with(itemView)
            .load(data?.thumbnail)
            .into(image)
        "bannerBindOk".debugLog()

        image.setOnClickListener {
            val intent = Intent(itemView.context, NewsDetailActivity::class.java)
            intent.putExtra("Idx", data?.dailyIdx)
            itemView.context.startActivity(intent)
        }
    }
}