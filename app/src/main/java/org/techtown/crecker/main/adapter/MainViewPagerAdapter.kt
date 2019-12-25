package org.techtown.crecker.main.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import org.techtown.crecker.R


class MainViewPagerAdapter (fm : FragmentManager, val context: Context) : FragmentStatePagerAdapter(fm) {

    private var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addItems(fragment : Fragment){
        fragments.add(fragment)
    }
}