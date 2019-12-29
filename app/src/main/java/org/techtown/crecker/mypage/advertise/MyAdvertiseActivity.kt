package org.techtown.crecker.mypage.advertise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_my_advertise.*
import org.techtown.crecker.R

class MyAdvertiseActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_advertise)

        viewPagerAdapter = PagerAdapter(supportFragmentManager, this)

        ad_pager.apply {
            adapter = viewPagerAdapter
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(advertise_tabLayout))
            currentItem = intent.getIntExtra("index", 0)
        }

        advertise_tabLayout.apply {
            setupWithViewPager(ad_pager)
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabReselected(p0: TabLayout.Tab?) {}

                override fun onTabUnselected(p0: TabLayout.Tab?) {}

                override fun onTabSelected(p0: TabLayout.Tab?) {}
            })
        }

        for(i in 1..advertise_tabLayout.tabCount)
            advertise_tabLayout.getTabAt(i)?.customView =
                LayoutInflater.from(this).inflate(R.layout.my_ad_tab_layout, advertise_tabLayout, false)
    }
}
