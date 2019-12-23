package org.techtown.crecker.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.crecker.R
import org.techtown.crecker.adapter.MainViewPagerAdapter
import org.techtown.crecker.feature.home.HomeFragment
import org.techtown.crecker.fragment.AdsFragment
import org.techtown.crecker.fragment.LawFragment
import org.techtown.crecker.fragment.MyPageFragment
import org.techtown.crecker.fragment.NewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //뷰페이저와 탭레이아웃 장착
        initViewPager()
    }

    private fun initViewPager() {
        val viewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, this) // MainViewPagerAdapter 생성
        viewPagerAdapter.addItems(HomeFragment())
        viewPagerAdapter.addItems(AdsFragment())
        viewPagerAdapter.addItems(LawFragment())
        viewPagerAdapter.addItems(NewsFragment())
        viewPagerAdapter.addItems(MyPageFragment())

        main_viewPager.adapter = viewPagerAdapter
        main_tabLayout.setupWithViewPager(main_viewPager)

        main_tabLayout.getTabAt(0)?.setIcon(R.drawable.tab_home) // Home 로고
        main_tabLayout.getTabAt(1)?.setIcon(R.drawable.tab_ad) // Ads 로고
        main_tabLayout.getTabAt(2)?.setIcon(R.drawable.tab_expert) // Law 로고
        main_tabLayout.getTabAt(3)?.setIcon(R.drawable.tab_news) // News 로고
        main_tabLayout.getTabAt(4)?.setIcon(R.drawable.tab_mypage) // Mypage 로고

        main_tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                when(p0?.position){
                    0 ->{
                        main_tabLayout.getTabAt(0)?.setIcon(R.drawable.tab_home)
                    }

                    1 -> {
                        main_tabLayout.getTabAt(1)?.setIcon(R.drawable.tab_ad)
                    }
                    3-> {
                        main_tabLayout.getTabAt(3)?.setIcon(R.drawable.tab_news)
                    }
                }
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                    when(p0?.position){
                        0 -> {
                            main_tabLayout.getTabAt(0)?.setIcon(R.drawable.tab_home_filled)
                        }
                        1 ->{
                            main_tabLayout.getTabAt(1)?.setIcon(R.drawable.tab_ad_filled)
                        }
                        3 ->{
                            main_tabLayout.getTabAt(3)?.setIcon(R.drawable.tab_news_filled)
                        }
                    }

            }
        })
    }
}
