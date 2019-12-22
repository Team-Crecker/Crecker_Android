package org.techtown.crecker.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import org.techtown.crecker.R


class MainViewPagerAdapter (fm : FragmentManager, val context: Context) : FragmentStatePagerAdapter(fm) {
    private val titles = intArrayOf(R.string.home, R.string.ads, R.string.law, R.string.news, R.string.mypage)

    private var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = context.getString(titles[position])

    fun addItems(fragment : Fragment){
        fragments.add(fragment)
    }
}