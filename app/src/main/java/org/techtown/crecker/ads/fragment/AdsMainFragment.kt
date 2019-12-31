package org.techtown.crecker.ads.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.IndicatorGravity
import com.zhpan.bannerview.constants.IndicatorSlideMode
import com.zhpan.bannerview.constants.IndicatorStyle
import com.zhpan.bannerview.utils.BannerUtils
import kotlinx.android.synthetic.main.ad_main_fragment.view.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.api.AdsServiceImpl
import org.techtown.crecker.ads.contents.data.AdsRandom
import org.techtown.crecker.ads.banner.BannerData
import org.techtown.crecker.ads.banner.BannerVH
import org.techtown.crecker.ads.contents.adapter.AdsHorizontalAdapter
import org.techtown.crecker.ads.contents.data.Ads
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdsMainFragment : Fragment() {
    private var mBannerList: MutableList<BannerData> = ArrayList()
    private var mViewPager: BannerViewPager<BannerData, BannerVH>? = null

    private lateinit var rcmdAdapter: AdsHorizontalAdapter
    private lateinit var popularAdapter: AdsHorizontalAdapter
    private lateinit var recentAdapter: AdsHorizontalAdapter

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.ad_main_fragment, container, false)
        initAdapter(view)
        initBanner(view)
        initRemoteData()
        return view
    }

    override fun onPause() {
        super.onPause()
        mViewPager?.stopLoop()
    }

    override fun onResume() {
        super.onResume()
        mViewPager?.startLoop()
    }

    private fun initRemoteData() {
        AdsServiceImpl.service.getRandomAds().enqueue(
            object : Callback<AdsRandom> {
                override fun onFailure(call: Call<AdsRandom>, t: Throwable) {
                    "실패: $t".putLog("Fail")
                }

                override fun onResponse(call: Call<AdsRandom>, response: Response<AdsRandom>) {
                    Log.d("initRemoteData", response.isSuccessful.toString())
                    response.takeIf { it.isSuccessful }?.body()?.data?.
                        let {
                            val list = ArrayList<BannerData>()
                            list.add(BannerData(it.title, it.subtitle, it.dday, it.thumbnail))
                            setupIndicator(list)
                        } ?: run{
                        Toast.makeText(mContext, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )

        AdsServiceImpl.service.getInterestAds().enqueue(object : Callback<Ads>{
            override fun onFailure(call: Call<Ads>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(call: Call<Ads>, response: Response<Ads>) {
                response.takeIf { it.isSuccessful }?.body()?.data?.
                    let {
                        rcmdAdapter.data = it
                        rcmdAdapter.notifyDataSetChanged()
                    } ?: run{
                    Toast.makeText(mContext, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                }
            }
        })

        AdsServiceImpl.service.getPopularAds().enqueue(object : Callback<Ads>{
            override fun onFailure(call: Call<Ads>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(call: Call<Ads>, response: Response<Ads>) {
                response.takeIf { it.isSuccessful }?.body()?.data?.
                    let {
                        popularAdapter.data = it
                        popularAdapter.notifyDataSetChanged()
                    } ?: run{
                    Toast.makeText(mContext, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                }
            }
        })

        AdsServiceImpl.service.getLatestAds().enqueue(object : Callback<Ads>{
            override fun onFailure(call: Call<Ads>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(call: Call<Ads>, response: Response<Ads>) {
                response.takeIf { it.isSuccessful }?.body()?.data?.
                    let {
                        recentAdapter.data = it
                        recentAdapter.notifyDataSetChanged()
                    } ?: run{
                    Toast.makeText(mContext, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initLocalData() {
        val title = arrayOf("Christmas Soap", "aaa", "bbb","ccc", "ddd")
        val des = arrayOf("크리스마스 비누 2구 세트", "aaa", "bbb","ccc", "ddd")
        val dday = arrayOf("D-7", "D-1", "D-14","D-2", "D-4")
        val imgs = arrayOf(R.drawable.img_main_banner, R.drawable.img_main_banner, R.drawable.img_main_banner, R.drawable.img_main_banner, R.drawable.img_main_banner)

        val list = ArrayList<BannerData>()
        for(i in 0..4){
            val bean = BannerData()
            bean.imageTitle = title[i]
            bean.imageDescription = des[i]
            bean.imageDday = dday[i]
            bean.imgLocalUrl = imgs[i]
            list.add(bean)
        }
        mBannerList = list
    }

    private fun initBanner(view: View) {
        mViewPager = view.findViewById(R.id.ad_view_pager)
        mViewPager!!.setIndicatorGap(BannerUtils.dp2px(6f))
            .setRoundCorner(BannerUtils.dp2px(6f))
            .setHolderCreator{ BannerVH() }
    }

    private fun initAdapter(view: View) {
        rcmdAdapter = AdsHorizontalAdapter(mContext)
        view.rv_ad_recommend.adapter = rcmdAdapter
        view.rv_ad_recommend.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)

        popularAdapter = AdsHorizontalAdapter(mContext)
        view.rv_ad_popular.adapter = popularAdapter
        view.rv_ad_popular.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)

        recentAdapter = AdsHorizontalAdapter(mContext)
        view.rv_ad_recent.adapter = recentAdapter
        view.rv_ad_recent.layoutManager =
            GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun setupIndicator(list: MutableList<BannerData>) {
        mViewPager!!.setIndicatorStyle(IndicatorStyle.DASH)
            .setIndicatorHeight(5)
            .setIndicatorGravity(IndicatorGravity.CENTER)
            .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            .setIndicatorGap(0)
            .setPageMargin(resources.getDimensionPixelOffset(R.dimen.dp_3))
            .setIndicatorWidth(200)
            .setIndicatorColor(
                Color.parseColor("#c9cdd2"),
                Color.parseColor("#000000")
            ).create(list)
    }
}