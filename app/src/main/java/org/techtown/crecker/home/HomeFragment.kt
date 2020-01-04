package org.techtown.crecker.home


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home_content.view.*

import org.techtown.crecker.home.adapter.HomeAdsListAdapter
import org.techtown.crecker.home.adapter.HomeSupportListAdapter
import org.techtown.crecker.module.RcvItemDeco
import android.text.SpannableString
import android.graphics.Typeface
import android.text.Spannable
import android.text.style.StyleSpan
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home_content.*
import kotlinx.android.synthetic.main.fragment_home_content.view.img_home_law01
import org.techtown.crecker.R
import org.techtown.crecker.home.api.HomeFragServiceImpl
import org.techtown.crecker.home.data.*
import org.techtown.crecker.main.MainActivity
import org.techtown.crecker.membership.api.SignUpServiceImpl
import org.techtown.crecker.membership.data.SignUpResultData
import org.techtown.crecker.membership.login.LogInActivity
import org.techtown.crecker.module.RcvItemHoriDeco
import org.techtown.crecker.news.activity.NewsMoreActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        initBannerImg(V)

        return V
    }

    private fun initBannerImg(view: View) {
        var bannerIdx : Int = 0
        HomeFragServiceImpl.bannerService.getBannerImgData().enqueue(object :
            Callback<HomeBannerImgData> {
            override fun onFailure(call: Call<HomeBannerImgData>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("cre__", "error : $t")
            }

            override fun onResponse(
                call: Call<HomeBannerImgData>,
                response: Response<HomeBannerImgData>
            ) {
                Log.d("cre__", "get user info success ${response.isSuccessful}")
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                response.takeIf { it.isSuccessful }
                    ?.body()
                    ?.data
                    ?.let {
                        Glide.with(view)
                            .load(it.url)
                            .into(view.img_home_user_recom)
                        bannerIdx = it.homeBannerIdx
                    }
            }
        })
    }

    private fun initHomeAdsList(view : View) {

        homeAdsAdapter = HomeAdsListAdapter(mContext)
        view.rv_list_home_ads.adapter = homeAdsAdapter
        view.rv_list_home_ads.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL
            , false)
        view.rv_list_home_ads.addItemDecoration(RcvItemHoriDeco(mContext,false, 8))

        HomeFragServiceImpl.adsService.getAdsListData().enqueue(object :
            Callback<HomeAdsListData> {
            override fun onFailure(call: Call<HomeAdsListData>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("cre__", "error : $t")
            }

            override fun onResponse(
                call: Call<HomeAdsListData>,
                response: Response<HomeAdsListData>
            ) {
                Log.d("cre__", "get user info success ${response.isSuccessful}")
                response.takeIf { it.isSuccessful }
                    ?.body()
                    ?.data
                    ?.let {
                        homeAdsAdapter.data = it
                        homeAdsAdapter.notifyDataSetChanged()
                    }

            }
        })
    }

    private fun initHomeSupportList(view : View) {
        homeSupportAdapter = HomeSupportListAdapter(mContext)
        view.rv_list_home_support.adapter = homeSupportAdapter
        view.rv_list_home_support.layoutManager = GridLayoutManager(mContext, 2)
        view.rv_list_home_support.addItemDecoration(RcvItemDeco(mContext,true,8))

        HomeFragServiceImpl.supportService.getSupportListData().enqueue(object :
            Callback<HomeSupportListData> {
            override fun onFailure(call: Call<HomeSupportListData>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("cre__", "error : $t")
            }

            override fun onResponse(
                call: Call<HomeSupportListData>,
                response: Response<HomeSupportListData>
            ) {
                response.takeIf { it.isSuccessful }
                    ?.body()
                    ?.data
                    ?.let {
                        homeSupportAdapter.data = it
                        homeSupportAdapter.notifyDataSetChanged()
                    }
            }
        })

    }

}
