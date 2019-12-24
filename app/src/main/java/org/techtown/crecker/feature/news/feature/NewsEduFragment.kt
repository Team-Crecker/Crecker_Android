package org.techtown.crecker.feature.news.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_news_edu.view.*

import org.techtown.crecker.R
import org.techtown.crecker.feature.news.adapter.NewsAdapter
import org.techtown.crecker.feature.news.data.NewsData
import org.techtown.crecker.module.RcvItemDeco


class NewsEduFragment : Fragment() {
    lateinit private var newsEduAdapter : NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val V = inflater.inflate(R.layout.fragment_news_edu, container, false)
        newsEduAdapter = NewsAdapter(V.context)
        V.news_edu_rv.adapter = newsEduAdapter

        V.news_edu_rv.layoutManager = GridLayoutManager(V.context, 2)
        V.news_edu_rv.addItemDecoration(RcvItemDeco())

        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.addItem(NewsData(img_url = "", company = "company", title = "title", day = "day"))
        newsEduAdapter.notifyDataSetChanged()
        return V
    }
}
