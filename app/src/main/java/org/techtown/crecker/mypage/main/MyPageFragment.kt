package org.techtown.crecker.mypage.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import kotlinx.android.synthetic.main.rectangle.view.*

import org.techtown.crecker.R
import org.techtown.crecker.mypage.advertise.MyAdvertiseActivity
import org.techtown.crecker.mypage.cash.CashActivity

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

        v.my_tv_apply.setOnClickListener { goMyAdvertise(0) }
        v.my_tv_assign.setOnClickListener { goMyAdvertise(1) }
        v.my_tv_check.setOnClickListener { goMyAdvertise(2) }
        v.my_tv_fin.setOnClickListener { goMyAdvertise(3) }
        return v
    }

    private fun goMyAdvertise(idx: Int){
        mContext.startActivity(
            Intent(mContext, MyAdvertiseActivity::class.java)
                .apply {
                    putExtra("index", idx)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
        )
    }
}
