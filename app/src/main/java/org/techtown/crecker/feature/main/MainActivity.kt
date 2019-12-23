package org.techtown.crecker.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.crecker.R
import org.techtown.crecker.adapter.MainViewPagerAdapter
import org.techtown.crecker.feature.ads.AdsFragment
import org.techtown.crecker.feature.home.HomeFragment
import org.techtown.crecker.fragment.LawFragment
import org.techtown.crecker.feature.mypage.MyPageFragment
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

        main_tabLayout.getTabAt(0)?.setIcon(android.R.drawable.ic_menu_camera) // Home 로고
        main_tabLayout.getTabAt(1)?.setIcon(android.R.drawable.ic_menu_camera) // Ads 로고
        main_tabLayout.getTabAt(2)?.setIcon(android.R.drawable.ic_menu_camera) // Law 로고
        main_tabLayout.getTabAt(3)?.setIcon(android.R.drawable.ic_menu_camera) // News 로고
        main_tabLayout.getTabAt(4)?.setIcon(android.R.drawable.ic_menu_camera) // Mypage 로고
    }
}
