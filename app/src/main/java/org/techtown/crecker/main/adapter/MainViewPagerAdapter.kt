package org.techtown.crecker.main.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import org.techtown.crecker.R


class MainViewPagerAdapter (fm : FragmentManager, val context: Context) : FragmentStatePagerAdapter(fm) {

    var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    public fun change(fChange : Fragment , position : Int){
        fragments.set(position, fChange)
    }
}