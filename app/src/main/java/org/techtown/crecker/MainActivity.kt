package org.techtown.crecker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.crecker.Adapter.MainViewPagerAdapter
import org.techtown.crecker.Fragment.*

class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val adsFragment = AdsFragment()
    val lawFragment = LawFragment()
    val newsFragment = NewsFragment()
    val mypageFragment = MyPageFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        뷰페이저와 탭레이아웃 장착
        initViewPager()
    }

    private fun initViewPager() {

        main_tabLayout.addTab(main_tabLayout.newTab().setText("One"))
        main_tabLayout.addTab(main_tabLayout.newTab().setText("Two"))
        main_tabLayout.addTab(main_tabLayout.newTab().setText("Three"))
        main_tabLayout.addTab(main_tabLayout.newTab().setText("Four"))
        main_tabLayout.addTab(main_tabLayout.newTab().setText("Five"))

        val viewPagerAdapter = MainViewPagerAdapter(supportFragmentManager) // MainViewPagerAdapter 생성
        viewPagerAdapter.addItems(homeFragment)
        viewPagerAdapter.addItems(adsFragment)
        viewPagerAdapter.addItems(lawFragment)
        viewPagerAdapter.addItems(newsFragment)
        viewPagerAdapter.addItems(mypageFragment)

        main_viewPager.adapter = viewPagerAdapter
        main_tabLayout.setupWithViewPager(main_viewPager)
    }
}
