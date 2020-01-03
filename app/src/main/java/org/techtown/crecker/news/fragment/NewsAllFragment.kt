package org.techtown.crecker.news.fragment


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.amn.easysharedpreferences.EasySharedPreference
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.adapter.OnPageChangeListenerAdapter
import com.zhpan.bannerview.constants.IndicatorGravity
import com.zhpan.bannerview.constants.IndicatorSlideMode
import com.zhpan.bannerview.constants.IndicatorStyle
import com.zhpan.bannerview.utils.BannerUtils
import kotlinx.android.synthetic.main.fragment_news_all.view.*

import org.techtown.crecker.R
import org.techtown.crecker.news.adapter.NewsRecentAdapter
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.RcvItemHoriDeco
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.activity.NewsDetailActivity
import org.techtown.crecker.news.adapter.NewsPopularAdapter
import org.techtown.crecker.news.api.NewsServiceImpl
import org.techtown.crecker.news.data.NewsApiData
import org.techtown.crecker.news.data.NewsBannerApiData
import org.techtown.crecker.news.viewholder.NewsBannerVH
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsAllFragment : Fragment() {
    private lateinit var newsAdapter : NewsPopularAdapter
    private lateinit var newsRecentAdapter : NewsRecentAdapter
    private lateinit var mView : View
//    private lateinit var mContext : Context

    private var mDrawableList : List<NewsBannerApiData.Data> = listOf()
    private var mViewPager : BannerViewPager<NewsBannerApiData.Data, NewsBannerVH>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_news_all, container, false)
        mView = V

        initBannerData()
        initPopularRcv()
        initRecentRcv()
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

    private fun initPopularRcv(){
        newsAdapter = NewsPopularAdapter(mView.context)
        mView.news_popular_rv.adapter = newsAdapter
        mView.news_popular_rv.layoutManager = LinearLayoutManager(mView.context, LinearLayoutManager.HORIZONTAL, false)
        mView.news_popular_rv.addItemDecoration(RcvItemHoriDeco(mView.context))
        val call : Call<NewsApiData> = NewsServiceImpl.service.getSupportNews(1)
        call.enqueue(
            object : Callback<NewsApiData>{
                override fun onFailure(call: Call<NewsApiData>, t: Throwable) {
                    "$t".debugLog("CallBackFailed in News")
                }

                override fun onResponse(call: Call<NewsApiData>, response: Response<NewsApiData>) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            newsAdapter.data = it
                            newsAdapter.notifyDataSetChanged()
                        }
                }
            }
        )
    }

    private fun initRecentRcv(){
        newsRecentAdapter = NewsRecentAdapter(mView.context)
        mView.news_recent_rv.adapter = newsRecentAdapter
        mView.news_recent_rv.layoutManager = GridLayoutManager(mView.context, 2)
        mView.news_recent_rv.addItemDecoration(RcvItemDeco(mView.context,true)) // 여백 설정
        val call : Call<NewsApiData> = NewsServiceImpl.service.getSupportNews(2)
        call.enqueue(
            object : Callback<NewsApiData>{
                override fun onFailure(call: Call<NewsApiData>, t: Throwable) {
                    "$t".debugLog("CallBackFailed in Recent News")
                }

                override fun onResponse(call: Call<NewsApiData>, response: Response<NewsApiData>) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            newsRecentAdapter.data = it
                            newsRecentAdapter.notifyDataSetChanged()
                        }
                }
            }
        )

    }



    private fun initBannerData(){
        val call : Call<NewsBannerApiData> = NewsServiceImpl.service.getBannerNews()
        call.enqueue(
            object : Callback<NewsBannerApiData> {
                override fun onFailure(call: Call<NewsBannerApiData>, t: Throwable) {
                    "$t".debugLog("CallBackFailed in NewsBanner")
                }

                override fun onResponse(
                    call: Call<NewsBannerApiData>,
                    response: Response<NewsBannerApiData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            mDrawableList = it
                            initView(mView)
                        }
                }
            }
        )
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
            .setIndicatorWidth(150)
            .setIndicatorColor(
                Color.parseColor("#c9cdd2"),
                Color.parseColor("#000000")
            )
            .create(mDrawableList)
    }

}
