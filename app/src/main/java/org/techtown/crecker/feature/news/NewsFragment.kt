package org.techtown.crecker.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news.view.*

import org.techtown.crecker.R
import org.techtown.crecker.feature.main.MainActivity
import org.techtown.crecker.feature.news.adapter.NewsAdapter
import org.techtown.crecker.feature.news.data.NewsData

class NewsFragment : Fragment() {
    lateinit private  var newsAdapter : NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_news, container, false)
        val context : Context = V.context
        newsAdapter = NewsAdapter(context)

        V.news_popular_rv.adapter = newsAdapter
        V.news_popular_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))

        newsAdapter.notifyDataSetChanged()


        return V
    }


}
