package org.techtown.crecker.home


import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

import org.techtown.crecker.R
import org.techtown.crecker.home.adapter.HomeAdsListAdapter
import org.techtown.crecker.home.adapter.HomeSupportListAdapter
import org.techtown.crecker.home.data.HomeAdsItem
import org.techtown.crecker.home.data.HomeSupportItem
import org.techtown.crecker.module.RcvItemDeco

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var homeAdsAdapter: HomeAdsListAdapter
    private lateinit var homeSupportAdapter: HomeSupportListAdapter
    private lateinit var mContext : Context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_home, container, false)
        mContext = V.context


        initHomeAdsList(V)
        initHomeSupportList(V)

        return V
    }

    private fun initHomeAdsList(view : View) {


        homeAdsAdapter = HomeAdsListAdapter(mContext)
        view.rv_list_home_ads.adapter = homeAdsAdapter
        view.rv_list_home_ads.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL , false)
        homeAdsAdapter.data = listOf<HomeAdsItem>(
            HomeAdsItem(img = "", name = "모모스 커피", price = "제품 10,000", cash = ""),
            HomeAdsItem(img = "", name = "모모스 커피", price = "제품 10,000", cash = ""),
            HomeAdsItem(img = "", name = "모모스 커피", price = "제품 10,000", cash = ""),
            HomeAdsItem(img = "", name = "모모스 커피", price = "제품 10,000", cash = ""),
            HomeAdsItem(img = "", name = "모모스 커피", price = "제품 10,000", cash = "")
        )

        homeAdsAdapter.notifyDataSetChanged()

    }

    private fun initHomeSupportList(view : View) {

        homeSupportAdapter = HomeSupportListAdapter(mContext)
        view.rv_list_home_support.adapter = homeSupportAdapter
        view.rv_list_home_support.layoutManager = GridLayoutManager(mContext, 2)
        view.rv_list_home_support.addItemDecoration(RcvItemDeco(mContext))
        homeSupportAdapter.data = listOf<HomeSupportItem>(
            HomeSupportItem(img = "", company = "wework", title = "유튜브 크리에이터 모집", date = "D-7"),
            HomeSupportItem(img = "", company = "wework", title = "유튜브 크리에이터 모집", date = "D-7"),
            HomeSupportItem(img = "", company = "wework", title = "유튜브 크리에이터 모집", date = "D-7"),
            HomeSupportItem(img = "", company = "wework", title = "유튜브 크리에이터 모집", date = "D-7"),
            HomeSupportItem(img = "", company = "wework", title = "유튜브 크리에이터 모집", date = "D-7"),
            HomeSupportItem(img = "", company = "wework", title = "유튜브 크리에이터 모집", date = "D-7")
        )

        homeSupportAdapter.notifyDataSetChanged()

    }

}
