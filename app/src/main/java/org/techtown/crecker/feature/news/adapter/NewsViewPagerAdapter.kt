package org.techtown.crecker.feature.news.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class NewsViewPagerAdapter (fm : FragmentManager) : FragmentStatePagerAdapter(fm){
    private var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        Log.d("adapter","getItem")
        return fragments[position]
    }

    override fun getCount(): Int {
        Log.d("adapter","getCount")
        return fragments.size
    }

    fun addItems(fragment : Fragment){
        fragments.add(fragment)
        Log.d("adapter","addItems")
    }
}