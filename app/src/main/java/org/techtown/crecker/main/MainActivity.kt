package org.techtown.crecker.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab_button.view.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.fragment.AdsFragment
import org.techtown.crecker.ads.category.CtgResultEvent
import org.techtown.crecker.ads.category.EventBus
import org.techtown.crecker.mypage.main.MyPageFragment
import org.techtown.crecker.law.LawFragment
import org.techtown.crecker.news.NewsFragment

import org.techtown.crecker.home.HomeFragment
import org.techtown.crecker.main.adapter.MainViewPagerAdapter
import org.techtown.crecker.ads.category.FragmentCommunicator
import org.techtown.crecker.ads.fragment.OnBackPressed
import org.techtown.crecker.ads.fragment.putLog


class MainActivity : AppCompatActivity() {
    private lateinit var mContext : Context
    private lateinit var viewPagerAdapter: MainViewPagerAdapter
    private lateinit var fragments: ArrayList<Fragment>
    private var fragmentCommunicator: FragmentCommunicator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = applicationContext

        //뷰페이저와 탭레이아웃 장착
        initViewPager()
    }

    override fun onDestroy() {
        android.os.Process.killProcess(android.os.Process.myPid())
        super.onDestroy()
    }

    private fun initViewPager() {
        fragments = arrayListOf(HomeFragment(), AdsFragment(), LawFragment(), NewsFragment(),
            MyPageFragment()
        )

        viewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, this) // MainViewPagerAdapter 생성
        viewPagerAdapter.fragments = fragments

        main_viewPager.adapter = viewPagerAdapter
        main_tabLayout.setupWithViewPager(main_viewPager)

        main_tabLayout.getTabAt(0)?.customView = initCustomView(0) // Home 로고
        main_tabLayout.getTabAt(1)?.customView = initCustomView(1) // Ads 로고
        main_tabLayout.getTabAt(2)?.customView = initCustomView(2) // Law 로고
        main_tabLayout.getTabAt(3)?.customView = initCustomView(3) // News 로고
        main_tabLayout.getTabAt(4)?.customView = initCustomView(4) // MyPage 로고

        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }

    private fun initCustomView(position : Int) : View {
        val tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_button, null)

        when(position){
            0 -> tabView.Tab_ic.setImageResource(R.drawable.select_tab_home)
            1-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_ads)
            2-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_law)
            3-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_news)
            4-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_mypage)
        }
        return tabView
    }

    //광고 탭의 내부 프래그먼트 갱신
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        "받음".putLog()
        fragmentCommunicator?.changeText(data?.getStringExtra("title"))
        fragmentCommunicator?.showBack(data?.getBooleanExtra("isShow", false))
        EventBus.post(CtgResultEvent(requestCode, resultCode, data))
    }

    fun passVal(fragmentCommunicator: FragmentCommunicator) {
        this.fragmentCommunicator = fragmentCommunicator
    }

    override fun onBackPressed() {
        for(i in fragments){
            if(i is OnBackPressed){
                if(!i.onBackPressed()) super.onBackPressed()
            }

        }
    }
}