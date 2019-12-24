package org.techtown.crecker.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.view.*

import org.techtown.crecker.R
import org.techtown.crecker.feature.news.adapter.NewsViewPagerAdapter
import org.techtown.crecker.feature.news.feature.NewsAllFragment
import org.techtown.crecker.feature.news.feature.NewsEduFragment

class NewsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val V = inflater.inflate(R.layout.fragment_news, container, false)
        val context : Context = V.context

        val allAdapter = NewsViewPagerAdapter(childFragmentManager)

        allAdapter.addItems(NewsAllFragment())
        allAdapter.addItems(NewsEduFragment())
        allAdapter.addItems(NewsEduFragment())
        allAdapter.addItems(NewsEduFragment())

        V.news_viewpager.adapter = allAdapter
        V.news_tablayout.setupWithViewPager(V.news_viewpager)

        V.news_tablayout.getTabAt(0)?.setText("전체")
        V.news_tablayout.getTabAt(1)?.setText("교육")
        V.news_tablayout.getTabAt(2)?.setText("지원")
        V.news_tablayout.getTabAt(3)?.setText("공모전")

        return V
    }

}
