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

      /*  val content = V.tv_home_user_recom.text.toString()
        val spannableString = SpannableString(content)

        val word = "소식"
        val start = content.indexOf(word)
        val end = start + word.length

        spannableString.setSpan( StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        V.tv_home_user_recom.setText(spannableString) */

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
                if (response.isSuccessful) {
                    when (response.code()) {
                        200 -> {
                            if(response.body()!!.success) {
                                Glide.with(view)
                                    .load(response.body()!!.data)
                                    .into(view.img_home_user_recom)

                                bannerIdx = response.body()!!.homeBannerIdx
                            }
                            else
                                Toast.makeText(mContext, "데이터를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }

                        600 -> Toast.makeText(mContext , "서버 연결 실패", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })

        view.img_home_user_recom.setOnClickListener {
            when (bannerIdx) {
                0 -> {
                    it.context.startActivity(
                        Intent(it.context, NewsMoreActivity::class.java))
                }
                1-> {
                    it.context.startActivity(
                        Intent(it.context, NewsMoreActivity::class.java))
                }
                2 ->{
                    it.context.startActivity(
                        Intent(it.context, NewsMoreActivity::class.java))
                }
            }
        }

    }

    private fun initHomeAdsList(view : View) {

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
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    when (response.code()) {
                        200 -> {
                            if(response.body()!!.success) {

                                homeAdsAdapter.data = response.body()!!.data
                                homeSupportAdapter.notifyDataSetChanged()
                            }
                            else
                                Toast.makeText(mContext, "데이터를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }

                        600 -> Toast.makeText(mContext , "서버 연결 실패", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })


        homeAdsAdapter = HomeAdsListAdapter(mContext)
        view.rv_list_home_ads.adapter = homeAdsAdapter
        view.rv_list_home_ads.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL , false)
        view.rv_list_home_ads.addItemDecoration(RcvItemHoriDeco(mContext,false, 8))
        homeAdsAdapter.notifyDataSetChanged()

    }

    private fun initHomeSupportList(view : View) {


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
                Log.d("cre__", "get user info success ${response.isSuccessful}")
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    when (response.code()) {
                        200 -> {
                            if(response.body()!!.success) {

                                homeSupportAdapter.data = response.body()!!.data
                            }
                            else
                                Toast.makeText(mContext, "데이터를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }

                        600 -> Toast.makeText(mContext , "서버 연결 실패", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })

        homeSupportAdapter = HomeSupportListAdapter(mContext)
        view.rv_list_home_support.adapter = homeSupportAdapter
        view.rv_list_home_support.layoutManager = GridLayoutManager(mContext, 2)
        view.rv_list_home_support.addItemDecoration(RcvItemDeco(mContext))

        homeSupportAdapter.notifyDataSetChanged()

    }

}
