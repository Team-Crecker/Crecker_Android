package org.techtown.crecker.mypage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_mypage.view.*

import org.techtown.crecker.R

class MyPageFragment : Fragment() {
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypage, container, false)
        v.btn_showCash.setOnClickListener {
            startActivity(Intent(mContext, CashActivity::class.java))
        }
        v.imageView2.setOnClickListener {
            startActivity(Intent(mContext, CashActivity::class.java))
        }
        return v
    }
}
