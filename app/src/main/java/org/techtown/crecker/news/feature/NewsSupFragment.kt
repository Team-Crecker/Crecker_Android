package org.techtown.crecker.news.feature


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.techtown.crecker.R

class NewsSupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_news_sup, container, false)
        val context = V.context

        initRcv(V,context)
        return V
    }

    private fun initRcv(V : View, context : Context){

    }


}
