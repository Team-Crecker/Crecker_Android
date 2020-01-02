package org.techtown.crecker.news.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_news_edu.view.*

import org.techtown.crecker.R
import org.techtown.crecker.news.adapter.NewsRecentAdapter
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.api.NewsServiceImpl
import org.techtown.crecker.news.data.NewsApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsEduFragment : Fragment() {
    lateinit private var newsEduRecentAdapter : NewsRecentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val V = inflater.inflate(R.layout.fragment_news_edu, container, false)
        initRcv(V)
        return V
    }

    private fun initRcv(V : View){
        newsEduRecentAdapter = NewsRecentAdapter(V.context)
        V.news_edu_rv.adapter = newsEduRecentAdapter
        V.news_edu_rv.layoutManager = GridLayoutManager(V.context, 2)
        V.news_edu_rv.addItemDecoration(RcvItemDeco(V.context, true))

        val call : Call<NewsApiData> = NewsServiceImpl.service.getSupportNews(2)
        call.enqueue(
            object : Callback<NewsApiData>{
                override fun onFailure(call: Call<NewsApiData>, t: Throwable) {
                    "$t".debugLog("CallFailed in SupportNews")
                }

                override fun onResponse(call: Call<NewsApiData>, response: Response<NewsApiData>) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            newsEduRecentAdapter.data = it
                            newsEduRecentAdapter.notifyDataSetChanged()
                        }
                }
            }
        )
    }
}
