package org.techtown.crecker.news.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.news_banner_item.view.*
import org.techtown.crecker.R

class BannerAdapter(context : Context) : PagerAdapter() {

    var data = arrayListOf<String>("1","2","3","4","5")
    var mcontext = context

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var inflater : LayoutInflater = mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var V = inflater.inflate(R.layout.news_banner_item, container, false)

        container.addView(V)

        return V
    }

    override fun getCount(): Int = 5

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        Log.d("success","viewfrom ok")
        return view == `object`
    }
}

