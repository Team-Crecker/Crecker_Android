package org.techtown.crecker.fragment


import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_law.view.*

import org.techtown.crecker.R


class LawFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_law, container, false)

        initFontChange(V)
        return V
    }

    private fun initFontChange(V : View){
        var no1_title = "실명, 개인정보는 NO."
        var spanTitle_01 = SpannableString(no1_title)

        spanTitle_01.setSpan(ForegroundColorSpan(Color.parseColor("#1ec695")),10,12,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanTitle_01.setSpan(StyleSpan(Typeface.BOLD), 10, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        V.must_no_1_title.text = spanTitle_01
    }


}
