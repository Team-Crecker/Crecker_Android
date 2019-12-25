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
import org.techtown.crecker.ads.contents.AdDataWithDay
import org.techtown.crecker.ads.contents.AdsDdayAdapter


class AdsCtgFragment : Fragment() {
    private lateinit var mContext: Context
    private lateinit var adapter: AdsDdayAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ad_detail, container, false)

        val dummy = AdDataWithDay("", R.drawable.img_thum1, "모모스 커피", 10000, 7)
        val dummy2 = AdDataWithDay("", R.drawable.img_thum2, "모모스 커피", 10000, 24)
        val dummy3 = AdDataWithDay("", R.drawable.img_thum2, "데저트 크림", 8000, 30)
1
        adapter = AdsDdayAdapter(mContext)
        adapter.data = arrayListOf(dummy, dummy2, dummy, dummy3, dummy3, dummy, dummy2)
        view.rv_ad_detail.adapter = adapter
        view.rv_ad_detail.layoutManager = GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)

        return view
    }
}