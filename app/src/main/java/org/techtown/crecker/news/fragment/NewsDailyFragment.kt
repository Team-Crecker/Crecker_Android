package org.techtown.crecker.news.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.amn.easysharedpreferences.EasySharedPreference
import kotlinx.android.synthetic.main.fragment_news_daily.view.*

import org.techtown.crecker.R
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.adapter.NewsDailyAdapter
import org.techtown.crecker.news.api.NewsServiceImpl
import org.techtown.crecker.news.data.NewsDailyApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val call : Call<NewsDailyApiData> = NewsServiceImpl.service.getDailyAllNews()
        call.enqueue(
            object : Callback<NewsDailyApiData>{
                override fun onFailure(call: Call<NewsDailyApiData>, t: Throwable) {
                    "${t}".debugLog("CallBackFailed in DailyNews")
                }

                override fun onResponse(
                    call: Call<NewsDailyApiData>,
                    response: Response<NewsDailyApiData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            adapter.data = it
                            adapter.notifyDataSetChanged()
                        }
                }
            }
        )
    }


    companion object {

        @JvmStatic
        fun newInstance() = NewsDailyFragment()
    }
}
