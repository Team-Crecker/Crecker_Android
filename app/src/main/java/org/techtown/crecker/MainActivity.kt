package org.techtown.crecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.crecker.adapter.MainViewPagerAdapter
import org.techtown.crecker.fragment.*

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
    }
}
