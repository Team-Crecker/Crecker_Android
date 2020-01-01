package org.techtown.crecker.ads.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_ad_detail.view.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.api.AdsServiceImpl
import org.techtown.crecker.ads.category.EventBus
import org.techtown.crecker.ads.contents.AdData
import org.techtown.crecker.ads.contents.AdsDdayAdapter
import org.techtown.crecker.ads.contents.data.Ads
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdsCtgFragment : Fragment() {
    private lateinit var mContext: Context
    private lateinit var adapter: AdsDdayAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ad_detail, container, false)

        adapter = AdsDdayAdapter(mContext)
        view.rv_ad_detail.adapter = adapter
        view.rv_ad_detail.layoutManager = GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)

        val idx = when(EventBus.title){
            "Premium" -> 1
            "Beauty" -> 2
            "Restaurant" -> 3
            "Travel" -> 4
            else -> 5
        }
        AdsServiceImpl.service.getCategorizedAds(idx).enqueue(object : Callback<Ads>{
            override fun onFailure(call: Call<Ads>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(call: Call<Ads>, response: Response<Ads>) {
                adapter.data = response.takeIf { it.isSuccessful }?.body()?.data!!
                adapter.notifyDataSetChanged()
            }
        })

        return view
    }
}