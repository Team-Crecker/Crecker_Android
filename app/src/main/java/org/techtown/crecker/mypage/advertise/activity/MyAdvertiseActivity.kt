package org.techtown.crecker.mypage.advertise.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_my_advertise.*
import org.techtown.crecker.R
import org.techtown.crecker.mypage.advertise.PagerAdapter

class MyAdvertiseActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_advertise)

        btn_goBack.setOnClickListener { finish() }

        viewPagerAdapter =
            PagerAdapter(supportFragmentManager, this)

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
    }
}
