package org.techtown.crecker.law.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.expert_banner_item.view.*
import org.techtown.crecker.R

class ExpertBannerAdpater(context : Context) : PagerAdapter(){

    private var mContext = context
    var img_resource : List<Int> = listOf()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var inflater : LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var V = inflater.inflate(R.layout.expert_banner_item, container, false)

        var image : ImageView = V.findViewById(R.id.expert_banner_img)
//        image.setImageResource(R.drawable.img_home_law1)

        Glide.with(V)
            .load(img_resource[position])
            .into(image)

        container.addView(V)

        return V
    }

    override fun getCount(): Int {
        return img_resource.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ==  `object`
    }
}