package org.techtown.crecker.news.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.view.*

import org.techtown.crecker.R
import org.techtown.crecker.news.adapter.NewsViewPagerAdapter
import org.techtown.crecker.news.fragment.NewsAllFragment
import org.techtown.crecker.news.fragment.NewsDailyFragment
import org.techtown.crecker.news.fragment.NewsEduFragment

class NewsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val V = inflater.inflate(R.layout.fragment_news, container, false)
        val daily = NewsDailyFragment.newInstance()

        val allAdapter = NewsViewPagerAdapter(childFragmentManager)
        allAdapter.addItems(NewsAllFragment())
        allAdapter.addItems(daily)
        allAdapter.addItems(NewsEduFragment())

        V.news_viewpager.adapter = allAdapter
        V.news_tablayout.setupWithViewPager(V.news_viewpager)

        V.news_tablayout.getTabAt(0)?.setText("All")
        V.news_tablayout.getTabAt(1)?.setText("Daliy")
        V.news_tablayout.getTabAt(2)?.setText("Support")

        return V
    }

}
