package org.techtown.crecker.feature.ads

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.IndicatorGravity
import com.zhpan.bannerview.constants.IndicatorSlideMode
import com.zhpan.bannerview.constants.IndicatorStyle
import com.zhpan.bannerview.utils.BannerUtils
import org.techtown.crecker.R
import java.util.ArrayList

class AdsFragment : Fragment() {
    private var mDrawableList: MutableList<BannerData> = ArrayList()
    private var mViewPager: BannerViewPager<BannerData, BannerVH>? = null
    private lateinit var mContext: Context

    private val title = arrayOf("Christmas Soap", "aaa", "bbb","ccc", "ddd")
    private val des = arrayOf("크리스마스 비누 2구 세트", "aaa", "bbb","ccc", "ddd")
    private val dday = arrayOf("D-7", "D-1", "D-14","D-2", "D-4")
    private val imgs = arrayOf(R.drawable.img_main_banner, R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t0)

    lateinit var goDropDown: ImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ads, container, false)
        initData()
        initView(view)
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

    private fun initData() {
        //Log.d("asdf", "리스트 생성")
        val list = ArrayList<BannerData>()
        for(i in 0..4){
            val bean = BannerData()
            bean.imageTitle = title[i]
            bean.imageDescription = des[i]
            bean.imageDday = dday[i]
            bean.imgLocalUrl = imgs[i]
            list.add(bean)
            //Log.d("asdf", "타이틀: ${bean.imageTitle}")
        }
        mDrawableList = list
        //Log.d("asdf", "리스트 생성 끝")
    }

    private fun initView(view: View) {
        mViewPager = view.findViewById(R.id.ad_view_pager)
        mViewPager!!.setIndicatorGap(BannerUtils.dp2px(6f))
            .setRoundCorner(BannerUtils.dp2px(6f))
            .setHolderCreator{ BannerVH() }
        setupIndicator()

        goDropDown = view.findViewById(R.id.dropdown)
        goDropDown.setOnClickListener {
            (context as Activity).startActivityForResult(Intent(mContext, CategoryActivity::class.java), 7777)
        }
    }

    private fun setupIndicator() {
        mViewPager!!.setIndicatorStyle(IndicatorStyle.DASH)
            .setIndicatorHeight(resources.getDimensionPixelOffset(R.dimen.dp_3))
            .setIndicatorGravity(IndicatorGravity.CENTER)
            .setIndicatorSlideMode(IndicatorSlideMode.NORMAL)
            .setIndicatorGap(resources.getDimensionPixelOffset(R.dimen.dp_3))
            .setPageMargin(0)
            .setIndicatorWidth(
                resources.getDimensionPixelOffset(R.dimen.dp_3),
                resources.getDimensionPixelOffset(R.dimen.dp_10)
            )
            .setIndicatorColor(
                Color.parseColor("#888888"),
                Color.parseColor("#118EEA")
            ).create(mDrawableList)
    }
}
