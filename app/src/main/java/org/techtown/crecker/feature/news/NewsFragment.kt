package org.techtown.crecker.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news.view.*

import org.techtown.crecker.R
import org.techtown.crecker.feature.news.adapter.BannerAdapter
import org.techtown.crecker.feature.news.adapter.NewsAdapter
import org.techtown.crecker.feature.news.data.NewsData
import org.techtown.crecker.feature.news.feature.RcvItemDeco

class NewsFragment : Fragment() {
    lateinit private  var newsAdapter : NewsAdapter
    lateinit private var newsRecentAdapter : NewsAdapter
    lateinit private var bannerAdapter : BannerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val V = inflater.inflate(R.layout.fragment_news, container, false)
        val context : Context = V.context

        //뉴스 메인 배너
        bannerAdapter = BannerAdapter(context)
        V.news_banner.adapter = bannerAdapter

        //인기 지원 활동 리사이클러 뷰
        newsAdapter = NewsAdapter(context)
        V.news_popular_rv.adapter = newsAdapter
        V.news_popular_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))

        newsRecentAdapter = NewsAdapter(context)
        V.news_recent_rv.adapter = newsRecentAdapter
        V.news_recent_rv.layoutManager = GridLayoutManager(context,2)
        V.news_recent_rv.addItemDecoration(RcvItemDeco()) // 여백 설정

        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsRecentAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))

        newsAdapter.notifyDataSetChanged()
        newsRecentAdapter.notifyDataSetChanged()



        return V
    }

}
