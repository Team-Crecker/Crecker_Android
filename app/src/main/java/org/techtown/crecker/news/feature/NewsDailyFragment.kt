package org.techtown.crecker.news.feature


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_news_daily.view.*

import org.techtown.crecker.R
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.news.adapter.NewsDailyAdapter
import org.techtown.crecker.news.data.NewsDailyData

class NewsDailyFragment : Fragment() {
    private lateinit var adapter : NewsDailyAdapter
    private lateinit var mView : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_news_daily, container, false)
        mView = v

        mountingRv()
        return v
    }

    private fun mountingRv(){
        adapter = NewsDailyAdapter(mView.context)
        mView.daily_rv.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(mView.context)
            it.addItemDecoration(RcvItemDeco(mView.context))
        }

        adapter.data = listOf(
            NewsDailyData(
                thumbnail = "",
                title = "데일리 뉴스 제목",
                upload = 1000
            ),
            NewsDailyData(
                thumbnail = "",
                title = "데일리 뉴스 제목",
                upload = 1000
            ),
            NewsDailyData(
                thumbnail = "",
                title = "데일리 뉴스 제목",
                upload = 1000
            )
        )

        adapter.notifyDataSetChanged()

    }


    companion object {

        @JvmStatic
        fun newInstance() = NewsDailyFragment()
    }
}
