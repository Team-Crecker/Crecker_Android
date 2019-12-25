package org.techtown.crecker.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab_button.view.*
import org.techtown.crecker.R
import org.techtown.crecker.main.adapter.MainViewPagerAdapter
import org.techtown.crecker.home.HomeFragment
import org.techtown.crecker.fragment.AdsFragment
import org.techtown.crecker.fragment.LawFragment
import org.techtown.crecker.fragment.MyPageFragment
import org.techtown.crecker.fragment.NewsFragment

class MainActivity : AppCompatActivity() {
    lateinit private var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = applicationContext

    //뷰페이저와 탭레이아웃 장착
        initViewPager()
    }

    private fun initViewPager() {
        val viewPagerAdapter =
            MainViewPagerAdapter(
                supportFragmentManager,
                this
            ) // MainViewPagerAdapter 생성
        viewPagerAdapter.addItems(HomeFragment())
        viewPagerAdapter.addItems(AdsFragment())
        viewPagerAdapter.addItems(LawFragment())
        viewPagerAdapter.addItems(NewsFragment())
        viewPagerAdapter.addItems(MyPageFragment())

        main_viewPager.adapter = viewPagerAdapter
        main_tabLayout.setupWithViewPager(main_viewPager)

        main_tabLayout.getTabAt(0)?.setCustomView(initCustomView(0)) // Home 로고
        main_tabLayout.getTabAt(1)?.setCustomView(initCustomView(1)) // Ads 로고
        main_tabLayout.getTabAt(2)?.setCustomView(initCustomView(2)) // Law 로고
        main_tabLayout.getTabAt(3)?.setCustomView(initCustomView(3)) // News 로고
        main_tabLayout.getTabAt(4)?.setCustomView(initCustomView(4)) // Mypage 로고

        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {}

        })
    }

    private fun initCustomView(position : Int) : View {
        var tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_button, null)

        when(position){
            0 ->{
                tabView.Tab_ic.setImageResource(R.drawable.select_tab_home)
                return tabView
            }

            1->{
                tabView.Tab_ic.setImageResource(R.drawable.select_tab_ads)
                return tabView
            }
            2->{
                tabView.Tab_ic.setImageResource(R.drawable.select_tab_law)
                return tabView
            }
            3->{
                tabView.Tab_ic.setImageResource(R.drawable.select_tab_news)
                return tabView

            }
            4->{
                tabView.Tab_ic.setImageResource(R.drawable.select_tab_mypage)
                return tabView
            }
            else ->{
                return tabView
            }
        }
    }
}
