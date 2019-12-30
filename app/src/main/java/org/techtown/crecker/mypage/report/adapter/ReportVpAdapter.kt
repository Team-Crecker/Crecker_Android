package org.techtown.crecker.mypage.report.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import org.techtown.crecker.mypage.report.fragment.IndividualFragment
import org.techtown.crecker.mypage.report.fragment.TotalFragment

class ReportVpAdapter (fm : FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return TotalFragment.newInstance()
            }
            1 ->{
                return IndividualFragment.newInstance()
            }
            else ->{
                return Fragment()
            }
        }
    }

    override fun getCount(): Int = 2

}