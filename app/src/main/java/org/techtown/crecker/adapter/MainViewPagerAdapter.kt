package org.techtown.crecker.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainViewPagerAdapter (fm : FragmentManager, val context: Context) : FragmentStatePagerAdapter(fm) {

    var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}