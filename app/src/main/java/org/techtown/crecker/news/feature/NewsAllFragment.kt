package org.techtown.crecker.news.feature


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.IndicatorGravity
import com.zhpan.bannerview.constants.IndicatorSlideMode
import com.zhpan.bannerview.constants.IndicatorStyle
import com.zhpan.bannerview.utils.BannerUtils
import kotlinx.android.synthetic.main.fragment_news_all.view.*

import org.techtown.crecker.R
import org.techtown.crecker.news.adapter.BannerAdapter
import org.techtown.crecker.news.adapter.NewsAdapter
import org.techtown.crecker.news.data.NewsData
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.data.NewsBannerData
import org.techtown.crecker.news.viewholder.NewsBannerVH

class NewsAllFragment : Fragment() {
    private lateinit var newsAdapter : NewsAdapter
    private lateinit var newsRecentAdapter : NewsAdapter
//    private lateinit var mContext : Context

    private var mDrawableList : MutableList<NewsBannerData> = ArrayList()
    private var mViewPager : BannerViewPager<NewsBannerData, NewsBannerVH>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        this.mContext = context.applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_news_all, container, false)
        val context : Context = V.context

        initBannerData()
        initView(V)
        initRecycler(V,context)
        return V
    }

    override fun onPause() {
        super.onPause()
        mViewPager?.stopLoop()
    }

    override fun onResume() {
        super.onResume()
        mViewPager?.startLoop()
    }

    private fun initRecycler(V : View, context : Context) {

        //인기 지원 활동 리사이클러 뷰
        newsAdapter = NewsAdapter(context)
        V.news_popular_rv.adapter = newsAdapter
        V.news_popular_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newsAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )

//       최신 지원 활동 리사이클러 뷰
        newsRecentAdapter = NewsAdapter(context)
        V.news_recent_rv.adapter = newsRecentAdapter
        V.news_recent_rv.layoutManager = GridLayoutManager(context, 2)

        V.news_recent_rv.addItemDecoration(RcvItemDeco(context)) // 여백 설정

        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )
        newsRecentAdapter.addItem(
            NewsData(
                img_url = "",
                company = "company",
                title = "title",
                day = "day"
            )
        )

        newsAdapter.notifyDataSetChanged()
        newsRecentAdapter.notifyDataSetChanged()
    }

    private fun initBannerData(){
        val imgs = arrayOf(R.drawable.img_main_banner,R.drawable.img_main_banner,R.drawable.img_main_banner,R.drawable.img_main_banner)

        for (i in imgs){
            mDrawableList.add(NewsBannerData(img_url =  i))
        }
    }

    private fun initView(V : View){
        mViewPager = V.findViewById(R.id.news_banner)
        mViewPager!!.setIndicatorGap(BannerUtils.dp2px(6f))
            .setRoundCorner(BannerUtils.dp2px(6f))
            .setHolderCreator { NewsBannerVH() }
            .setInterval(3000)
        setUpIndicator()
    }

    private fun setUpIndicator(){
        mViewPager!!.setIndicatorStyle(IndicatorStyle.DASH)
            .setIndicatorHeight(5)
            .setIndicatorGravity(IndicatorGravity.CENTER)
            .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            .setIndicatorGap(0)
            .setPageMargin(resources.getDimensionPixelOffset(R.dimen.dp_3))
            .setIndicatorWidth(200)
            .setIndicatorColor(
                Color.parseColor("#c9cdd2"),
                Color.parseColor("#000000")
            ).create(mDrawableList)
    }



}
