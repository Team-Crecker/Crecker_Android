package org.techtown.crecker.feature.ads

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_ad_detail.*
import org.techtown.crecker.R

class DetailFragment : Fragment() {
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ad_detail, container, false)

        val title = CategoryState.category
        tv_title.text = title
        dropdown.setOnClickListener {
            (context as Activity).startActivityForResult(Intent(mContext, CategoryActivity::class.java), 7777)
        }

        return view
    }
}
