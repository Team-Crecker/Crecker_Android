package org.techtown.crecker.ads.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.techtown.crecker.R


class AdsCtgFragment(private val category: String?) : Fragment() {
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ad_detail, container, false)
        view.findViewById<TextView>(R.id.tv_title).text = category
        return view
    }
}