package org.techtown.crecker.mypage.advertise

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import org.techtown.crecker.mypage.advertise.fragment.AssignFragment
import org.techtown.crecker.mypage.advertise.fragment.ApplyFragment
import org.techtown.crecker.mypage.advertise.fragment.CheckFragment
import org.techtown.crecker.mypage.advertise.fragment.FinFragment

const val TAB_COUNT = 4

class PagerAdapter (fm : FragmentManager, val context: Context)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val titles = arrayOf("신청", "배정", "검토", "완료")

    override fun getItem(position: Int): Fragment{
        return when(position){
            0 -> ApplyFragment()
            1 -> AssignFragment()
            2 -> CheckFragment()
            else -> FinFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getCount(): Int = TAB_COUNT
}